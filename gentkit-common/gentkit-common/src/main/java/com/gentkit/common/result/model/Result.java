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
package com.gentkit.common.result.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gentkit.common.result.enums.ResultCategoryEnum;
import com.gentkit.common.traceid.TraceIdContext;
import lombok.Getter;

import java.io.Serializable;

@Getter
public class Result<T> implements Cloneable, Serializable {

    private final String traceId;
    private final String result;
    private final ResultStatus status;
    private final T data;

    private Result(boolean success, ResultStatus status, String message, T data) {
        this.traceId = TraceIdContext.get();
        this.result = ResultCategoryEnum.enumOf(success).getCategory();
        this.status = new ResultStatus(status.getCode(), status.getReason(), message != null && !message.trim().isEmpty() ? message.trim() : status.getMessage());
        this.data = data;
    }

    public static <T> Result<T> success(SuccessResultStatus status, String message, T data) {
        return new Result<>(true, status, message, data);
    }

    public static <T> Result<T> success(SuccessResultStatus status, String message) {
        return new Result<>(true, status, message, null);
    }

    public static <T> Result<T> success(SuccessResultStatus status, T data) {
        return new Result<>(true, status, status.getMessage(), data);
    }

    public static <T> Result<T> success(String message, T data) {
        return new Result<>(true, SuccessResultStatus.SUCCESS, message, data);
    }

    public static <T> Result<T> success(ResultStatus status) {
        return new Result<>(true, status, status.getMessage(), null);
    }

    public static <T> Result<T> success(String message) {
        return new Result<>(true, SuccessResultStatus.SUCCESS, message, null);
    }

    public static <T> Result<T> success(T data) {
        ResultStatus status = SuccessResultStatus.SUCCESS;
        return new Result<>(true, status, status.getMessage(), data);
    }

    public static <T> Result<T> success() {
        ResultStatus status = SuccessResultStatus.SUCCESS;
        return new Result<>(true, status, status.getMessage(), null);
    }

    public static <T> Result<T> failure(FailureResultStatus status, String message, T data) {
        return new Result<>(false, status, message, data);
    }

    public static <T> Result<T> failure(FailureResultStatus status, String message) {
        return new Result<>(false, status, message, null);
    }

    public static <T> Result<T> failure(FailureResultStatus status, T data) {
        return new Result<>(false, status, status.getMessage(), data);
    }

    public static <T> Result<T> failure(String message, T data) {
        return new Result<>(false, FailureResultStatus.SYSTEM_ERROR, message, data);
    }

    public static <T> Result<T> failure(FailureResultStatus status) {
        return new Result<>(false, status, status.getMessage(), null);
    }

    public static <T> Result<T> failure(String message) {
        return new Result<>(false, FailureResultStatus.SYSTEM_ERROR, message, null);
    }

    public static <T> Result<T> failure(T data) {
        ResultStatus status = FailureResultStatus.SYSTEM_ERROR;
        return new Result<>(false, status, status.getMessage(), data);
    }

    public static <T> Result<T> failure() {
        ResultStatus status = FailureResultStatus.SYSTEM_ERROR;
        return new Result<>(false, status, status.getMessage(), null);
    }

    @Override
    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    @Override
    public String toString() {
        Result<T> newResult = (Result<T>) clone();
        if (newResult == null) {
            newResult = ResultCategoryEnum.SUCCESS.getCategory().equalsIgnoreCase(this.result) ? success((SuccessResultStatus) getStatus(), data) : failure((FailureResultStatus) getStatus(), data);
        }

        try {
            return new ObjectMapper().writeValueAsString(newResult);
        } catch (Throwable ex) {
            return super.toString();
        }
    }
}
