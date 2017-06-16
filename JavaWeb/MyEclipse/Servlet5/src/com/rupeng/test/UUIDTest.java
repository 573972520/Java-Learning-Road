package com.rupeng.test;

import java.util.UUID;

public class UUIDTest {

	public static void main(String[] args) {
		for(int i =0;i<100;i++)
		{
			UUID id = UUID.randomUUID(); //生成一个全球唯一的不会重复的字符串
			String s1 = id.toString();
			System.out.println(s1);
		}
	}
}
