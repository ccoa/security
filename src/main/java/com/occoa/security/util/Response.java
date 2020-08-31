package com.occoa.security.util;

import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Data
public class Response {

    public static ResponseEntity<Object> respond500(String errorMessage) {
        ApiErrorResponse errorResponse = new ApiErrorResponse();
        errorResponse.setMessage(errorMessage);
        errorResponse.setError("Internal Server Error");
        errorResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
    }

    public static ResponseEntity<Object> respond403(String errorMessage) {
        ApiErrorResponse errorResponse = new ApiErrorResponse();
        errorResponse.setMessage(errorMessage);
        errorResponse.setError("Forbidden");
        errorResponse.setStatus(HttpStatus.FORBIDDEN.value());
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(errorResponse);
    }

    public static ResponseEntity<Object> respond404() {
        ApiErrorResponse errorResponse = new ApiErrorResponse();
        errorResponse.setMessage("The resource doesn't exists");
        errorResponse.setError("Not Found");
        errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }

    public static ResponseEntity<Object> respond401(String message) {
        ApiErrorResponse errorResponse = new ApiErrorResponse();
        errorResponse.setMessage(message);
        errorResponse.setError("Unauthorized");
        errorResponse.setStatus(HttpStatus.UNAUTHORIZED.value());
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorResponse);
    }

    public static ResponseEntity<Object> respond400(String message, List<String> errors) {
        ApiErrorResponse errorResponse = new ApiErrorResponse();
        errorResponse.setMessage(message);
        errorResponse.setErrors(errors);
        errorResponse.setError("Bad Request");
        errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }

    public static ResponseEntity<Object> respond200(Object object, String message) {
        ApiSuccessResponse apiSuccessResponse = new ApiSuccessResponse();
        apiSuccessResponse.setStatus(HttpStatus.OK.value());
        apiSuccessResponse.setMessage(message);
        apiSuccessResponse.setData(object);
        return ResponseEntity.ok(apiSuccessResponse);
    }

    public static ResponseEntity<Object> respond200(Object object) {
        return respond200(object, "Ok");
    }

    public static ResponseEntity<Object> ok() {
        return ResponseEntity.ok("");
    }

}
