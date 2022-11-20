package com.igor.nvpc.jsons;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Error {

    private String message;
    private String documentation_url;

    private Error(final String message) {
        this.message = message;
    }

    public static Error from(final String message) {
        return new Error(message);
    }
}