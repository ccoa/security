package com.occoa.security.util;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class ApiSuccessResponse extends ApiResponse {

    private Object data;

}
