package com.spring.demo.dans.rest.web.configuration;

import com.spring.demo.dans.entity.constant.ApiPath;
import com.spring.demo.dans.libraries.helper.JWTHelper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

import java.util.Objects;

/**
 * @author Rizky Perdana
 */

@Component
@AllArgsConstructor
@Slf4j
public class FilterInterceptor implements WebFilter {

    private JWTHelper jwtUtils;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {

        String token = exchange.getRequest().getHeaders().getFirst("Authorization");

        String jwtToken;

        String uri = exchange.getRequest().getURI().getPath();
        if(Objects.equals(ApiPath.AUTH_ROUTE, uri)){
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
