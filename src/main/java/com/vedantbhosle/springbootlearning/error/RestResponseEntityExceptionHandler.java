package com.vedantbhosle.springbootlearning.error;

import com.vedantbhosle.springbootlearning.entity.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
@ControllerAdvice//@ControllerAdvice, which makes it a global controller advice. It means that it will be used to define exception handling for all controllers in the application.whatever class you are creating to handle you expection should be annoted by controllerAdvice
@ResponseStatus//The @ResponseStatus annotation in Spring is used to declare the HTTP response status code that should be returned when a specific exception is thrown. This annotation can be applied to an exception class or a handler method within a @ControllerAdvice.
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(DepartmentNotFoundException.class)//This annotation is used to declare a method as an exception handler for the specified exception (DepartmentNotFoundException). When an exception of this type is thrown within any controller method, this handler method will be invoked.
public ResponseEntity<ErrorMessage> departmentNotFoundException(DepartmentNotFoundException exception, WebRequest request){
ErrorMessage message=new ErrorMessage(HttpStatus.NOT_FOUND,exception.getMessage());

return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
}

}


//    when a DepartmentNotFoundException is thrown during the execution of the application (for example, in the fetchDepartmentById method), the global exception handler defined in RestResponseEntityExceptionHandler intercepts it, creates an appropriate error response, and sends it back to the client. This way, you can provide a standardized way to handle specific exceptions across your application.