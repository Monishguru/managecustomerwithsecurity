/*
 * package com.monish.managecustomer.controlleradvice;
 * 
 * import java.time.LocalDate; import java.util.HashMap; import java.util.Map;
 * 
 * import org.springframework.dao.EmptyResultDataAccessException; import
 * org.springframework.http.HttpStatus; import
 * org.springframework.http.ResponseEntity; import
 * org.springframework.web.bind.annotation.ControllerAdvice; import
 * org.springframework.web.bind.annotation.ExceptionHandler;
 * 
 * @ControllerAdvice public class CustomerControllerAdvice {
 * 
 * @ExceptionHandler public ResponseEntity<Object>
 * handleEmptyResult(EmptyResultDataAccessException exception) {
 * Map<String,Object> responseMap = new HashMap(); responseMap.put("message",
 * "Record Not Found"); responseMap.put("time", LocalDate.now()); return new
 * ResponseEntity<Object>(responseMap, HttpStatus.NOT_FOUND); }
 * 
 * @ExceptionHandler public ResponseEntity<Object>
 * handleNullPointer(NullPointerException exception) {
 * 
 * Map<String,Object> responseMap = new HashMap(); responseMap.put("message",
 * "Oops Not coded properly.Report it at test@gmail.com");
 * responseMap.put("time", LocalDate.now()); return new
 * ResponseEntity<Object>(responseMap, HttpStatus.INTERNAL_SERVER_ERROR);
 * 
 * }
 * 
 * }
 */