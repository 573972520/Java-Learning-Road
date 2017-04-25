package 异常;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TwoException1 {

	public static void main(String[] args)//第二throws住  throws ParseException,FileNotFoundException
	{
		// TODO Auto-generated method stub
		/*
		try
		{
			if(true)
			{
				//throw new RuntimeException("asdas"); //不会报错，因为RuntimeException为非检查异常
				//throw new Exception("asdas");//会报错,因为其他Exception子类都是检查异常
				throw new IOException("asdas");//会报错,因为其他Exception子类都是检查异常
			}
			if(true)
			{
				throw new SQLException("asdas");
			}
		}
		catch(IOException ex) //解决其他Exception子类都是检查异常报错的问题
		{
			System.out.println("IOException");
		}
		catch(SQLException ex) //解决其他Exception子类都是检查异常报错的问题
		{
			System.out.println("sql异常");
		}
		*/
		
		
		/*
		//Date parse(String source) throw ParseException
		//parse可能会"抛出ParseException异常"(为了解决这个问题将这个异常catch住)
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try
		{
			Date date = sdf.parse("2008-2-02");
			System.out.print(date);
			
			FileInputStream fis = new FileInputStream("w:\\1.txt");
		}
		catch(ParseException ex)
		{
			System.out.println("解析日期异常");
		}
		catch(FileNotFoundException ex)
		{
			System.out.println("文件路径错误");
		}
		*/
		//test(); //发生错误，解决方法有2个
		//第一：catch住
		try
		{
			test();
		}
		catch(ParseException ex)
		{
			ex.printStackTrace();
		}
		catch(FileNotFoundException ex)
		{
			System.out.println("文件路径错误");
		}
		
	}
	
	static void test() throws ParseException,FileNotFoundException //声明抛出
		{
			//如果不catch住CheckedException，那么必须在方法上声明抛出
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date date = sdf.parse("2008-2-02");
			System.out.print(date);
			FileInputStream fis = new FileInputStream("w:\\1.txt");
		}
}


	
