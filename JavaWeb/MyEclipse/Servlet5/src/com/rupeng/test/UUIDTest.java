package com.rupeng.test;

import java.util.UUID;

public class UUIDTest {

	public static void main(String[] args) {
		for(int i =0;i<100;i++)
		{
			UUID id = UUID.randomUUID(); //����һ��ȫ��Ψһ�Ĳ����ظ����ַ���
			String s1 = id.toString();
			System.out.println(s1);
		}
	}
}
