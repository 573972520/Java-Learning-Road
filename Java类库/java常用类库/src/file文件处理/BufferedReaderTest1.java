package file文件处理;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;



public class BufferedReaderTest1
{

	public static void main(String[] args)
	{
		
		// TODO Auto-generated method stub
		InputStream inStream = null; 
		Reader reader = null;             //使用父类类型的变量
		//InputStreamReader reader = null;//使用父类类型的变量
		BufferedReader buffReader = null;
		try
		{
			inStream = new FileInputStream("d:\\5.txt");
			reader = new InputStreamReader(inStream);
			buffReader = new BufferedReader(reader);
			String line;
			while((line = buffReader.readLine()) != null)
			{
				System.out.println(line+"!");
			}
		} 
		catch (FileNotFoundException e)
		{
			System.out.println("文件没有找到");
		} 
		catch (IOException e)
		{
			System.out.println("读取错误");
		}
		finally
		{
			IOUtils.closeQuietly(buffReader);
			IOUtils.closeQuietly(reader);
			IOUtils.closeQuietly(inStream);
		}
		
	}

}
