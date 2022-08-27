package com.ofss.student.util;
import com.google.gson.Gson;

public class JSONConverter {
	private static Gson gson = new Gson();
	public static String convert(Object object) {
		return gson.toJson(object);
	}

}
