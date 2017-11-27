package com.poc.springboot.util;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Utililies {

	public static  String getJSONString(Object obj) throws JsonProcessingException {
		 ObjectMapper objectMapper = new ObjectMapper();
		 return  objectMapper.writeValueAsString(obj);
	}
	
	
	public static <T>T getObjectFromJSON(String json,Class<T> type) throws IOException {
		ObjectMapper objectMapper = new ObjectMapper();
//		objectMapper.configure(DeserializationFeature.UNWRAP_ROOT_VALUE, false);
		return  objectMapper.readValue(json.getBytes(), type);
		
	}
}
