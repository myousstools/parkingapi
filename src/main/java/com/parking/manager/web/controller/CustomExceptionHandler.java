package com.parking.manager.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.parking.manager.service.exception.ParkingFunctionalException;
import com.parking.manager.web.beans.ErrorOutput;

/**
 * The type Custom exception handler, intercepts exception in order to customize the reponse
 */
@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {
  /**
   * Handle all exceptions response entity.
   *
   * @param ex      the ex
   * @param request the request
   * @return the response entity
   */
  @ExceptionHandler(Exception.class)
  public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
    List<String> details = new ArrayList<>();
    details.add(ex.getLocalizedMessage());
    ErrorOutput error = new ErrorOutput();
    error.setErrorCodes(new ArrayList<>());
    error.getErrorCodes().add(Errors.GENERIC_ERROR);
    error.setErrorMessages(new ArrayList<>());
    error.getErrorMessages().add(Errors.getMessageForCode(Errors.GENERIC_ERROR));
    return new ResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
  }

  /**
   * Handle all exceptions response entity.
   *
   * @param ex      the ex
   * @param request the request
   * @return the response entity
   */
  @ExceptionHandler(ParkingFunctionalException.class)
  public final ResponseEntity<Object> handleAllExceptions(ParkingFunctionalException ex, WebRequest request) {
    List<String> details = new ArrayList<>();
    details.add(ex.getLocalizedMessage());
    ErrorOutput error = new ErrorOutput();
    error.setErrorCodes(new ArrayList<>());
    error.getErrorCodes().add(ex.getErrorCode());
    error.setErrorMessages(new ArrayList<>());
    error.getErrorMessages().add(ex.getMessage());
    error.setSuccess(false);
    return new ResponseEntity(error, HttpStatus.BAD_REQUEST);
  }

  /**
   * Handle constraint violation response entity.
   *
   * @param ex      the ex
   * @param request the request
   * @return the response entity
   */
  @ExceptionHandler
      ({ ConstraintViolationException.class })
  public ResponseEntity<ErrorOutput> handleConstraintViolation(ConstraintViolationException ex, WebRequest request) {
    List<String> errorCodes = new ArrayList<>();
    List<String> errorMessages = new ArrayList<>();
    for (ConstraintViolation<?> violation : ex.getConstraintViolations()) {
      errorCodes.add(violation.getMessage());
      errorMessages.add(Errors.getMessageForCode(violation.getMessage()));
    }
    ErrorOutput output = new ErrorOutput();
    output.setErrorCodes(errorCodes);
    output.setErrorMessages(errorMessages);
    return new ResponseEntity<>(output, new HttpHeaders(), HttpStatus.BAD_REQUEST);
  }

  @Override
  public ResponseEntity<Object> handleMethodArgumentNotValid(
      MethodArgumentNotValidException ex,
      HttpHeaders headers,
      HttpStatus status,
      WebRequest request) {
    List<String> errorCodes = new ArrayList<>();
    List<String> errorMessages = new ArrayList<>();
    for (FieldError error : ex.getBindingResult().getFieldErrors()) {
      errorCodes.add(error.getDefaultMessage());
      errorMessages.add(Errors.getMessageForCode(error.getDefaultMessage()));
    }
    ErrorOutput output = new ErrorOutput();
    output.setErrorCodes(errorCodes);
    output.setErrorMessages(errorMessages);
    return new ResponseEntity<>(output, new HttpHeaders(), HttpStatus.BAD_REQUEST);
  }
  @ExceptionHandler({ MethodArgumentTypeMismatchException.class })
  public ResponseEntity<Object> handleMethodArgumentTypeMismatch(
      MethodArgumentTypeMismatchException ex, WebRequest request) {
    String error =
        ex.getName() + " should be of type " + ex.getRequiredType().getName();
    List<String> errorCodes = new ArrayList<>();
    List<String> errorMessages = new ArrayList<>();
    ErrorOutput output = new ErrorOutput();
    errorCodes.add(Errors.INVALID_TYPE_ERROR_CODE);
    errorCodes.add(Errors.getMessageForCode(Errors.INVALID_TYPE_ERROR_CODE));
    output.setErrorCodes(errorCodes);
    output.setErrorMessages(errorMessages);
    return new ResponseEntity<>(output, new HttpHeaders(), HttpStatus.BAD_REQUEST);

  }
}