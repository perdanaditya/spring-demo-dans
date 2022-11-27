package com.dans.multipro.test.configuration;

import com.dans.multipro.test.common.ApiPath;
import com.dans.multipro.test.utils.JwtUtils;
import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

/**
 * @author Rizky Perdana
 */

@Component
@AllArgsConstructor
@Slf4j
public class FilterInterceptor implements WebFilter {

    private JwtUtils jwtUtils;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {

        String token = exchange.getRequest().getHeaders().getFirst("Authorization");

        String jwtToken;

        String uri = exchange.getRequest().getURI().getPath();
        if (Objects.equals(ApiPath.login, uri)) {
            return chain.filter(exchange);
        }

        if (token != null && token.startsWith("Bearer ")) {
            jwtToken = token.substring(7);
            try {
                jwtUtils.getUsernameFromToken(jwtToken);
            } catch (Exception e) {
                exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
                exchange.getResponse().getHeaders().add("Access-Control-Allow-Origin", "*");
                return exchange.getResponse().setComplete();
            }
        } else {
            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
            exchange.getResponse().getHeaders().add("Access-Control-Allow-Origin", "*");
            return exchange.getResponse().setComplete();
        }

        return chain.filter(exchange);
    }
}
