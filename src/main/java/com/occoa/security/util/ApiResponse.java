package com.occoa.security.util;

import lombok.Data;

@Data
public class ApiResponse {

    private long timestamp;
    private Integer status;
    private String message;

}
