package com.occoa.security.service.impl;

import java.io.StringWriter;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.occoa.security.aspect.ErrorControllerAspect;
import com.occoa.security.dao.ErrorDao;
import com.occoa.security.model.Error;
import com.occoa.security.service.ErrorService;

@Service
public class ErrorServiceImpl implements ErrorService {
	private static final Logger log = LoggerFactory.getLogger(ErrorControllerAspect.class);
	
	@Value("${app.name}")
	private String applicationName;
	
	@Autowired
	private ErrorDao errorDao;
	
	@Override
	public Error register(Throwable throwable) {
		StringWriter sw = new StringWriter();
		String stackTrace = sw.toString();
		log.error(stackTrace);
		
		Error error = new Error();
		error.setRegisterDateTime(new Date());
		error.setApplicationName(applicationName);
		error.setStackTrace(stackTrace);
		
		return errorDao.save(error);
	}

}
