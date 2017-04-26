package file文件处理;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class StreamTest1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//FileOutputStream fos = new FileOutputStream("");
		/*
		String s = "a你";
		System.out.print(s.length());
		byte[] bytes1 = s.getBytes();
		System.out.print(bytes1.length);
		*/
		
		try 
		{
			OutputStream fos = new FileOutputStream("d:\\1.txt");//多态   变量类型尽量定义成父类的类型（在能够满足需求的情况下）
			byte[] bytes = "abc你好啊".getBytes();
			//'a'字母,'1'占一个字节byte
			//'你'则占两个字节
			fos.write(bytes);
			fos.close();
			
		} 
		catch (FileNotFoundException e) 
		{
			System.out.print("文件找不到");
		}
		catch (IOException e)	//把IOException放到FileNotFoundException上面，FileNotFoundException就没有意义了，因为FileNotFoundException是IOException的子类
		{
			System.out.print("写入出错");
		}
		
	}

}
