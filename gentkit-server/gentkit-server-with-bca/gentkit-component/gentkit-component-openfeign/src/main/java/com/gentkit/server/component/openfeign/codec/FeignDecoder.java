package com.gentkit.server.component.openfeign.codec;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gentkit.common.result.enums.ResultCategoryEnum;
import com.gentkit.common.result.model.FailureResultStatus;
import com.gentkit.common.result.model.Result;
import com.gentkit.exception.GlobalException;
import com.gentkit.web.http.enums.HttpStatusCodeEnum;
import feign.FeignException;
import feign.Response;
import feign.Util;
import feign.codec.DecodeException;
import feign.codec.Decoder;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Map;

public class FeignDecoder implements Decoder {

    @Override
    public Object decode(Response response, Type type) throws IOException, DecodeException, FeignException {
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
                result = Result.failure(status, resultMap.get("data"));
                throw new GlobalException((FailureResultStatus) result.getStatus());
            }
        } else {
            FailureResultStatus resultStatus = FailureResultStatus.objOf(String.format("%08d", response.status()));
            throw new GlobalException(resultStatus != null ? resultStatus : FailureResultStatus.SYSTEM_ERROR, response.reason());
        }
    }
}
