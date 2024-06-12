package com.iotronicsinnovations.springbootproject.advice;

import com.iotronicsinnovations.springbootproject.Controllers.ErrorDto;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

@org.springframework.web.bind.annotation.ControllerAdvice

public class ControllerAdvice {
    @ExceptionHandler(NullPointerException.class)  //issue is when we have multiple Controller then need to copy and paste the same code at the multiple places
    public ResponseEntity<ErrorDto> handleNullPointerException(){
//        String errorMessage ="Something Went Wrong Please Try Again";
//        return errorMessage;

        ErrorDto errorDto=new ErrorDto();
        errorDto.setMessage("Something Went Wrong Please retry");
        errorDto.setStatusCode("404 Error");
        errorDto.setErrorDetails("This is Null Pointer Exception");

        ResponseEntity <ErrorDto> responseEntity =new ResponseEntity<>
                (errorDto, HttpStatusCode.valueOf(404));
        return responseEntity;
    }
}
