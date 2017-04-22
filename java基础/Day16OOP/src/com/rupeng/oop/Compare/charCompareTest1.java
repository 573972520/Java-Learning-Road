package com.rupeng.oop.Compare;

public class charCompareTest1
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		String s1 = "123";
		String s2 = "456";
		String s3 = "12";
		String s4 = "abc";
		System.out.println(s1.compareTo(s2));
		System.out.println(s1.compareTo(s3));
		//Java中字符串大小的比较使用compareTo方法判断
		char c1 = 'a';//char其实也是一个数字
		System.out.println((int)c1);//‘a’在计算机中使用整数97表示
		char c2 = '1';
		System.out.println((int)c2);//‘1’在计算机中使用整数49表示
		
		int i1 = 33;
		char c3 = (char)i1;
		System.out.println(c3); //结果为“!”
		
		//ASCII码就是规定字符用什么整数来表示的标准
		//char由于也是用整数来比较的，所以说char的大小其实就是char的整数的大小
		
		System.out.println('a' > 1);//true
		System.out.println('a' > 'b');//false
		System.out.println('a' > 'A');//true
	}

}
