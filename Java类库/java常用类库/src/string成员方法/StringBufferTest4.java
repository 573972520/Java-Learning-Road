package string成员方法;

public class StringBufferTest4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//问题提出:String s = "111"+"222"+"444";这个字符串s会被编译器优化成String s = "111222444";
		//但是对于String s4= s1+s2+s3;来说，每次+就会生成一个新的String对象（那这个例子s4来说有5个字符串对象——s1,s2,s3,s1+s2,s1+s2+s3），当对象比较多的时候会产生临时字符串对象,所以会对性能产生影响
		String s1 = "aaa";
		String s2 = "bbb";
		String s3 = "ccc";
		String s4= s1+s2+s3;
		System.out.println(s4);
		
		/*
		StringBuffer sb = new StringBuffer();
		sb.append(s1);
		sb.append(s2);
		sb.append(s3);
		String s5 = sb.toString();//最终转换成一个字符串
		System.out.println(s5);
		*/
		
		
		StringBuffer sb = new StringBuffer();
		sb.append(s1).append(s2).append(s3).append(true).append(23);//链式编程,  append可以有多种数据类型  
		//原理可以看StringBufferPersonTest文件
		String s5 = sb.toString();
		System.out.println(s5);//aaabbbccctrue23
		
		StringBuilder sb1 = new StringBuilder();
		sb1.append("aaa").append(44).append(true); //可以有多种数据类型
		String s6 = sb1.toString();
		System.out.println(s6);//结果aaa44true
	}

}
