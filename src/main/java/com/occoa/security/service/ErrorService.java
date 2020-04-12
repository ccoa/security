package com.occoa.security.service;

import com.occoa.security.model.Error;

public interface ErrorService {

	Error register(Throwable throwable) throws Exception;
}
