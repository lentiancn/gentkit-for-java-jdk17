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

import com.gentkit.common.result.model.FailureResultStatus;
import com.gentkit.common.result.model.Result;
import com.gentkit.common.GlobalException;
import com.gentkit.logger.utils.LoggerUtils;
import feign.FeignException;
import feign.RetryableException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.UnsupportedMediaTypeStatusException;

import java.nio.charset.StandardCharsets;

@Order(Ordered.HIGHEST_PRECEDENCE)
@RestControllerAdvice
public class FailureResultHandler {

    @ExceptionHandler(GlobalException.class)
    public ResponseEntity<Result<?>> handleGlobalException(GlobalException e) {
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(new MediaType(MediaType.APPLICATION_JSON, StandardCharsets.UTF_8))
                .body(Result.failure(e.getStatus(), e.getMessage(), null));
    }

    @ExceptionHandler(UnsupportedMediaTypeStatusException.class)
    public ResponseEntity<Result<?>> handleUnsupportedMediaTypeStatusException(UnsupportedMediaTypeStatusException e) {
        LoggerUtils.getLogger(getClass()).error(e);

        FailureResultStatus status = FailureResultStatus.UNSUPPORTED_MEDIA_TYPE;
        String message = status.getMessage();

        return handleGlobalException(new GlobalException(status, message, e));
    }

    @ExceptionHandler(RetryableException.class)
    public ResponseEntity<Result<?>> handleRetryableException(RetryableException e) {
        LoggerUtils.getLogger(getClass()).error(e);

        FailureResultStatus status = FailureResultStatus.SYSTEM_ERROR;
        String message = status.getMessage();

        return handleGlobalException(new GlobalException(status, message, e));
    }

    @ExceptionHandler(FeignException.class)
    public ResponseEntity<Result<?>> handleFeignException(FeignException e) {
        LoggerUtils.getLogger(getClass()).error(e);

        FailureResultStatus status = FailureResultStatus.SYSTEM_ERROR;
        String message = status.getMessage();

        return handleGlobalException(new GlobalException(status, message, e));
    }

    @ExceptionHandler(FeignException.NotFound.class)
    public ResponseEntity<Result<?>> handleFeignExceptionNotFound(FeignException.NotFound e) {
        LoggerUtils.getLogger(getClass()).error(e);

        FailureResultStatus status = FailureResultStatus.SYSTEM_ERROR;
        String message = status.getMessage();

        return handleGlobalException(new GlobalException(status, message, e));
    }

    @ExceptionHandler(Throwable.class)
    public ResponseEntity<Result<?>> handleThrowable(Throwable e) {
        if (e instanceof GlobalException e1) {
            return handleGlobalException(e1);
        }

        LoggerUtils.getLogger(getClass()).error(e);

        FailureResultStatus status = FailureResultStatus.SYSTEM_ERROR;
        String message = status.getMessage();

        return handleGlobalException(new GlobalException(status, message, e));
    }
}
