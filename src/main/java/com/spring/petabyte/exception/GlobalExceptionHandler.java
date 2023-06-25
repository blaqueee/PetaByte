package com.spring.petabyte.exception;

import com.spring.petabyte.dto.ResponseDto;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Objects;

import static com.spring.petabyte.utils.GlobalVariable.REQUEST_VALIDATION_FAILURE;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BindException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseDto<?> constraintViolationExceptionHandler(BindException e) {
        return ResponseDto.validationError(
                Objects.requireNonNull(e.getBindingResult()
                        .getFieldError())
                .getDefaultMessage());
    }

    @ExceptionHandler(TokenException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseDto<?> tokenExceptionHandler(TokenException e) {
        return ResponseDto.fail(e.getMessage());
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseDto<?> notFoundExceptionHandler(NotFoundException e) {
        return ResponseDto.fail(e.getMessage());
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseDto<?> illegalArgumentExceptionHandler(IllegalArgumentException e) {
        return ResponseDto.validationError(e.getMessage());
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseDto<?> dataIntegrityViolationExceptionHandler(DataIntegrityViolationException e) {
        return ResponseDto.fail(e.getMessage());
    }

    @ExceptionHandler(NotPermittedException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseDto<?> notPermittedExceptionHandler(NotPermittedException e) {
        return ResponseDto.fail(e.getMessage());
    }

    @ExceptionHandler(LoginExistsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseDto<?> loginExistsExceptionHandler(LoginExistsException e) {
        return ResponseDto.fail(e.getMessage());
    }
}
