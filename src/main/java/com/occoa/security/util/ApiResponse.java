package com.occoa.security.util;

import lombok.Data;

import java.util.Calendar;

@Data
public class ApiResponse {

    private long timestamp;
    private Integer status;
    private String message;

    public ApiResponse() {
        this.timestamp = Calendar.getInstance().getTimeInMillis();
    }

}
