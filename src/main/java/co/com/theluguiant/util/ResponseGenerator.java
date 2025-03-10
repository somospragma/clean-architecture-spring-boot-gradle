package co.com.theluguiant.util;

import org.springframework.http.HttpStatus;

import co.com.theluguiant.domain.response.Response;

public class ResponseGenerator {
    private ResponseGenerator() {
        // Private constructor to prevent instantiation
    }

    public static <T> Response<T> callResponse(String msg, Object payload) {
        Response<T> response = new Response<T>();
        response.setData((T) payload);
        response.setMessage(msg);
        response.setStatus(HttpStatus.OK.value());
        return response;
    }

    public static <T> Response<T> customResponse(String msg, Object payload, HttpStatus status) {
        Response<T> response = new Response<T>();
        response.setData((T) payload);
        response.setMessage(msg);
        response.setStatus(status.value());
        return response;
    }
}
