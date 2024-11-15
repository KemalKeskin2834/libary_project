package com.kemalkeskin.libary.core.exception;

import lombok.*;


@Getter
@Setter
public class ProblemDetails {

    private String message;

    public ProblemDetails(String message) {
        this.message = message;
    }
}
