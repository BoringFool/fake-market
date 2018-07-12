package com.zm.test;

import java.util.Arrays;

import org.junit.Test;

import com.zm.myuntil.StringArray;

public class TestSplit {

	@Test
	public void splitT(){
		String s=new String();
		s="[\"asd\",\"123\",\"asd\"]";
		System.out.println(s);	
		s=s.replace("[", " ");
		s=s.replace("]", " ");
		s=s.trim();
		System.out.println(s+"a");
		String[] ss=s.split(",");
		System.out.println(ss);
		for(int i=0;i<ss.length;i++){
			ss[i]=ss[i].substring(1,ss[i].length()-1);
			System.out.println(ss[i]);
		}
		for(int i=0;i<ss.length;i++){
			System.out.print(ss[i]);
		}
		
		
		/*简单使用*/
		System.out.println("\n************");
		String as="[\"asd\",\"123\",\"asd\"]";
		System.out.println(as);
		//as.length-1，因为从0开始，且substring的end是不包括的
		as=as.substring(1,as.length()-1);
		System.out.println(as);
		String[] ass=as.split(",");
		for(int i=0;i<ass.length;i++){
			ass[i]=ass[i].replace("\"", "");
			System.out.println(ass[i]);
		}
		
		/*实际使用*/
		System.out.println("\nnew************");
		String asa="[\"asd1\",123,\"asd\"]";
		String[] asas=StringArray.turn(asa);
		for(int i=0;i<asas.length;i++){
			System.out.println(asas[i]);
		}
		System.out.println(asas[0]);
		
		
		/*实际使用*/
		System.out.println("\nnew************");
		String jsonstring="[\"work\",123,\"asd\"]";
		String st=StringArray.jsonget(jsonstring, 0);
		System.out.println(st);
		
		//
		System.out.println("\nnew************");
		String[] sarray=new String[3];
		sarray[0]="work";
		sarray[1]="123";
		sarray[2]="asd";
		String string=Arrays.toString(sarray);
		
		System.out.println(string);
		String[] stringa=string.split(",");
		for(int i=0;i<stringa.length;i++){
			System.out.println(stringa[i]);
		}
		
		//
		System.out.println("\nnew************");
		String[] stringarray=new String[3];
		stringarray[0]="work";
		stringarray[1]="123";
		stringarray[2]="asd";
		for(String it:stringarray){
			System.out.println(it);
		}
		String lstring=StringArray.ArrayToString(stringarray);
		System.out.println(lstring+"这是string");
		String[] rstring=StringArray.stringToArray(lstring);
		for(String it:rstring){
			System.out.println(it);
		}
		
	}
}
