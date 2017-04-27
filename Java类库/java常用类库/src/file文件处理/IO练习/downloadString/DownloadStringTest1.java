package file文件处理.IO练习.downloadString;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import file文件处理.IOUtils;


public class DownloadStringTest1
{

	public static String downloadString(String url,String charsetName)
	{
		if(url == null) //检查参数合法性
		{
			throw new IllegalArgumentException("url不能为空");
		}
		if(charsetName == null)
		{
			downloadString(url,"UTF-8"); //如果charsetName为空，则使用默认的UTF-8编码
		}
		InputStream inStream = null; 
		Reader reader = null;        
		BufferedReader buffReader = null;
		String s ="";
		try
		{
			URL urlAddress = new URL(url);
			inStream = urlAddress.openStream();
			reader = new InputStreamReader(inStream,charsetName);//可在这里添加编码格式
			buffReader = new BufferedReader(reader);
			String line;
			while((line = buffReader.readLine()) != null)
			{
				s = line; //将读取到的文本赋给字符串s
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
		return s;
	}
	
	public static String downloadString(String url)
	{
		String s = downloadString(url,"UTF-8");
		return s;
	}
	public static void main(String[] args)
	{
		String urlText = downloadString("http://cn.bing.com/");
		System.out.println(urlText);
		//输出结果为  </script> <a href=//www.baidu.com/more/ name=tj_briicon class=bri style="display: block;">更多产品</a> </div> </div> </div> <div id=ftCon> <div id=ftConw> <p id=lh> <a href=http://home.baidu.com>关于百度</a> <a href=http://ir.baidu.com>About Baidu</a>
				//</p> <p id=cp>&copy;2017&nbsp;Baidu&nbsp;<a href=http://www.baidu.com/duty/>使用百度前必读</a>&nbsp; <a href=http://jianyi.baidu.com/ class=cp-feedback>意见反馈</a>&nbsp;京ICP证030173号&nbsp; <img src=//www.baidu.com/img/gs.gif> </p> </div> </div> </div> </body> </html>
	}
	

}
