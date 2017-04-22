package com.rupeng.oop.Compare;

public class StringCompare
{
	public static void main(String[] args)
	{
		String s1 = "abc";
		String s2 = "ABC";
		String s4 = "acd";
		System.out.println(s1.compareTo(s2)); 
		System.out.println(s2.compareTo(s1)); 
		System.out.println(s1.compareTo(s4));
		//两个字符串如果内容完全相等则返回0
		//如果第一个字符和anotherString的第一个字符不相等，则返回他们第一个字符的差。this-anotherString
		//如果第一个字符相等，那么则比较第二个字符，如果不相等则返回第二关字符的差（以此类推），一直比较到不相等为止，如果最后一个还相等，则返回0
		
		String s5= "abc34";
		System.out.println(s1.compareTo(s5));
		//如果比较完一个，另外一个字符串还剩一点，则返回this.length()-anotherString.length()
		String s6 = "abc3";
		System.out.println(s5.compareTo(s6));
		
		
		//如果第一个字符串比第二个字符串大（这里分两种情况）
		//（1）s1在从左往右的某个字符比s2的对应的位置字符大---如果第一个字符和anotherString的第一个字符不相等，则返回他们第一个字符的差。this-anotherString,如果第一个字符相等，那么则比较第二个字符，如果不相等则返回第二关字符的差（以此类推），一直比较到不相等为止，如果最后一个还相等，则返回0
		//（2）s1和s2的每一位都一样，但是s1比s2长,则返回this.length()-anotherString.length()
		//如果返回负数，就是s1比s2小
	}
}
