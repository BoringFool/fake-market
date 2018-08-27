package com.zm.test;

import java.io.UnsupportedEncodingException;

import org.junit.Test;

public class All {

	@Test
	public void test() throws UnsupportedEncodingException {
		String a = "������ʾ��Course��һ��������ά��";
		String news = new String(a.getBytes("gb2312"), "UTF-8");
		System.out.println(news);
	}

	@Test
	public void testBefore() {
		String s1 = "Programming";
		String s2 = new String("Programming");
		String s3 = "Program" + "ming";
		System.out.println(s1 == s2);
		System.out.println(s1 == s3);
		System.out.println(s1 == s1.intern());
	}

	@Test
	public void test_e() {
		
	}
}
