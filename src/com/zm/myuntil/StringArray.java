package com.zm.myuntil;

import org.json.JSONArray;
import org.json.JSONException;

public class StringArray {

	/* 可以直接用jsonarray来实现 */
	public static String[] turn(String s) {
		s = s.substring(1, s.length() - 1);
		String[] ss = s.split(",");
		for (int i = 0; i < ss.length; i++) {
			ss[i] = ss[i].replace("\"", "");
		}
		return ss;
	}

	/* 取得数组转换而来的json字符串中，指定位置的值 */
	public static String jsonget(String s, int num) {
		try {
			JSONArray jarray = new JSONArray(s);
			String st = (String) jarray.get(num);
			return st;
		} catch (JSONException e) {
			e.printStackTrace();
			return null;
		}

	}

	/*
	 * 因为js的toString是加逗号拼接成的string。而java的toString是包含[]的，
	 * 所以重写写了下面两个方法来转换string和array
	 */
	// js发送的string转array
	public static String[] stringToArray(String s) {
		return s.split(",");
	}

	// array转js接受的string
	public static String ArrayToString(String[] s) {
		String news = new String();
		for (String ss : s) {
			news += ss + ",";
		}
		//处理多出来的那个逗号
		return news.substring(0,news.length()-1);
	}
}
