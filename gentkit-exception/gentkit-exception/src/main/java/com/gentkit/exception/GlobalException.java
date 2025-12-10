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
package com.gentkit.exception;

import com.gentkit.common.result.model.FailureResultStatus;
import lombok.Getter;

/**
 * 全局异常。<br>
 * 全局異常。<br>
 * Global exception.<br>
 *
 * @author Len (lentiancn@126.com)
 * @since 2025-11-10 23:17
 */
@Getter
public class GlobalException extends RuntimeException {

    /**
     * 失败结果状态<br>失敗結果狀態<br>Failure result status<br>
     */
    private final FailureResultStatus status;

    /**
     * 构造方法。<br>
     * 建構方法。<br>
     * Constructor.<br>
     *
     * @param status  失败结果状态<br>失敗結果狀態<br>Failure result status<br>
     * @param message 异常消息<br>異常訊息<br>Exception message<br>
     * @param cause   异常原因<br>異常原因<br>Exception cause<br>
     * @see #GlobalException(FailureResultStatus, String)
     * @see #GlobalException(FailureResultStatus, Throwable)
     * @see #GlobalException(String, Throwable)
     * @see #GlobalException(FailureResultStatus)
     * @see #GlobalException(String)
     * @see #GlobalException(Throwable)
     * @see #GlobalException()
     */
    public GlobalException(FailureResultStatus status, String message, Throwable cause) {
        super(defaultIfBlank(message, status.getMessage()), cause);

        this.status = status;
    }

    /**
     * 构造方法。<br>
     * 建構方法。<br>
     * Constructor.<br>
     *
     * @param status  失败结果状态<br>失敗結果狀態<br>Failure result status<br>
     * @param message 异常消息<br>異常訊息<br>Exception message<br>
     * @see #GlobalException(FailureResultStatus, String, Throwable)
     * @see #GlobalException(FailureResultStatus, Throwable)
     * @see #GlobalException(String, Throwable)
     * @see #GlobalException(FailureResultStatus)
     * @see #GlobalException(String)
     * @see #GlobalException(Throwable)
     * @see #GlobalException()
     */
    public GlobalException(FailureResultStatus status, String message) {
        super(defaultIfBlank(message, status.getMessage()));

        this.status = status;
    }

    /**
     * 构造方法。<br>
     * 建構方法。<br>
     * Constructor.<br>
     *
     * @param status 失败结果状态<br>失敗結果狀態<br>Failure result status<br>
     * @param cause  异常原因<br>異常原因<br>Exception cause<br>
     * @see #GlobalException(FailureResultStatus, String, Throwable)
     * @see #GlobalException(FailureResultStatus, String)
     * @see #GlobalException(String, Throwable)
     * @see #GlobalException(FailureResultStatus)
     * @see #GlobalException(String)
     * @see #GlobalException(Throwable)
     * @see #GlobalException()
     */
    public GlobalException(FailureResultStatus status, Throwable cause) {
        super(cause);

        this.status = status;
    }

    /**
     * 构造方法。<br>
     * 建構方法。<br>
     * Constructor.<br>
     *
     * @param message 异常消息<br>異常訊息<br>Exception message<br>
     * @param cause   异常原因<br>異常原因<br>Exception cause<br>
     * @see #GlobalException(FailureResultStatus, String, Throwable)
     * @see #GlobalException(FailureResultStatus, String)
     * @see #GlobalException(FailureResultStatus, Throwable)
     * @see #GlobalException(FailureResultStatus)
     * @see #GlobalException(String)
     * @see #GlobalException(Throwable)
     * @see #GlobalException()
     */
    public GlobalException(String message, Throwable cause) {
        super(defaultIfBlank(message, FailureResultStatus.SYSTEM_ERROR.getMessage()), cause);

        this.status = FailureResultStatus.SYSTEM_ERROR;
    }

    /**
     * 构造方法。<br>
     * 建構方法。<br>
     * Constructor.<br>
     *
     * @param status 失败结果状态<br>失敗結果狀態<br>Failure result status<br>
     * @see #GlobalException(FailureResultStatus, String, Throwable)
     * @see #GlobalException(FailureResultStatus, String)
     * @see #GlobalException(FailureResultStatus, Throwable)
     * @see #GlobalException(String, Throwable)
     * @see #GlobalException(String)
     * @see #GlobalException(Throwable)
     * @see #GlobalException()
     */
    public GlobalException(FailureResultStatus status) {
        super();

        this.status = status;
    }

    /**
     * 构造方法。<br>
     * 建構方法。<br>
     * Constructor.<br>
     *
     * @param message 异常消息<br>異常訊息<br>Exception message<br>
     * @see #GlobalException(FailureResultStatus, String, Throwable)
     * @see #GlobalException(FailureResultStatus, String)
     * @see #GlobalException(FailureResultStatus, Throwable)
     * @see #GlobalException(String, Throwable)
     * @see #GlobalException(FailureResultStatus)
     * @see #GlobalException(Throwable)
     * @see #GlobalException()
     */
    public GlobalException(String message) {
        super(defaultIfBlank(message, FailureResultStatus.SYSTEM_ERROR.getMessage()));

        this.status = FailureResultStatus.SYSTEM_ERROR;
    }

    /**
     * 构造方法。<br>
     * 建構方法。<br>
     * Constructor.<br>
     *
     * @param cause 异常原因<br>異常原因<br>Exception cause<br>
     * @see #GlobalException(FailureResultStatus, String, Throwable)
     * @see #GlobalException(FailureResultStatus, String)
     * @see #GlobalException(FailureResultStatus, Throwable)
     * @see #GlobalException(String, Throwable)
     * @see #GlobalException(FailureResultStatus)
     * @see #GlobalException(String)
     * @see #GlobalException()
     */
    public GlobalException(Throwable cause) {
        super(cause);

        this.status = FailureResultStatus.SYSTEM_ERROR;
    }

    /**
     * 构造方法。<br>
     * 建構方法。<br>
     * Constructor.<br>
     *
     * @see #GlobalException(FailureResultStatus, String, Throwable)
     * @see #GlobalException(FailureResultStatus, String)
     * @see #GlobalException(FailureResultStatus, Throwable)
     * @see #GlobalException(String, Throwable)
     * @see #GlobalException(FailureResultStatus)
     * @see #GlobalException(String)
     * @see #GlobalException(Throwable)
     */
    public GlobalException() {
        super();

        this.status = FailureResultStatus.SYSTEM_ERROR;
    }

    /**
     * 默认值处理。<br>
     * 預設值處理。<br>
     * Default value processing.<br>
     *
     * @param message        异常消息<br>異常訊息<br>Exception message<br>
     * @param defaultMessage 默认消息<br>預設訊息<br>Default message<br>
     * @return 处理后的消息<br>處理後的訊息<br>Processed message<br>
     */
    private static String defaultIfBlank(String message, String defaultMessage) {
        if (message == null || message.trim().isEmpty()) {
            return defaultMessage;
        }
        return message;
    }
}
