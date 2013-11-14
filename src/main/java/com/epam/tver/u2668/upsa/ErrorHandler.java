package com.epam.tver.u2668.upsa;

import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.ResponseErrorHandler;

import java.io.IOException;

public class ErrorHandler implements ResponseErrorHandler {

    private ResponseErrorHandler handler = new DefaultResponseErrorHandler();

    @Override
    public boolean hasError(ClientHttpResponse response) throws IOException {
        if (response.getStatusCode() == HttpStatus.UNAUTHORIZED) {
            return false;
        }
        return handler.hasError(response);
    }

    @Override
    public void handleError(ClientHttpResponse response) throws IOException {
        handler.handleError(response);
    }
}
