package com.gentkit.server.component.flux.web.filter;

import com.gentkit.common.traceid.TraceIdConstants;
import com.gentkit.common.traceid.TraceIdContext;
import com.gentkit.common.traceid.hook.SetHook;
import org.slf4j.MDC;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

@Order(Ordered.HIGHEST_PRECEDENCE)
public class FluxWebTraceIdFilter implements WebFilter {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        HttpHeaders requestHeaders = request.getHeaders();
        ServerHttpResponse response = exchange.getResponse();
        HttpHeaders responseHeaders = response.getHeaders();

        // 放入 Reactor Context + MDC
        return chain.filter(exchange)
                .contextWrite(ctx -> {
                    SetHook setHook = traceId -> MDC.put(TraceIdConstants.TRACE_ID, traceId);

                    String traceId = requestHeaders.getFirst(TraceIdConstants.HTTP_HEADER_TRACE_ID);

                    if (traceId == null || traceId.trim().isEmpty()) {
                        traceId = TraceIdContext.init(setHook);
                    } else {
                        TraceIdContext.set(traceId, setHook);
                    }
                    responseHeaders.add(TraceIdConstants.HTTP_HEADER_TRACE_ID, traceId);

                    ctx.put(TraceIdConstants.TRACE_ID, traceId);
                    return ctx;
                })
                // .doOnSubscribe(sub -> MDC.put(TraceIdUtil.MDC_TRACE_ID_KEY, traceId))
                .doFinally(signal -> {
                    TraceIdContext.clear(MDC::clear);
                });
    }
}
