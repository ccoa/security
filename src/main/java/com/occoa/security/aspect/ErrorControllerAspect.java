package com.occoa.security.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.occoa.security.model.Error;
import com.occoa.security.service.ErrorService;

@Aspect
@Component
public class ErrorControllerAspect {
	
	@Autowired
	private ErrorService errorService;
	
	@Pointcut("execution(* com.occoa.security.controller.*.*(..))")
	public void pointCutControllersSecurity() {
		
	}
	
	@Around("(pointCutControllersSecurity())")
	public Object saveError(ProceedingJoinPoint joinPoint) throws Throwable {
		Object response = null;
		
		try {
			response = joinPoint.proceed();
		} catch (Throwable throwable) {

			Error error = errorService.register(throwable);
			
			response = new ResponseEntity<Object>(error, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return response;
	}

}
