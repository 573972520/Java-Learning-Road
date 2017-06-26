package commonslangtest;

import org.apache.commons.lang3.StringUtils;

public class MainStringUtils {

	public static void main(String[] args) {
		/*// TODO Auto-generated method stub
		String s1 = "rupeng";
		String s2 = "";
		String s3 = null;
		System.out.println(StringUtils.isEmpty(s1));
		System.out.println(StringUtils.isEmpty(s2)); //flase
		System.out.println(StringUtils.isEmpty(s3)); //flase
		
		//if(s3.length() == 0) //调用s3指向对象的length()方法  当s3为null，它没有指向任何对象，所以会报异常：java.lang.NullPointerException
		//if(s3.equals("")) //调用s3指向对象的equals()方法，当s3为null，它没有指向任何对象，所以会报异常：java.lang.NullPointerException
		if(StringUtils.isEmpty(s3))
		{
			System.out.println("s1为空");
		}*/
		
		/*
		String[] strs = {"rupeng","qq","ali"};
		String s = StringUtils.join(strs,"|");
		System.out.println(s);
		*/
		
		
		String s = "哈石,佛你说点评覅轰死哦";
		String s1 = "哈石";
		
		String t0_1 = StringUtils.left(s, 6);
		String t0_2 = StringUtils.left(s1, 6);
		String t1_1 = s.substring(0, 6);
		//String t1_2 = s1.substring(0, 6); 
		
		//当substring处理的字符串长度小于规定的字符串长度时会报错：java.lang.StringIndexOutOfBoundsException: String index out of range: 6
		//但是left处理的字符串长度小于规定的字符串长度时不会报错
		
		System.out.println(t0_1);
		System.out.println(t0_2);
		System.out.println(t1_1);
		//System.out.println(t1_2);
		
		
		String s2 = "如鹏网";
		String t = StringUtils.leftPad(s2, 20); //补齐
		String t1 = StringUtils.leftPad(s2, 10,'*'); //使用*补齐
		System.out.println(t);
		System.out.println(t1);
		
		
		String s3 = StringUtils.repeat('a', 5);
		System.out.println(s3);
		
	}

}
