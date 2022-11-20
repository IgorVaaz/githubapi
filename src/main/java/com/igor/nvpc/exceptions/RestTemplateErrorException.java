package com.igor.nvpc.exceptions;

import com.igor.nvpc.jsons.Error;
import org.springframework.http.HttpStatus;

public class RestTemplateErrorException extends Throwable {
    private final Error error;
    private final HttpStatus httpStatus;

    public RestTemplateErrorException(final Error error, final HttpStatus httpStatus) {
        this.error = error;
        this.httpStatus = httpStatus;
    }

    public Error getError() {
        return error;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
