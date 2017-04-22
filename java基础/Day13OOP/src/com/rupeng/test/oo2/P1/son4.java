package com.rupeng.test.oo2.P1;

import com.rupeng.test.oo2.father;

public class son4 extends father
{
	public static void main(String[] args)
	{
		son4 s1 = new son4();
		s1.开金库();
		//s1.Default方法(); //不能调用Default（因为文件未在同一个package包中）
		//s1.count++; //不能调用Default字段（因为文件未在同一个package包中）
	}
}
