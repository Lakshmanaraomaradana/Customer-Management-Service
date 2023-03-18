package com.customer.management.bean;

import java.util.Date;

import org.springframework.http.HttpStatus;


import lombok.Builder;
import lombok.Data;
import lombok.Value;

@Value
@Data
@Builder(toBuilder=true)
public class Response<T> {
	
	private HttpStatus code;
	private String module;
	private Date timestamp;
	private T result;

}
