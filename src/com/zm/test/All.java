package com.zm.test;

import java.io.UnsupportedEncodingException;

import org.junit.Test;

public class All {

	@Test
	public void test() throws UnsupportedEncodingException {
		String a = "������ʾ��Course��һ��������ά��";
		String news=new String(a.getBytes("gb2312"),"UTF-8");
		System.out.println(news);
	}

}
