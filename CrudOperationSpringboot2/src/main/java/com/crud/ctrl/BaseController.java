package com.crud.ctrl;
import com.crud.exceptionhandler.*;

import java.util.NoSuchElementException;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@RestControllerAdvice
public class BaseController {
	
	 private final Logger logger = LoggerFactory.getLogger(getClass());

	 protected static class HttpExceptionJson {
        public final String incidentID;
        public final int errorCode;
        
        @JsonInclude(Include.NON_EMPTY)
        public final String description;

        public HttpExceptionJson(int errorCode, String description) {
            this.incidentID = UUID.randomUUID().toString();
            this.errorCode = errorCode;
            this.description = description;
        }
    }
	
	@ExceptionHandler(NullPointerException.class)
	public @ResponseBody HttpExceptionJson handleUserNotFound(NullPointerException obj) {
		
		HttpExceptionJson objx= new HttpExceptionJson(2205, "please enter valid id");
		logger.error("null pointer {}",obj.fillInStackTrace());
		return objx;
		
		
	}
	
	
	@ExceptionHandler(NoSuchElementException.class)
	public @ResponseBody HttpExceptionJson NoSuch(NoSuchElementException obj) {
		
		HttpExceptionJson objx= new HttpExceptionJson(2206, "please  id not exist");
		logger.error("id not available  pointer {}",obj.fillInStackTrace());
		return objx;
		
		
	}
	
	
	@ExceptionHandler(IdFormatException.class)
	public @ResponseBody HttpExceptionJson IdFormatException(IdFormatException obj) {
		
		HttpExceptionJson objx= new HttpExceptionJson(2102, obj.getDiscription());
		logger.error(objx.incidentID);
		logger.error("id is less then 2   id is = {}",obj.getId());
		return objx;
		
		
	}
	
	
	
	@ExceptionHandler(Exception.class)
	public @ResponseBody HttpExceptionJson ExceptionHandle(Exception obj) {
		
		HttpExceptionJson objx= new HttpExceptionJson(5000, "Unknown Exception");
		logger.error(objx.incidentID);
		logger.error("Unknown Exception",obj.getCause());
		return objx;
		
		
	}

	

}
