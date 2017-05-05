package hashMapPractice;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class JianToFan
{
	private HashMap<Character, Character> data = new HashMap<Character, Character>();

	public JianToFan() throws IOException
	{
		FileInputStream fis = null;
		InputStreamReader reader = null;
		BufferedReader buffReader = null;
		try
		{
			fis = new FileInputStream("d:\\10.txt");
			reader = new InputStreamReader(fis, "UTF-8");
			buffReader = new BufferedReader(reader);
			String line;
			while ((line = buffReader.readLine()) != null)
			{
				char chJian = line.charAt(0);
				char chFan = line.charAt(2);
				data.put(chJian, chFan);
			}
		} finally
		{
			closeQuietly(buffReader);
			closeQuietly(reader);
			closeQuietly(fis);
		}
	}

	public void closeQuietly(Closeable e)
	{
		if (e != null)
		{
			try
			{
				e.close();
			} catch (IOException ex)
			{
				//do nothing
			}
		}
	}

	public String convert(String s)
	{
		StringBuilder sb = new StringBuilder();//临时的生产繁体内容的StringBuilder
		for (int i = 0; i < s.length(); i++)
		{
			char jian = s.charAt(i);
			if (data.containsKey(jian))
			{
				char fan = data.get(jian);//如果遍历到的字符在data中有，则把繁体char查出来
				sb.append(fan);
			}
			else
			{
				sb.append(jian);//如果在data中没有这个字符，则不做转换
			}
		}
		return sb.toString();
	}

	public static void main(String[] args)
	{
		try
		{
			JianToFan f = new JianToFan();
			String s = "万19975与"; //第一个字不能转成繁体，因为UTF-8有BOM头的问题
			System.out.println(f.convert(s));
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
