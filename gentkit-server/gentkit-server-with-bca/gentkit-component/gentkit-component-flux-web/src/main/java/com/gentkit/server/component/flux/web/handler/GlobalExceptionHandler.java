package com.gentkit.server.component.flux.web.handler;

import com.gentkit.common.result.model.FailureResultStatus;
import com.gentkit.common.result.model.Result;
import com.gentkit.exception.GlobalException;
import com.gentkit.logger.utils.LoggerUtils;
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
public class GlobalExceptionHandler {

    @ExceptionHandler(GlobalException.class)
    public ResponseEntity<Result<?>> handleGlobalException(GlobalException e) {
        FailureResultStatus status = FailureResultStatus.SYSTEM_ERROR;
        Object data = null;

        return ResponseEntity.status(HttpStatus.OK)
                .contentType(new MediaType(MediaType.APPLICATION_JSON, StandardCharsets.UTF_8))
                .body(Result.failure(status, e.getMessage(), data));
    }

    @ExceptionHandler(UnsupportedMediaTypeStatusException.class)
    public ResponseEntity<Result<?>> handleUnsupportedMediaTypeStatusException(UnsupportedMediaTypeStatusException e) {
        FailureResultStatus status = FailureResultStatus.UNSUPPORTED_MEDIA_TYPE;
        String message = status.getMessage();

        return handleGlobalException(new GlobalException(message, e));
    }

    @ExceptionHandler(Throwable.class)
    public ResponseEntity<Result<?>> handleThrowable(Throwable e) {
        if (e instanceof GlobalException e1) {
            return handleGlobalException(e1);
        }

        LoggerUtils.getLogger(GlobalExceptionHandler.class).error(e);

        FailureResultStatus status = FailureResultStatus.SYSTEM_ERROR;
        String message = status.getMessage();

        return handleGlobalException(new GlobalException(status, message, e));
    }
}
