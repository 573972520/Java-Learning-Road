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
		System.out.print(s.length()); //结果为：2
		byte[] bytes1 = s.getBytes();
		System.out.print(bytes1.length); //结果为：3
		
		
		try 
		{
			OutputStream fos = new FileOutputStream("d:\\1.txt");//多态   变量类型尽量定义成父类的类型（在能够满足需求的情况下）
			byte[] bytes = "abc你好啊".getBytes();
			//'a'字母,'1'占一个字节byte
			//'你'则占两个字节
			fos.write(bytes);
			fos.close();//存在着上面的代码出现异常，没有被close的情况
		} 
		catch (FileNotFoundException e) 
		{
			System.out.print("文件找不到");
		}
		catch (IOException e)	//把IOException放到FileNotFoundException上面，FileNotFoundException就没有意义了，因为FileNotFoundException是IOException的子类
		{
			System.out.print("写入出错");
		}
		
		*/
		
		//fos.close();//存在着上面的代码出现异常，没有被close的情况的解决方法
		OutputStream fos = null; //fos声明到try外面，才能被finally访问到
		//为什么fos要等于null，因为如果不写，那么try中的fos赋值有不被执行的可能，那么fos在finally中就是未赋值的变量
		try
		{
			fos = new FileOutputStream("d:\\1.txt"); //万一这里出现了异常，并且fos未被赋值，那么到下面的finally中的if判断中就出现错误了（错误信息为：局部变量fos可能尚未初始化）
			byte[] bytes = "abc你好啊".getBytes();
			fos.write(bytes);//每次写入，下次write的时候是从上次write完成的位置开始
		}
		catch (IOException e)
		{
			System.out.print("写入出错");
		}
		finally //无论发生什么异常，都将会执行
		{
			//万一fos没有被赋值，那么fos就是null,那么fos.close()就会抛出NullPointerException
			if(fos != null) //局部变量使用前必须被赋值
			{
				try 
				{
					fos.close();
				} 
				catch (IOException e) 
				{
					// 什么也不做！--- CloseQuietly(安静的关闭)，因为后面还可能会关闭别人，不能因为关闭它出现异常就没机会关闭别人。
				}
			}
		}
	}

}
