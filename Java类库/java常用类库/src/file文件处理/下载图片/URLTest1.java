package file文件处理.下载图片;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;

import file文件处理.IOUtils;

public class URLTest1
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		InputStream inStream = null;
		OutputStream outStream = null;
		try
		{
			URL url = new URL("https://ss0.bdstatic.com/5aV1bjqh_Q23odCf/static/superman/img/logo/bd_logo1_31bdc765.png");
			inStream = url.openStream();
			outStream = new FileOutputStream("d:\\1.png");
			CopyMethod.copy(inStream, outStream);
			
			System.out.println("下载成功");
		} catch (MalformedURLException e)
		{
			// TODO Auto-generated catch block
			System.out.println("网址格式不正确"+e.getMessage());
		}
		catch(IOException e)
		{
			System.out.println("下载失败"+e.getMessage());
		}
		finally 
		{
			IOUtils.closeQuietly(inStream);
			IOUtils.closeQuietly(outStream);
		}
		
	}

}
