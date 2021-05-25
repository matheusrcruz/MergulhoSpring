package com.easy.easylog.execptionhandler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.easy.easylog.domain.service.exception.ServiceExcption;
import com.easy.easylog.execptionhandler.Problem.Inputs;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@ControllerAdvice // anotação global de trataiva de exception e classe com varias tratativas de exeções
public class ApiExecptionHandler extends ResponseEntityExceptionHandler {
	
	private MessageSource messageSource;
		
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		List<Problem.Inputs> campo = new ArrayList<>();
			
		//variavel error    intera o error para retorna de acordo com a exeções do validation  
		for(ObjectError error: ex.getBindingResult().getAllErrors()) {
			String name = ((FieldError) error).getField();
			String msg = messageSource.getMessage(error, LocaleContextHolder.getLocale());
			
			campo.add(new Problem.Inputs(name, msg));
		}
		
		Problem problem = new Problem();
		 
		problem.setStatus(status.value());
		problem.setDateTime(LocalDateTime.now());
		problem.setTitle("Um ou mais campos estão invalidos");
		problem.setInput(campo);
		
		return handleExceptionInternal(ex, problem, headers, status, request);
	}
	//Casso a execção da class ServiceExicptio estoure esse é o metodo responssavel por trata ele 
	@ExceptionHandler(ServiceExcption.class)
	public ResponseEntity<Object> handleService(ServiceExcption ex){
		Problem problem = new Problem();
		problem.setStatus(status.value());
		problem.setDateTime(LocalDateTime.now());
		problem.setTitle();
		
		return handleExceptionInternal(ex );
	}
	
}
