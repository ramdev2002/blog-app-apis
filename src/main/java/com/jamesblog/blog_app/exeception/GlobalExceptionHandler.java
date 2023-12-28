package com.jamesblog.blog_app.exeception;

import com.jamesblog.blog_app.playload.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    //exception handling
    @ExceptionHandler(ResourceNotFundException.class)//assign the exception class which was create previously
    public ResponseEntity<ApiResponse> ResourceNotFoundHandler(ResourceNotFundException ex){
        //getting message from the ResourceNotFound class
        String message=ex.getMessage();

        //creating ApiResponse object and pass message and status
        ApiResponse apiResponse=new ApiResponse(message,false);
        return new  ResponseEntity<ApiResponse>(apiResponse,HttpStatus.NOT_FOUND);
    }


    // validated the fields and exception are handled globally
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>> handleMethodArgNotValidException(MethodArgumentNotValidException ex){
        Map<String,String> response=new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error)->{
            String fieldName=  ((FieldError)error ).getField();
            String message=error.getDefaultMessage();
            response.put(fieldName,message);
        });

        return new ResponseEntity<Map<String,String>>(response,HttpStatus.BAD_REQUEST);
    }

}
