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
package com.gentkit.common.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;

import java.io.Serializable;

@Getter
public class Result<T> implements Serializable {

    public static <T> Result<T> success(SuccessCode code, String message, T data) {
        return new Result<>(true, code, message, data);
    }

    public static <T> Result<T> success(SuccessCode code, String message) {
        return new Result<>(true, code, message, null);
    }

    public static <T> Result<T> success(SuccessCode code, T data) {
        return new Result<>(true, code, code.getMessage(), data);
    }

    public static <T> Result<T> success(String message, T data) {
        return new Result<>(true, SuccessCode.SUCCESS, message, data);
    }

    public static <T> Result<T> success(ResultCode code) {
        return new Result<>(true, code, code.getMessage(), null);
    }

    public static <T> Result<T> success(String message) {
        return new Result<>(true, SuccessCode.SUCCESS, message, null);
    }

    public static <T> Result<T> success(T data) {
        ResultCode code = SuccessCode.SUCCESS;
        return new Result<>(true, code, code.getMessage(), data);
    }

    public static <T> Result<T> success() {
        ResultCode code = SuccessCode.SUCCESS;
        return new Result<>(true, code, code.getMessage(), null);
    }

    public static <T> Result<T> failure(FailureCode code, String message, T data) {
        return new Result<>(false, code, message, data);
    }

    public static <T> Result<T> failure(FailureCode code, String message) {
        return new Result<>(false, code, message, null);
    }

    public static <T> Result<T> failure(FailureCode code, T data) {
        return new Result<>(false, code, code.getMessage(), data);
    }

    public static <T> Result<T> failure(String message, T data) {
        return new Result<>(false, FailureCode.SYSTEM_ERROR, message, data);
    }

    public static <T> Result<T> failure(FailureCode code) {
        return new Result<>(false, code, code.getMessage(), null);
    }

    public static <T> Result<T> failure(String message) {
        return new Result<>(false, FailureCode.SYSTEM_ERROR, message, null);
    }

    public static <T> Result<T> failure(T data) {
        ResultCode code = FailureCode.SYSTEM_ERROR;
        return new Result<>(false, code, code.getMessage(), data);
    }

    public static <T> Result<T> failure() {
        ResultCode code = FailureCode.SYSTEM_ERROR;
        return new Result<>(false, code, code.getMessage(), null);
    }

    private final boolean success;

    private final String code;

    private final String reason;

    private final String message;

    private final T data;

    private Result(boolean success, ResultCode code, String message, T data) {
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
