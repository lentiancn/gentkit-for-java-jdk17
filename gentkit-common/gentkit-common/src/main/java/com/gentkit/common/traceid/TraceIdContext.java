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
package com.gentkit.common.traceid;

import com.gentkit.common.traceid.hook.ClearHook;
import com.gentkit.common.traceid.hook.SetHook;
import com.gentkit.common.traceid.utils.TraceIdUtils;

public class TraceIdContext {

    private static final ThreadLocal<String> TRACE_ID_HOLDER = new ThreadLocal<>();

    public static String generate() {
        return TraceIdUtils.generate();
    }

    public static String init(SetHook setHook) {
        String traceId = get();
        if (traceId == null || traceId.trim().isEmpty()) {
            traceId = generate();
            set(traceId, setHook);
        }
        return traceId;
    }

    public static String get() {
        return TRACE_ID_HOLDER.get();
    }

    public static void set(String traceId, SetHook hook) {
        TRACE_ID_HOLDER.set(traceId);
        hook.after(traceId);
    }

    public static void clear(ClearHook hook) {
        hook.before();
        TRACE_ID_HOLDER.remove();
    }
}

