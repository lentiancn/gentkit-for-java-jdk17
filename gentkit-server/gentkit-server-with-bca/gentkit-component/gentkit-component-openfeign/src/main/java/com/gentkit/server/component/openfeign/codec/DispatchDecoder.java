package com.gentkit.server.component.openfeign.codec;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gentkit.common.result.enums.ResultCategoryEnum;
import com.gentkit.common.result.model.FailureResultStatus;
import com.gentkit.common.result.model.Result;
import com.gentkit.common.GlobalException;
import com.gentkit.logger.utils.LoggerUtils;
import com.gentkit.web.http.enums.HttpStatusCodeEnum;
import feign.FeignException;
import feign.Response;
import feign.Util;
import feign.codec.Decoder;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

public class DispatchDecoder implements Decoder {

    private Decoder delegate;

    public DispatchDecoder(Decoder delegate) {
        this.delegate = delegate;
    }

    @Override
    public Object decode(Response response, Type type) throws IOException, FeignException {
        String contentType = response.headers().getOrDefault("Content-Type", List.of("other")).iterator().next().toLowerCase();

        // 猜测可能的 json MIME 类型。TODO 稍后维护硬编码内容到Nacos里
        if (!contentType.contains("application/json") && !contentType.contains("text/plain")) {
            // 非 json 类型按照原始方式处理
            return delegate.decode(response, type);
        }

        // 文件名 和 MIME 类型不匹配报警告
        warningIfFileNameAndMimeTypeNotMatch(response, contentType);

        if (response.status() == HttpStatusCodeEnum.OK.getStatusCode()) {
            String body = Util.toString(response.body().asReader(Util.UTF_8));
            ObjectMapper objectMapper = new ObjectMapper();

            Map<String, Object> resultMap = objectMapper.readValue(body, Map.class);
            Result<?> result;
            if (ResultCategoryEnum.SUCCESS.getCategory().equalsIgnoreCase(resultMap.get("result") + "")) {
                return resultMap.get("data");
            } else {
                Map<String, Object> statusMap = (Map<String, Object>) resultMap.get("status");

                FailureResultStatus status = new FailureResultStatus((String) statusMap.get("code"), (String) statusMap.get("reason"), (String) statusMap.get("message"));
                throw new GlobalException(status);
            }
        } else {
            FailureResultStatus resultStatus = FailureResultStatus.objOf(String.format("%08d", response.status()));
            throw new GlobalException(resultStatus != null ? resultStatus : FailureResultStatus.SYSTEM_ERROR, response.reason());
        }
    }

    private void warningIfFileNameAndMimeTypeNotMatch(Response response, String contentType) {
        String url = response.request().url();
        String resourceName = url.substring(url.lastIndexOf("/"));
        if (!resourceName.contains(".") || resourceName.toLowerCase().endsWith(".json") || resourceName.toLowerCase().endsWith(".json5")) {
            return;
        }
        String resourceSuffix = resourceName.substring(resourceName.lastIndexOf("."));
        LoggerUtils.warn(DispatchDecoder.class, url + " 的 Content-Type 是 " + contentType + "，但后缀 “" + resourceSuffix + "” 不是一个json资源的正确命名。请规范 " + url + " 成：.json 或 去掉后缀");
    }
}
//>>>>>>>>>>>>>>> feign contentType: [application/json;charset=UTF-8]
//>>>>>>>>>>>>>>> feign 请求url: http://127.0.0.1:9922/demo/index.json
//>>>>>>>>>>>>>>> feign 堆栈信息: java.base/java.lang.Thread.getStackTrace(Thread.java:1619)
//com.gentkit.server.component.openfeign.codec.FeignDecoder.decode(FeignDecoder.java:26)
//feign.InvocationContext.decode(InvocationContext.java:114)
//feign.InvocationContext.proceed(InvocationContext.java:88)
//feign.ResponseHandler.handleResponse(ResponseHandler.java:63)
//feign.SynchronousMethodHandler.executeAndDecode(SynchronousMethodHandler.java:114)
//feign.SynchronousMethodHandler.invoke(SynchronousMethodHandler.java:70)
