/*
 * MIT License
 *
 * Copyright (c) 2025 田隆 (Len)
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package com.gentkit.server.component.flux.web.handler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gentkit.common.result.model.Result;
import org.springframework.core.MethodParameter;
import org.springframework.core.annotation.Order;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.reactive.HandlerResult;
import org.springframework.web.reactive.HandlerResultHandler;
import org.springframework.web.reactive.result.method.InvocableHandlerMethod;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;
import java.util.Objects;

@Order(-1)
public class SuccessResultHandler implements HandlerResultHandler {

    @Override
    public boolean supports(HandlerResult result) {
        Object handler = result.getHandler();
        if (handler != null && handler instanceof InvocableHandlerMethod sHandler) {
            return sHandler.getBeanType() != FailureResultHandler.class;
        }

        MethodParameter returnType = result.getReturnTypeSource();
        String className = returnType.getDeclaringClass().getName();
        if (className.contains("Actuator") || className.contains("Swagger")) {
            return false;
        }

        return !returnType.getParameterType().equals(Result.class);
    }

    @Override
    public Mono<Void> handleResult(ServerWebExchange exchange, HandlerResult result) {
        ServerHttpResponse response = exchange.getResponse();

        Object body = result.getReturnValue();

        ObjectMapper objectMapper = new ObjectMapper();

        response.getHeaders().setContentType(new MediaType(MediaType.APPLICATION_JSON, StandardCharsets.UTF_8));

        Mono<Result> responseMono = wrapBody(body);
        return responseMono
                .flatMap(apiResponse -> {
                    DataBuffer buffer;
                    try {
                        buffer = response.bufferFactory()
                                .wrap(objectMapper.writeValueAsBytes(apiResponse));
                    } catch (JsonProcessingException e) {
                        throw new RuntimeException(e);
                    }
                    return response.writeWith(Flux.just(buffer));
                })
                .then();
    }

    private Mono<Result> wrapBody(Object body) {
        if (Objects.isNull(body)) {
            return Mono.just(Result.success());
        }

        if (body instanceof Result) {
            return Mono.just((Result) body);
        }

        if (body instanceof Mono) {
            return ((Mono<?>) body).map(aaa -> {
                if (aaa instanceof Result bbb) {
                    return bbb;
                }
                return Result.success(aaa);
            });
        }

        if (body instanceof Flux) {
            return ((Flux<?>) body).collectList().map(aaa -> {
                if (aaa instanceof Result bbb) {
                    return bbb;
                }
                return Result.success(aaa);
            });
        }

        return Mono.just(Result.success(body));
    }
}