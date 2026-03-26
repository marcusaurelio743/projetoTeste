package projetoTeste.exeption.handle;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import projetoTeste.exeption.ExceptionResponse;
import projetoTeste.exeption.UnsuportOperationExeption;

@RestController
@ControllerAdvice
public class CustonEntityResponseHandle  extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ExceptionResponse> handeAllExeption(Exception ex, WebRequest request){
		ExceptionResponse exception = new ExceptionResponse(
				new Date(), 
				ex.getMessage(),
				request.getDescription(false));
		
		return new ResponseEntity<>(exception, HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	@ExceptionHandler(UnsuportOperationExeption.class)
	public final ResponseEntity<ExceptionResponse> handeBadRequestExeption(Exception ex, WebRequest request){
		ExceptionResponse exception = new ExceptionResponse(
				new Date(), 
				ex.getMessage(),
				request.getDescription(false));
		
		return new ResponseEntity<>(exception, HttpStatus.BAD_REQUEST);
		
	}

}
