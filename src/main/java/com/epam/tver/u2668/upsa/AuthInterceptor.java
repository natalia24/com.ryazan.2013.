package com.epam.tver.u2668.upsa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;
import java.util.logging.Logger;

public class AuthInterceptor implements ClientHttpRequestInterceptor {

    private static final Logger LOGGER = Logger.getLogger(AuthInterceptor.class.getName());

    @Autowired
    private AuthContext context;

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        LOGGER.info(request.getURI().toString());
        if (!request.getURI().getPath().endsWith("oauth/token")) {
            request.getHeaders().add("Authorization", "Bearer " + context.getToken().getValue());
        }
        ClientHttpResponse response = execution.execute(request, body);
        if (response.getStatusCode() == HttpStatus.UNAUTHORIZED) {
            context.invalidate();
            request.getHeaders().set("Authorization", "Bearer " + context.getToken().getValue());
            return execution.execute(request, body);
        }
        return response;
    }
}
