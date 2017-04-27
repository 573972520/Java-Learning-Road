package file文件处理;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class ReaderWriterTest1
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		
		/*
		InputStream inStream = null;
		try
		{
			inStream = new FileInputStream("d:\\1.txt");
			byte[] buffer = new byte[30];
			inStream.read(buffer);
			String s = new String(buffer);
			System.out.println(s);
		}
		catch(FileNotFoundException e)
		{
			System.out.println("文件未找到"+e.getMessage());
		}
		catch(IOException e)
		{
			System.out.println("文件写入错误"+e.getMessage());
		}
		finally
		{
			if(inStream != null)
			{
				//从难处学，从易处用
				IOUtils.closeQuietly(inStream);
			}
		}
		*/
		
		InputStream inStream = null;
		Reader reader = null;
		try
		{
			inStream = new FileInputStream("d:\\1.txt");
			reader = new InputStreamReader(inStream);
			int i;
			//while((i = reader.read()) != -1)
			while((i = reader.read()) >= 0)
			{
				char ch = (char)i; //long, int, short, byte, chat 属于数值类型，他们之间能进行显式的转换
				System.out.print(ch);
			}
		}
		catch(IOException e)
		{
			System.out.println("文件读出错误"+e.getMessage());
		}
		finally
		{
			IOUtils.closeQuietly(reader);
			IOUtils.closeQuietly(inStream);
		}
		
		/*
		//InputStreamReader内部的伪代码是依靠InputStream进行读取的
		
		class   InputStreamReader 
		{ 
		    private InputStream stream; 
		    public int read() 
		    { 
		        byte b = stream.read(); 
		        if(b是汉字的一半) 
		        { 
		            byte b1 = stream.read(); 
		            byte[] bytes = new {b,b1}; 
		            char ch = Encoding..... 
		                    return ch; 
		            } 
		        } 
		    }  
		}

		*/
	}

}
