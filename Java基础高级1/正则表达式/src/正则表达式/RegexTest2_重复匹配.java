package 正则表达式;

import java.util.regex.Pattern;

public class RegexTest2_重复匹配
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		String regex = "a{0}"; //要求a连续出现0次 
		String str = "";
		boolean match = Pattern.matches(regex, str);
		System.out.println(match);//true

		String regex1 = "a{5}"; //要求a连续出现5次 
		String str1 = "aaaaa";
		boolean match1 = Pattern.matches(regex1, str1);
		System.out.println(match1);//true

		String regex2 = "helloa{3}"; //要求a连续出现3次 
		String str2 = "helloaaa"; //如果前面的hello没有一样并且a没有连续出现3次，则不能匹配，例如hellopaaa就不行 
		boolean match2 = Pattern.matches(regex2, str2);
		System.out.println(match2);//true

		String regex3 = ".{3}"; //任意的三个字符，相对于...
		String str3 = "4y陈";
		boolean match3 = Pattern.matches(regex3, str3);
		System.out.println(match3);//true

		String regex4 = "a{3,}"; //a至少连续出现3次，str4="aaa..."
		String str4 = "aaaaaaa";
		boolean match4 = Pattern.matches(regex4, str4);
		System.out.println(match4);//true

		String regex5 = "a{2,5}"; //要求a至少连续出现2次，最多连续出现5次 
		String str5 = "aaaa";
		boolean match5 = Pattern.matches(regex5, str5);
		System.out.println(match5);//true

		System.out.println(Pattern.matches("a*", "")); //true  a连续出现0次或多次，等同于a{0,}
		System.out.println(Pattern.matches("x+", "xxx")); //true  x至少连续出现1次，等同于x{1,}	
		System.out.println(Pattern.matches("x?", "x")); //true   ?     x出现0次或1次，等同于x{0,1}

	}

}
