package com.kiraz.kirazapp.exception;

import com.kiraz.kirazapp.base.BaseResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandling {

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<BaseResponse<?>> validateException(MethodArgumentNotValidException e) {
        BaseResponse baseResponse = new BaseResponse<>();
        for (ObjectError error :
                e.getAllErrors()) {
            baseResponse.getMessages().add(error.getDefaultMessage());
        }
        baseResponse.setSuccess(false);
        return new ResponseEntity<>(baseResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<BaseResponse<?>> exception(Exception e) {
        BaseResponse baseResponse = new BaseResponse<>();
        baseResponse.getMessages().add(e.getMessage());
        baseResponse.setSuccess(false);
        return new ResponseEntity<>(baseResponse, HttpStatus.BAD_REQUEST);
    }
}
