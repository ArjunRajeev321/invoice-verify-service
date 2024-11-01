package com.verification.verification_service.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class ResponseWrapper<T> {

	private int statusCode;

	private String response;

	private T data;
}
