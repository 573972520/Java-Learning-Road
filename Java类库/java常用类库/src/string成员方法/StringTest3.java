package string成员方法;

public class StringTest3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "aBcD123";
		
		//s.toLowerCase();
		System.out.println(s); //结果还是和先前定义的字符串一样，因为字符串一旦声明之后就不能改变了
		System.out.println(s.toLowerCase());
		
		s = "aaa";//把String类型的变量s指向了新的"aaa"对象
		s = s.toUpperCase();//根据s创建一个全是大写的字符串对象，然后s指向这个新的字符串对象
		System.out.println(s); 
		
		s = s.replace("A", "一"); //替换
		System.out.println(s);
		
		String s1 = "药,姚明,fuck";
		String[] names = s1.split(",");
		for(int i = 0;i<names.length;i++)
		{
			System.out.println(names[i]);
		}
		
		
		//去掉字符串中的空格（不管空格在哪里）
		String s2 = " adm in"; //前面有一空格
		System.out.println(s2.equals("admin"));//false
		s2 = s2.trim();
		s2 = s2.replace(" ", ""); //把中间的空格去掉
		System.out.println(s2.equals("admin"));//true
		
	}

}
