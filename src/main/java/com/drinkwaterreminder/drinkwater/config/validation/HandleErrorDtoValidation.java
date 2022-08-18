package com.drinkwaterreminder.drinkwater.config.validation;

import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
@AllArgsConstructor
public class HandleErrorDtoValidation {

  final MessageSource messageSource;

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<Object> handleBadRequest(MethodArgumentNotValidException exception) {
    List<ErrorDto> errorDtoList = new ArrayList<ErrorDto>();
    List<FieldError> fieldErrorList = exception.getBindingResult().getFieldErrors();

    fieldErrorList.forEach(e -> {
      String message = messageSource.getMessage(e, LocaleContextHolder.getLocale());
      ErrorDto errorDto = new ErrorDto(e.getField(), message);
      errorDtoList.add(errorDto);
    });

    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorDtoList);
  }

  @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
  public ResponseEntity<Object> handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
    return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body("Request method not allowed.");
  }

  @ExceptionHandler(HttpMessageNotReadableException.class)
  public ResponseEntity<Object> handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("JSON parse error.");
  }
}
