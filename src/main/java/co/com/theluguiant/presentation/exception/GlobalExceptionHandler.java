package co.com.theluguiant.presentation.exception;

import co.com.theluguiant.utils.custom_exceptions.InvalidValueException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;

import co.com.theluguiant.domain.dto.response.Response;
import co.com.theluguiant.domain.dto.response.ResponseEntityBuilder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import software.amazon.awssdk.services.dynamodb.model.DynamoDbException;

@ControllerAdvice
public class GlobalExceptionHandler {
	 private final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);
	    @Value("#{new Boolean('${data.showErrorData}')}")
	    private Boolean showErrorData;

	    // handleMethodArgumentTypeMismatch : triggers when a parameter's type does not
	    // match
	    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
	    protected ResponseEntity<Object> handleMethodArgumentTypeMismatch(MethodArgumentTypeMismatchException ex,
	                                                                      WebRequest request) {
	        log.info("Exception: handleMethodArgumentTypeMismatch");
	        List<String> details = new ArrayList<String>();
	        details.add(ex.getMessage());

	        Response<Object> err = new Response<Object>();
	        err.setStatus(HttpStatus.BAD_REQUEST.value());
	        err.setMessage("TLG00001");
	        err.setData(details);

	        return ResponseEntityBuilder.build(err);
	    }

	    // handleConstraintViolationException : triggers when @Validated fails
	    @ExceptionHandler(ConstraintViolationException.class)
	    public ResponseEntity<?> handleConstraintViolationException(Exception ex, WebRequest request) {

	        log.info("Exception: handleConstraintViolationException");
	        List<String> details = new ArrayList<String>();
	        details.add(ex.getMessage());

	        Response<Object> err = new Response<Object>();
	        err.setStatus(HttpStatus.BAD_REQUEST.value());
	        err.setMessage("TLG00002");

	        return ResponseEntityBuilder.build(err);
	    }

	    @ExceptionHandler({ Exception.class })
	    public ResponseEntity<Object> handleAll(Exception ex, WebRequest request) {
	        log.info("Exception: handleAll");
			System.out.println(ex);
	        List<String> details = new ArrayList<String>();
	        details.add(ex.getMessage());
	        Response<Object> err = new Response<Object>();
	        err.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
	        err.setMessage("TLG00003");
	        err.setData(details);

	        return ResponseEntityBuilder.build(err);

	    }

	    @ExceptionHandler({ DynamoDbException.class })
	    public ResponseEntity<Object> handleDynamoDbException(DynamoDbException ex, WebRequest request) {
	        log.info("Exception: handleDynamoDbException");
	        List<String> details = new ArrayList<String>();
	        details.add(ex.getMessage());

	        Response<Object> err = new Response<Object>();
	        err.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
	        err.setMessage("TLG00004");

	        return ResponseEntityBuilder.build(err);

	    }

	    @ExceptionHandler({ IOException.class })
	    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	    public ResponseEntity<Object> handleIOException(IOException ex, WebRequest request) {
	        log.info("Exception: handleIOException");
	        List<String> details = new ArrayList<String>();
	        details.add(ex.getMessage());

	        Response<Object> err = new Response<Object>();
	        err.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
	        err.setMessage("TLG00005");
	        if(showErrorData){
	            err.setData(details);
	        }
	        return ResponseEntityBuilder.build(err);

	    }

	    @ExceptionHandler({ NullPointerException.class })
	    public ResponseEntity<Object> handleNullPointerException(NullPointerException ex, WebRequest request) {
	        log.info("Exception: handleNullPointerException");
	        List<String> details = new ArrayList<String>();
	        details.add(ex.getMessage());

	        Response<Object> err = new Response<Object>();
	        err.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
	        err.setMessage("TLG00006");

	        return ResponseEntityBuilder.build(err);

	    }

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Object> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex, WebRequest request) {
		log.error("MethodArgumentNotValidException encountered: {}", ex.getMessage());

		BindingResult bindingResult = ex.getBindingResult();
		List<String> details = ex.getBindingResult().getFieldErrors().stream()
				.map(error -> /* error.getObjectName()+ " " + */ error.getField() + ": " + error.getDefaultMessage()
						+ " [" + error.getRejectedValue() + "]")
				.collect(Collectors.toList());

		Response<Object> response = new Response<>();
		response.setStatus(HttpStatus.BAD_REQUEST.value());
		response.setMessage("TLG00007");
		response.setErrors(details);

		return ResponseEntityBuilder.build(response);
	}

	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<Object> handleHttpMessageNotReadableException(HttpMessageNotReadableException ex, WebRequest request) {
		log.error("HttpMessageNotReadableException encountered: {}", ex.getMessage());

		List<String> details = new ArrayList<String>();
		details.add("Body request: Required request body is missing [null]");

		Response<Object> err = new Response<Object>();
		err.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
		err.setMessage("TLG00008");
		err.setErrors(details);

		return ResponseEntityBuilder.build(err);
	}


	@ExceptionHandler(InvalidValueException.class)
	public ResponseEntity<Object> handleInvalidValueException(InvalidValueException ex, WebRequest request) {
		log.error("InvalidValueException encountered: {}", ex.getMessage());

		List<String> details = new ArrayList<String>();
		details.add(ex.getMessage());

		Response<Object> err = new Response<Object>();
		err.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
		err.setMessage("TLG00009");
		err.setErrors(details);

		return ResponseEntityBuilder.build(err);
	}


}
