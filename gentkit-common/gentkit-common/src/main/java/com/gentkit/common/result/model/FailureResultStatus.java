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

public class FailureResultStatus extends ResultStatus {

    //    public static final FailureResultStatus BAD_REQUEST = new FailureResultStatus("00000400", "BAD_REQUEST", "请求参数错误");
//    public static final FailureResultStatus NOT_FOUND = new FailureResultStatus("00000404", "NOT_FOUND", "未找到该资源");
    public static final FailureResultStatus UNSUPPORTED_MEDIA_TYPE = new FailureResultStatus("00000415", "UNSUPPORTED_MEDIA_TYPE", "不支持的媒体类型");
    public static final FailureResultStatus SYSTEM_ERROR = new FailureResultStatus("00000500", "SYSTEM_ERROR", "系统异常");

    public FailureResultStatus(String code, String reason, String message) {
        super(code, reason, message);
    }
}
