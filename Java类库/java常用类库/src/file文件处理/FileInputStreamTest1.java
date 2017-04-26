package file文件处理;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class FileInputStreamTest1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InputStream fis = null;
		try 
		{
			fis = new FileInputStream("d:\\a.txt");
			/*
			byte[] bytes = new byte[50];
			int b = fis.read(bytes); //read返回值为真正读了多少
			System.out.println(b);
			System.out.println(new String(bytes));
			*/
			byte[] bytes = new byte[50];
			while(fis.read(bytes) > 0)//执行完了，下次执行的时候，就从上次读完的位置开始
			{
				String s = new String(bytes);
				System.out.println(s);
			}
		} 
		catch (FileNotFoundException e) 
		{
			System.out.println("文件不存在");
		}
		catch (IOException e)
		{
			System.out.println("读入错误");
		}
		finally
		{
			if(fis != null)
			{
				try
				{
					fis.close();
				}
				catch(IOException e)
				{
					
				}
			}
		}
	}

}
