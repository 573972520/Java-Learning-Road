package file文件处理.IO练习.ReadTxtFile;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import file文件处理.IOUtils;

public class ReadTxtFileTest1
{

	/**
	 * 读取一个本地文本文件file全部内容，把全部内容以字符串返回
	 * @param file 文件名称
	 * @param charsetName 编码格式
	 * @return 文件内容
	 */
	public static String readTxtFile(String file,String charsetName)
	{
		if(file == null) //检查参数合法性
		{
			throw new IllegalArgumentException("文件名不能为空");
		}
		if(charsetName == null)
		{
			readTxtFile(file,"UTF-8"); //如果charsetName为空，则使用默认的UTF-8编码
		}
		InputStream inStream = null; 
		Reader reader = null;        
		BufferedReader buffReader = null;
		String s ="";
		try
		{
			
			inStream = new FileInputStream(file);
			reader = new InputStreamReader(inStream,charsetName);//可在这里添加编码格式
			buffReader = new BufferedReader(reader);
			String line;
			while((line = buffReader.readLine()) != null)
			{
				s += line; //不能使用s = line; 这样会导致获取的数据不完整，只会获取最后一行数据，要使用s += line;把数据拼接起来
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
	
	public static String readTxtFile(String file) //重载
	{
		String s = readTxtFile(file,"UTF-8");
		return s;
	}
	public static void main(String[] args)
	{
		String txt = readTxtFile("d:\\1.txt");
		System.out.println(txt);
	}

}
