package com.depa.user.security.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpServerErrorException;

public class ResourceNotFoundException extends HttpServerErrorException {
    public ResourceNotFoundException(String user, String message, Long id) {
        super(HttpStatus.BAD_GATEWAY);
    }
}
