package com.example.springboot.utils;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import org.springframework.stereotype.Component;

@Component
public class JsonUtil {
	private final static Gson gson = new Gson();


	public static String object2Gson(Object object) {
		return gson.toJson(object);
	}

	public static String object2Json(Object object) {
		return JSON.toJSON(object).toString();
	}


}
