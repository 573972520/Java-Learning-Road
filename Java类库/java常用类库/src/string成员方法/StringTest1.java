package string成员方法;

public class StringTest1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String username = "ADmin";
		if(username.equalsIgnoreCase("admin")) //equalsIgnoreCase不区分大小写, equals区分大小写
		{
			System.out.println("用户名正确");
		}
		else
		{
			System.out.println("用户名错误");
		}
		
		String s = "http://www.google.com";
		if(s.startsWith("http://")&&s.endsWith(".com")||s.endsWith(".cn"))
		{
			System.out.println("yes");
		}
		else
		{
			System.out.println("no");
		}
		
		String s1 = "asd";
		System.out.println(s1.contains("a"));
		
	}

}
