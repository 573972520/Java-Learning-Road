package string成员方法;

public class StringTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		String s = "abc123aca";
		System.out.println(s.length());//9
		System.out.println(s.charAt(2));//c
		System.out.println(s.indexOf('a'));//0
		System.out.println(s.indexOf("12"));//3
		System.out.println(s.lastIndexOf('a'));//8
		
		
		String s1 = s.substring(3);//substring是返回截取后的字符串
		System.out.println(s); //被截取的字符串不会改变
		System.out.println(s1);
		String s2 = s.substring(3,5);
		System.out.println(s2);
		*/
		
		/**
		 * 获取文件名和文件格式
		String s = "[ABP-185]林志玲.avi";
		int dotIndex = s.indexOf('.');//获取"."第一次出现的位置
		String name = s.substring(0,dotIndex);
		System.out.println(name);
		String ext = s.substring(dotIndex+1);
		System.out.println(ext);
		*/
		
		
		/**
		 * 获取番号
		String s = "[ABP-185]林志玲.avi";
		int k1Index = s.indexOf('[');
		int k2Index = s.indexOf(']');
		System.out.println(k1Index);
		System.out.println(k2Index);
		System.out.println(s.substring(k1Index+1, k2Index));
		 */
		
		/**
		 * 获取文件名和文件格式(改进版)
		String s = "[ABP-185]林志玲.avi.app";
		int lastDotIndex = s.lastIndexOf('.');
		System.out.println(lastDotIndex);
		System.out.println(s.substring(0, lastDotIndex));
		System.out.println(s.substring(lastDotIndex+1));
		*/
	}

}
