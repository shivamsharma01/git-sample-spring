package com.ekart.zuulgateway.configuration;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import com.netflix.hystrix.exception.HystrixTimeoutException;

@Configuration
public class ZuulFallbackProvider {
	
	@Bean
	public CorsFilter corsFilter() {
	    final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	    final CorsConfiguration config = new CorsConfiguration();
	    config.setAllowCredentials(true);
	    config.addAllowedOrigin("*");
	    config.addAllowedHeader("*");
	    config.addAllowedMethod("OPTIONS");
	    config.addAllowedMethod("HEAD");
	    config.addAllowedMethod("GET");
	    config.addAllowedMethod("PUT");
	    config.addAllowedMethod("POST");
	    config.addAllowedMethod("DELETE");
	    config.addAllowedMethod("PATCH");
	    source.registerCorsConfiguration("/**", config);
	    return new CorsFilter(source);
	}
	
	@Bean
	public FallbackProvider zullFallbackProvider() {
		return new FallbackProvider() {

			@Override
			public String getRoute() {
				return "*";
			}

			@Override
			public ClientHttpResponse fallbackResponse(String route, Throwable cause) {
				if (cause instanceof HystrixTimeoutException) {
					return response(HttpStatus.GATEWAY_TIMEOUT);
				} else {
					return response(HttpStatus.INTERNAL_SERVER_ERROR);
				}
			}

			public ClientHttpResponse response(final HttpStatus status) {
				return new ClientHttpResponse() {

					@Override
					public HttpHeaders getHeaders() {
						HttpHeaders headers = new HttpHeaders();
						headers.setContentType(MediaType.APPLICATION_JSON);
						return headers;
					}

					@Override
					public InputStream getBody() throws IOException {
						return new ByteArrayInputStream("Sorry, An Error Occured".getBytes());
					}

					@Override
					public String getStatusText() throws IOException {
						return status.getReasonPhrase();
					}

					@Override
					public HttpStatus getStatusCode() throws IOException {
						return status;
					}

					@Override
					public int getRawStatusCode() throws IOException {
						return status.value();
					}

					@Override
					public void close() {
						// return type is void.. no implementation required
					}
				};
			}
		};
	}

}
