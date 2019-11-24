package com.ujwal.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE)
public class UserError extends RuntimeException {
	private static final long serialVersionUID = 6935963299171488862L;
	private String resourceName;
    private String message;

    public UserError( String resourceName, String message) {
        super(String.format("%s : '%s'", resourceName, message));
        this.resourceName = resourceName;
        this.message = message;
    }

    public String getResourceName() {
        return resourceName;
    }

    public String getMessage() {
        return message;
    }

}
