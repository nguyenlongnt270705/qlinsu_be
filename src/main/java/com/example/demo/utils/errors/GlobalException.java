package com.example.demo.utils.errors;

import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {

    // @ExceptionHandler(value = {
    //     UsernameNotFoundException.class,
    //     BadCredentialsException.class
    // })
    // public ResponseEntity<RestResponse<Object>> handleIdException(Exception ex) {
    //     RestResponse<Object> res = new RestResponse<>();
    //     res.setStatusCode(HttpStatus.BAD_REQUEST.value());
    //     res.setError(ex.getMessage());
    //     res.setMessage("Exception occurs");
    //     return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(res);
    // }
    // @ExceptionHandler(MethodArgumentNotValidException.class)
    // public ResponseEntity<RestResponse<Object>> validationError(MethodArgumentNotValidException ex) {
    //     BindingResult result = ex.getBindingResult();
    //     final List<FieldError> fieldErrors = result.getFieldErrors();
    //     RestResponse<Object> res = new RestResponse<Object>();
    //     res.setStatusCode(HttpStatus.BAD_REQUEST.value());
    //     res.setError(ex.getBody().getDetail());
    //     List<String> errors = fieldErrors.stream().map(f -> f.getDefaultMessage()).collect(Collectors.toList());
    //     res.setMessage(errors.size() > 1 ? errors : errors.get(0));
    //     return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(res);
    // }
}
