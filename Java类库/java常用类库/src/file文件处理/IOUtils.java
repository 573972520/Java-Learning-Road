package file文件处理;


import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;

//封装安静关闭方法
public class IOUtils
{
/*
	public static void closeQuietly(InputStream inStream)
	{
		if(inStream != null)
		{
			try
			{
				inStream.close();
			} 
			catch (IOException e)
			{
·				//do nothing
			}
		}
	}

	
	public static void closeQuietly(OutputStream outStream)
	{
		if(outStream != null)
		{
			try
			{
				outStream.close();
			} 
			catch (IOException e)
			{
				//do nothing
			}
		}
	}
	
	
	public static void closeQuietly(Reader reader)
	{
		if(reader != null)
		{
			try
			{
				reader.close();
			} 
			catch (IOException e)
			{
				//do nothing
			}
		}
	}
	
	
	public static void closeQuietly(Writer Writer)
	{
		if(Writer != null)
		{
			try
			{
				Writer.close();
			} 
			catch (IOException e)
			{
				//do nothing
			}
		}
	}
	*/
	
	//JDK1.5之后，就不需要一个个写封装了，只需要使用Closeable
	public static void closeQuietly(Closeable closeable)
	{
		if(closeable != null)
		{
			try
			{
				closeable.close();
			} 
			catch (IOException e)
			{
				//do nothing
			}
		}
	}
	
}
