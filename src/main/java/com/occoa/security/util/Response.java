package com.occoa.security.util;

import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Data
public class Response {

    public static ResponseEntity<Object> internalServerError(String errorMessage) {
        ApiErrorResponse errorResponse = new ApiErrorResponse();
        errorResponse.setMessage(errorMessage);
        errorResponse.setError("Internal Server Error");
        errorResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(errorResponse);
    }

    public static ResponseEntity<Object> forbidden(String errorMessage) {
        ApiErrorResponse errorResponse = new ApiErrorResponse();
        errorResponse.setMessage(errorMessage);
        errorResponse.setError("Forbidden");
        errorResponse.setStatus(HttpStatus.FORBIDDEN.value());
        return ResponseEntity
                .status(HttpStatus.FORBIDDEN)
                .body(errorResponse);
    }

    public static ResponseEntity<Object> notFound() {
        ApiErrorResponse errorResponse = new ApiErrorResponse();
        errorResponse.setMessage("The resource doesn't exists");
        errorResponse.setError("Not Found");
        errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }

    public static ResponseEntity<Object> unauthorized(String message) {
        ApiErrorResponse errorResponse = new ApiErrorResponse();
        errorResponse.setMessage(message);
        errorResponse.setError("Unauthorized");
        errorResponse.setStatus(HttpStatus.UNAUTHORIZED.value());
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorResponse);
    }

    public static ResponseEntity<Object> badRequest(String message, List<String> errors) {
        ApiErrorResponse errorResponse = new ApiErrorResponse();
        errorResponse.setMessage(message);
        errorResponse.setErrors(errors);
        errorResponse.setError("Bad Request");
        errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }

    public static ResponseEntity<Object> ok() {
        return ResponseEntity.ok("");
    }

    public static ResponseEntity<Object> ok(Object object) {
        return ok(object, "Ok");
    }

    public static ResponseEntity<Object> ok(Object object, String message) {
        ApiSuccessResponse apiSuccessResponse = new ApiSuccessResponse();
        apiSuccessResponse.setStatus(HttpStatus.OK.value());
        apiSuccessResponse.setMessage(message);
        apiSuccessResponse.setData(object);
        return ResponseEntity.ok(apiSuccessResponse);
    }

    public static ResponseEntity<Object> created(Object object) {
        return created(object, "Created");
    }

    public static ResponseEntity<Object> created(Object object, String message) {
        ApiSuccessResponse apiSuccessResponse = new ApiSuccessResponse();
        apiSuccessResponse.setStatus(HttpStatus.CREATED.value());
        apiSuccessResponse.setMessage(message);
        apiSuccessResponse.setData(object);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(apiSuccessResponse);
    }

    public static ResponseEntity<Object> accepted(Object object) {
        return accepted(object, "Accepted");
    }

    public static ResponseEntity<Object> accepted(Object object, String message) {
        ApiSuccessResponse apiSuccessResponse = new ApiSuccessResponse();
        apiSuccessResponse.setStatus(HttpStatus.ACCEPTED.value());
        apiSuccessResponse.setMessage(message);
        apiSuccessResponse.setData(object);
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(apiSuccessResponse);
    }

    public static ResponseEntity<Object> noContent() {
        return noContent("No content");
    }

    public static ResponseEntity<Object> noContent(String message) {
        ApiSuccessResponse apiSuccessResponse = new ApiSuccessResponse();
        apiSuccessResponse.setStatus(HttpStatus.NO_CONTENT.value());
        apiSuccessResponse.setMessage(message);
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .body(apiSuccessResponse);
    }

}
