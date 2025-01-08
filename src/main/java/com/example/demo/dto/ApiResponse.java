package com.example.demo.dto;
import org.springframework.http.HttpStatus;

public class ApiResponse<T> {
    private HttpStatus httpStatus;
    private T contents;

    public ApiResponse(HttpStatus httpStatus, T contents) {
        this.httpStatus = httpStatus;
        this.contents = contents;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public T getContents() {
        return contents;
    }

    public void setContents(T contents) {
        this.contents = contents;
    }
}
