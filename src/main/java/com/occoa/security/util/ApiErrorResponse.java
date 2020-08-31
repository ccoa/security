package com.occoa.security.util;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class ApiErrorResponse extends ApiResponse {

    private String error;
    private List<String> errors;

}
