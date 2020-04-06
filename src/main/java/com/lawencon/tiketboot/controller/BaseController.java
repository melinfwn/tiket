package com.lawencon.tiketboot.controller;

import java.io.IOException;
import java.util.Base64;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public abstract class BaseController<T> {
	
	T model;

	public String[] authUser(String auth) {
		byte[] decodedBytes = Base64.getDecoder().decode(auth);
		String decodedString = new String(decodedBytes);
		String[] authArr = decodedString.split(":");
		return authArr;
	}
	
	public T readValue(String content, Class<T> kelas ) throws JsonParseException, JsonMappingException, IOException { 
		return new ObjectMapper().readValue(content, kelas);
	}
}
