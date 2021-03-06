package 正则表达式;

import java.util.regex.Pattern;

public class RegexTest4_字符类
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		System.out.println(Pattern.matches("hello[abc]", "helloc"));//true true  匹配helloa或者hellob或者helloc
		System.out.println(Pattern.matches("helloa|b|c", "b")); //true  匹配helloa或者b或者c  （hellob和helloc不会匹配）
		System.out.println(Pattern.matches("[^abc]", "f")); //true 匹配非abc的任意一个字符
		System.out.println(Pattern.matches("[0-9]", "9"));
		System.out.println(Pattern.matches("[a-zA-Z]", "a"));
		System.out.println(Pattern.matches("[0-9a-zA-Z_]", "_"));//true 0-9或者a-z或者A-Z或者_
		System.out.println(Pattern.matches("[.]", ".")); //true [.]相对于[\.]
		System.out.println(Pattern.matches("[\\\\]", "\\")); //true  在java中的[\\\\]相对于在正则表达式中的[\\]
		System.out.println(Pattern.matches("[20-93]", "3"));//正则表达式只能匹配字符串，不懂数的大小（所以这行代码没有意义）
		System.out.println(Pattern.matches("[\\w]", "你")); //false  代表一个单词字符，类似于[a-zA-Z0-9_] java中这个正则表达式不支持匹配中文
		System.out.println(Pattern.matches("[\\W]", "你")); //true  代表一个非单词字符，类似于[^a-zA-Z0-9_] 支持中文
		System.out.println(Pattern.matches("[\\d]", "3")); //true 代表一个数字字符，等同于[0-9]
		System.out.println(Pattern.matches("[\\D]", "e")); //true 代表一个非数字字符，等同于[^0-9]
		System.out.println(Pattern.matches("[\\s]", " ")); //true 代表一个空白字符 （有个空格）
		System.out.println(Pattern.matches("[\\S]", "s")); //true 代表一个非空白字符

	}
}
