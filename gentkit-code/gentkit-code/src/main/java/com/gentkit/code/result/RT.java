package com.gentkit.code.result;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;

import java.io.Serializable;

@Getter
public class RT<T> implements Serializable {

    public static <T> RT<T> success(SuccessCode code, String message, T data) {
        return new RT<>(true, code, message, data);
    }

    public static <T> RT<T> success(SuccessCode code, String message) {
        return new RT<>(true, code, message, null);
    }

    public static <T> RT<T> success(SuccessCode code, T data) {
        return new RT<>(true, code, code.getMessage(), data);
    }

    public static <T> RT<T> success(String message, T data) {
        return new RT<>(true, SuccessCode.SUCCESS, message, data);
    }

    public static <T> RT<T> success(ResultCode code) {
        return new RT<>(true, code, code.getMessage(), null);
    }

    public static <T> RT<T> success(String message) {
        return new RT<>(true, SuccessCode.SUCCESS, message, null);
    }

    public static <T> RT<T> success(T data) {
        ResultCode code = SuccessCode.SUCCESS;
        return new RT<>(true, code, code.getMessage(), data);
    }

    public static <T> RT<T> success() {
        ResultCode code = SuccessCode.SUCCESS;
        return new RT<>(true, code, code.getMessage(), null);
    }

    public static <T> RT<T> failure(FailureCode code, String message, T data) {
        return new RT<>(false, code, message, data);
    }

    public static <T> RT<T> failure(FailureCode code, String message) {
        return new RT<>(false, code, message, null);
    }

    public static <T> RT<T> failure(FailureCode code, T data) {
        return new RT<>(false, code, code.getMessage(), data);
    }

    public static <T> RT<T> failure(String message, T data) {
        return new RT<>(false, FailureCode.SYSTEM_ERROR, message, data);
    }

    public static <T> RT<T> failure(FailureCode code) {
        return new RT<>(false, code, code.getMessage(), null);
    }

    public static <T> RT<T> failure(String message) {
        return new RT<>(false, FailureCode.SYSTEM_ERROR, message, null);
    }

    public static <T> RT<T> failure(T data) {
        ResultCode code = FailureCode.SYSTEM_ERROR;
        return new RT<>(false, code, code.getMessage(), data);
    }

    public static <T> RT<T> failure() {
        ResultCode code = FailureCode.SYSTEM_ERROR;
        return new RT<>(false, code, code.getMessage(), null);
    }

    private final boolean success;

    private final String code;

    private final String reason;

    private final String message;

    private final T data;

    private RT(boolean success, ResultCode code, String message, T data) {
        this.success = success;
        this.code = code.getCode();
        this.reason = code.getReason();
        this.message = message;
        this.data = data;
    }

    @Override
    public String toString() {
        try {
            return new ObjectMapper().writeValueAsString(this);
        } catch (Throwable ex) {
            return super.toString();
        }
    }
}
