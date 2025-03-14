package co.com.theluguiant.domain.dto.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseEntityBuilder {
    public static <T> ResponseEntity<T> build(Response<T> err) {
        return new ResponseEntity<T>((T) err, HttpStatus.valueOf(err.getStatus()));
    }
}
