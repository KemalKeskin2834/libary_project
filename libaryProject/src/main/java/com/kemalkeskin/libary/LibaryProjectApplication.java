package com.kemalkeskin.libary;

import com.kemalkeskin.libary.core.exception.BusinessException;
import com.kemalkeskin.libary.core.exception.ProblemDetails;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@SpringBootApplication
@RestControllerAdvice
public class LibaryProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibaryProjectApplication.class, args);
	}


	@ExceptionHandler
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ProblemDetails handlerProblemDetails(BusinessException businessException){
		ProblemDetails problemDetails=new ProblemDetails(businessException.getMessage());
		return problemDetails;
	}
}
