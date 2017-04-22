package com.rupeng.oop.Compare;

public class equalsTest
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		
		//字符串缓冲池
		//看起来String s1 = "abc"没有new，但是其实有new的
		String s1 = "abc";//在内存中创建一个字符串对象，内容是“abc”,把s1指向这个字符串对象
		String s2 = "abc";//发现已经有了一个“abc”字符串对象了，因此把s2直接指向之前的“abc”
		System.out.println(s1 == s2); //true
		System.out.println(s1.equals(s2));//true
		
		String s3 = "ab"+"c";//这里编译器进行了优化，使之成为了String s3 = "abc";
		System.out.println(s1 == s3);//true
		System.out.println(s1.equals(s3));//true
		
		String s4 = new String("abc");//只要new就是创建一个新的对象，即创建了一个和"abc"内容一样的新字符串对象
		System.out.println(s1 == s4);//false
		System.out.println(s1.equals(s4));//true
		
		
		//==永远但是用来比较两边是否指向同一个对象
		//equals则是用来进行内容的比较的
	}

}
