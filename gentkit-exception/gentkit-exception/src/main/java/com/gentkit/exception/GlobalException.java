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

import com.gentkit.code.result.FailureCode;
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
     * 异常失败代码<br>
     * 異常失敗代碼<br>
     * Exceptional failure code<br>
     */
    private final String code;

    /**
     * 异常失败原因<br>
     * 異常失敗原因<br>
     * Exceptional failure reason<br>
     */
    private final String reason;

    /**
     * 构造方法。<br>
     * 建構方法。<br>
     * Constructor.<br>
     *
     * @param code    异常失败代码<br>異常失敗代碼<br>Exceptional failure code<br>
     * @param message 异常消息<br>異常訊息<br>Exception message<br>
     * @param cause   异常原因<br>異常原因<br>Exception cause<br>
     * @see #GlobalException(FailureCode, String)
     * @see #GlobalException(FailureCode, Throwable)
     * @see #GlobalException(String, Throwable)
     * @see #GlobalException(FailureCode)
     * @see #GlobalException(String)
     * @see #GlobalException(Throwable)
     * @see #GlobalException()
     */
    public GlobalException(FailureCode code, String message, Throwable cause) {
        super(defaultIfBlank(message, code.getMessage()), cause);

        this.code = code.getCode();
        this.reason = code.getReason();
    }

    /**
     * 构造方法。<br>
     * 建構方法。<br>
     * Constructor.<br>
     *
     * @param code    异常失败代码<br>異常失敗代碼<br>Exceptional failure code<br>
     * @param message 异常消息<br>異常訊息<br>Exception message<br>
     * @see #GlobalException(FailureCode, String, Throwable)
     * @see #GlobalException(FailureCode, Throwable)
     * @see #GlobalException(String, Throwable)
     * @see #GlobalException(FailureCode)
     * @see #GlobalException(String)
     * @see #GlobalException(Throwable)
     * @see #GlobalException()
     */
    public GlobalException(FailureCode code, String message) {
        super(defaultIfBlank(message, code.getMessage()));

        this.code = code.getCode();
        this.reason = code.getReason();
    }

    /**
     * 构造方法。<br>
     * 建構方法。<br>
     * Constructor.<br>
     *
     * @param code  异常失败代码<br>異常失敗代碼<br>Exceptional failure code<br>
     * @param cause 异常原因<br>異常原因<br>Exception cause<br>
     * @see #GlobalException(FailureCode, String, Throwable)
     * @see #GlobalException(FailureCode, String)
     * @see #GlobalException(String, Throwable)
     * @see #GlobalException(FailureCode)
     * @see #GlobalException(String)
     * @see #GlobalException(Throwable)
     * @see #GlobalException()
     */
    public GlobalException(FailureCode code, Throwable cause) {
        super(cause);

        this.code = code.getCode();
        this.reason = code.getReason();
    }

    /**
     * 构造方法。<br>
     * 建構方法。<br>
     * Constructor.<br>
     *
     * @param message 异常消息<br>異常訊息<br>Exception message<br>
     * @param cause   异常原因<br>異常原因<br>Exception cause<br>
     * @see #GlobalException(FailureCode, String, Throwable)
     * @see #GlobalException(FailureCode, String)
     * @see #GlobalException(FailureCode, Throwable)
     * @see #GlobalException(FailureCode)
     * @see #GlobalException(String)
     * @see #GlobalException(Throwable)
     * @see #GlobalException()
     */
    public GlobalException(String message, Throwable cause) {
        super(defaultIfBlank(message, FailureCode.SYSTEM_ERROR.getMessage()), cause);

        this.code = FailureCode.SYSTEM_ERROR.getCode();
        this.reason = FailureCode.SYSTEM_ERROR.getReason();
    }

    /**
     * 构造方法。<br>
     * 建構方法。<br>
     * Constructor.<br>
     *
     * @param code 异常失败代码<br>異常失敗代碼<br>Exceptional failure code<br>
     * @see #GlobalException(FailureCode, String, Throwable)
     * @see #GlobalException(FailureCode, String)
     * @see #GlobalException(FailureCode, Throwable)
     * @see #GlobalException(String, Throwable)
     * @see #GlobalException(String)
     * @see #GlobalException(Throwable)
     * @see #GlobalException()
     */
    public GlobalException(FailureCode code) {
        super();

        this.code = code.getCode();
        this.reason = code.getReason();
    }

    /**
     * 构造方法。<br>
     * 建構方法。<br>
     * Constructor.<br>
     *
     * @param message 异常消息<br>異常訊息<br>Exception message<br>
     * @see #GlobalException(FailureCode, String, Throwable)
     * @see #GlobalException(FailureCode, String)
     * @see #GlobalException(FailureCode, Throwable)
     * @see #GlobalException(String, Throwable)
     * @see #GlobalException(FailureCode)
     * @see #GlobalException(Throwable)
     * @see #GlobalException()
     */
    public GlobalException(String message) {
        super(defaultIfBlank(message, FailureCode.SYSTEM_ERROR.getMessage()));

        this.code = FailureCode.SYSTEM_ERROR.getCode();
        this.reason = FailureCode.SYSTEM_ERROR.getReason();
    }

    /**
     * 构造方法。<br>
     * 建構方法。<br>
     * Constructor.<br>
     *
     * @param cause 异常原因<br>異常原因<br>Exception cause<br>
     * @see #GlobalException(FailureCode, String, Throwable)
     * @see #GlobalException(FailureCode, String)
     * @see #GlobalException(FailureCode, Throwable)
     * @see #GlobalException(String, Throwable)
     * @see #GlobalException(FailureCode)
     * @see #GlobalException(String)
     * @see #GlobalException()
     */
    public GlobalException(Throwable cause) {
        super(cause);

        this.code = FailureCode.SYSTEM_ERROR.getCode();
        this.reason = FailureCode.SYSTEM_ERROR.getReason();
    }

    /**
     * 构造方法。<br>
     * 建構方法。<br>
     * Constructor.<br>
     *
     * @see #GlobalException(FailureCode, String, Throwable)
     * @see #GlobalException(FailureCode, String)
     * @see #GlobalException(FailureCode, Throwable)
     * @see #GlobalException(String, Throwable)
     * @see #GlobalException(FailureCode)
     * @see #GlobalException(String)
     * @see #GlobalException(Throwable)
     */
    public GlobalException() {
        super();

        this.code = FailureCode.SYSTEM_ERROR.getCode();
        this.reason = FailureCode.SYSTEM_ERROR.getReason();
    }

    /**
     * 默认值处理。<br>
     * 預設值處理。<br>
     * Default value processing.<br>
     *
     * @param message       异常消息<br>異常訊息<br>Exception message<br>
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
