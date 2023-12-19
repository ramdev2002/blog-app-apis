package com.jamesblog.blog_app.exeception;

import com.jamesblog.blog_app.playload.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

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
}
