package ascii;

public class ASCII {
	/*
	什么是字符
	答：显示在屏幕上的文字、字母、数字、标点符号、特殊字符和那些看不带到的符号，都是字符
	        一个字符对应一个整数，一个字符对应的整数称为字符的编码，把所有的字符和它们的编码排列在一起形成的表，叫字符编码表
	        
	什么是字符编码表
	答：把所有的字符和它们的编码排列在一起形成的表
	
	ASCII编码表
	  (1)规定了一些最基本的字母、数字、标点符号、特殊符号等字符
	  (2)同类别的字符是按照从小到大的顺序排列的
	  (3)常见类别的字符的开始字符：‘0’--48,  'A'--65,  'a'--97
	
	*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char ch = 'a';
		//char ch1 = "a"; //要使用单引号
		//char ch2 = 'ad';//不能有两个字符
		
		//查看字符‘a’对应的整数
		System.out.println((int)'a');  //结果：97
		
		//char 类型整数的范围(0--65535)
		
		System.out.println((int)Character.MIN_VALUE); //结果：0
		System.out.println((int)Character.MAX_VALUE); //结果：65535
	}

}
