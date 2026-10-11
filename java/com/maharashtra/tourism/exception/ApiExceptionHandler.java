package com.maharashtra.tourism.exception;
import org.springframework.http.*;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.converter.HttpMessageNotReadableException;
import java.util.*;
@RestControllerAdvice
public class ApiExceptionHandler {
 @ExceptionHandler(NotFoundException.class) public ResponseEntity<Map<String,String>> notFound(NotFoundException e){return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("message",e.getMessage()));}
 @ExceptionHandler(MethodArgumentNotValidException.class) public ResponseEntity<Map<String,String>> invalid(MethodArgumentNotValidException e){String msg=e.getBindingResult().getFieldErrors().stream().findFirst().map(x->x.getField()+": invalid or missing value").orElse("Please check your input.");return ResponseEntity.badRequest().body(Map.of("message",msg));}
 @ExceptionHandler({IllegalArgumentException.class,HttpMessageNotReadableException.class}) public ResponseEntity<Map<String,String>> badRequest(Exception e){return ResponseEntity.badRequest().body(Map.of("message","Please provide valid request values."));}
 @ExceptionHandler(Exception.class) public ResponseEntity<Map<String,String>> unexpected(Exception e){return ResponseEntity.status(500).body(Map.of("message","Something went wrong. Please try again."));}
}
