package com.example.demo.businessLogic;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Utility {
	public static String getObjectAsJSONString(Object obj) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			String jsonContent = mapper.writeValueAsString(obj);
			System.out.println(jsonContent);
			return jsonContent;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
