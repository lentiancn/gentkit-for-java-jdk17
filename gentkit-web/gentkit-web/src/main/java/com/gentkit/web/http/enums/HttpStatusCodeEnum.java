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
package com.gentkit.web.http.enums;

import lombok.Getter;

/**
 * HTTP 状态码枚举（符合 RFC 9110 及扩展规范）
 */
@Getter
public enum HttpStatusCodeEnum {

    // ===================== 1xx : 信息响应 =====================

    CONTINUE(100, "Continue", "继续"),
    SWITCHING_PROTOCOLS(101, "Switching Protocols", "切换协议"),
    PROCESSING(102, "Processing", "处理中（WebDAV）"),
    EARLY_HINTS(103, "Early Hints", "早期提示"),

    // ===================== 2xx : 成功响应 =====================

    OK(200, "OK", "成功"),
    CREATED(201, "Created", "创建成功"),
    ACCEPTED(202, "Accepted", "已接受（异步处理）"),
    NON_AUTHORITATIVE_INFORMATION(203, "Non-Authoritative Information", "非权威信息"),
    NO_CONTENT(204, "No Content", "无内容"),
    RESET_CONTENT(205, "Reset Content", "重置内容"),
    PARTIAL_CONTENT(206, "Partial Content", "部分内容（断点续传）"),
    MULTI_STATUS(207, "Multi-Status", "多状态（WebDAV）"),
    ALREADY_REPORTED(208, "Already Reported", "已报告（WebDAV）"),
    IM_USED(226, "IM Used", "IM已使用（增量更新）"),

    // ===================== 3xx : 重定向响应 =====================

    MULTIPLE_CHOICES(300, "Multiple Choices", "多种选择"),
    MOVED_PERMANENTLY(301, "Moved Permanently", "永久重定向"),
    FOUND(302, "Found", "临时重定向"),
    SEE_OTHER(303, "See Other", "查看其他位置"),
    NOT_MODIFIED(304, "Not Modified", "未修改（缓存）"),
    @Deprecated
    USE_PROXY(305, "Use Proxy", "使用代理（废弃，RFC 9110 移除）"),
    @Deprecated
    UNUSED(306, "Unused", "未使用（废弃）"),
    TEMPORARY_REDIRECT(307, "Temporary Redirect", "临时重定向（保留方法）"),
    PERMANENT_REDIRECT(308, "Permanent Redirect", "永久重定向（保留方法）"),

    // ===================== 4xx : 客户端错误 =====================

    BAD_REQUEST(400, "Bad Request", "错误请求（参数/格式错误）"),
    UNAUTHORIZED(401, "Unauthorized", "未认证（需登录）"),
    PAYMENT_REQUIRED(402, "Payment Required", "需要付款（预留）"),
    FORBIDDEN(403, "Forbidden", "禁止访问（无权限）"),
    NOT_FOUND(404, "Not Found", "未找到资源"),
    METHOD_NOT_ALLOWED(405, "Method Not Allowed", "方法不允许"),
    NOT_ACCEPTABLE(406, "Not Acceptable", "不可接受（格式不匹配）"),
    PROXY_AUTHENTICATION_REQUIRED(407, "Proxy Authentication Required", "代理认证要求"),
    REQUEST_TIMEOUT(408, "Request Timeout", "请求超时"),
    CONFLICT(409, "Conflict", "资源冲突（重复创建/版本冲突）"),
    GONE(410, "Gone", "永久删除"),
    LENGTH_REQUIRED(411, "Length Required", "要求内容长度"),
    PRECONDITION_FAILED(412, "Precondition Failed", "预处理失败"),
    PAYLOAD_TOO_LARGE(413, "Payload Too Large", "请求体过大"),
    URI_TOO_LONG(414, "URI Too Long", "URI过长"),
    UNSUPPORTED_MEDIA_TYPE(415, "Unsupported Media Type", "不支持的媒体类型"),
    RANGE_NOT_SATISFIABLE(416, "Range Not Satisfiable", "范围无法满足"),
    EXPECTATION_FAILED(417, "Expectation Failed", "期望失败"),
    IM_A_TEAPOT(418, "I'm a teapot", "我是茶壶（彩蛋，非标准业务码）"),
    MISDIRECTED_REQUEST(421, "Misdirected Request", "请求定向错误"),
    UNPROCESSABLE_CONTENT(422, "Unprocessable Content", "无法处理的内容（参数格式对但值无效）"),
    LOCKED(423, "Locked", "已锁定（WebDAV）"),
    FAILED_DEPENDENCY(424, "Failed Dependency", "依赖失败（WebDAV）"),
    TOO_EARLY(425, "Too Early", "请求发送过早"),
    UPGRADE_REQUIRED(426, "Upgrade Required", "需要升级协议"),
    PRECONDITION_REQUIRED(428, "Precondition Required", "要求预处理头"),
    TOO_MANY_REQUESTS(429, "Too Many Requests", "请求过多（限流）"),
    REQUEST_HEADER_FIELDS_TOO_LARGE(431, "Request Header Fields Too Large", "请求头过大"),
    UNAVAILABLE_FOR_LEGAL_REASONS(451, "Unavailable For Legal Reasons", "因法律原因不可用"),

    // ===================== 5xx : 服务器错误 =====================

    INTERNAL_SERVER_ERROR(500, "Internal Server Error", "内部服务器错误"),
    NOT_IMPLEMENTED(501, "Not Implemented", "未实现（不支持该功能）"),
    BAD_GATEWAY(502, "Bad Gateway", "网关错误（上游服务无效）"),
    SERVICE_UNAVAILABLE(503, "Service Unavailable", "服务不可用（维护/过载）"),
    GATEWAY_TIMEOUT(504, "Gateway Timeout", "网关超时（上游响应慢）"),
    HTTP_VERSION_NOT_SUPPORTED(505, "HTTP Version Not Supported", "HTTP版本不支持"),
    VARIANT_ALSO_NEGOTIATES(506, "Variant Also Negotiates", "变体协商冲突"),
    INSUFFICIENT_STORAGE(507, "Insufficient Storage", "存储空间不足（WebDAV）"),
    LOOP_DETECTED(508, "Loop Detected", "检测到循环（WebDAV）"),
    NOT_EXTENDED(510, "Not Extended", "未扩展（需HTTP扩展）"),
    NETWORK_AUTHENTICATION_REQUIRED(511, "Network Authentication Required", "网络认证要求（公共Wi-Fi）");

    public static HttpStatusCodeEnum enumOf(int statusCode) {
        for (HttpStatusCodeEnum value : values()) {
            if (value.statusCode == statusCode) {
                return value;
            }
        }
        return null;
    }

    private final int statusCode;

    private final String reasonPhrase;

    private final String description;

    HttpStatusCodeEnum(int statusCode, String reasonPhrase, String description) {
        this.statusCode = statusCode;
        this.reasonPhrase = reasonPhrase;
        this.description = description;
    }

    @Override
    public String toString() {
        return statusCode + " " + reasonPhrase;
    }
}
