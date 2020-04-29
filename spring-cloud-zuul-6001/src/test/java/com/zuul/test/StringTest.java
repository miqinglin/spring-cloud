package com.zuul.test;

public class StringTest {
	
	private static String str = "";
	private static int temp =0;

	public static void main(String[] args) {
		str = "hello";
		temp = 10;
		changeStr(str);
		changeStr(temp);
		System.out.println(str);
		System.out.println(temp);
	}
	
	public static void changeStr(String str){
		str = "com";
	}
	
	public static void changeStr(int str){
		str = 20;
	}
}
