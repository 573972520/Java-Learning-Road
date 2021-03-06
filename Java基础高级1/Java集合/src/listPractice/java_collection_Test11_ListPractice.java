package listPractice;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class java_collection_Test11_ListPractice
{
	public static void main(String[] args)
	{
		try
		{
			List<Person> persons = readAllPersons("d:\\8.txt");
			System.out.println(persons.size());
			for (Person p : persons)
			{
				System.out.println(p);//因为我们已经重写了toString方法所以这行代码相对于System.out.println(p.toString());
				//System.out.println(p.toString());
			}
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	static List<Person> readAllPersons(String file) throws IOException
	{

		List<Person> list = new ArrayList<Person>();
		FileInputStream fis = null;
		InputStreamReader reader = null;
		BufferedReader buffReader = null;
		try
		{
			fis = new FileInputStream(file);
			reader = new InputStreamReader(fis);
			buffReader = new BufferedReader(reader);
			String line = null;
			while ((line = buffReader.readLine()) != null)
			{
				String[] strs = line.split(" ");
				/*	由于line已经读取到了8.txt文本中的内容，并且一行内容是以一个空格来将数据分隔开的，
					所以可以使用split(String regex)来将数据进行分隔
					
					String[] split(String regex)：切割功能的一个例子
				    String line="姚明 34 18247839384";
					String[] strs=str.split(" ");
					for (int i = 0; i < strs.length; i++)
					System.out.println(strs[i]);
					将输出：
					姚明 ---(对应的就是strs[0])
					34---(对应的就是strs[1])
					18247839384---(对应的就是strs[2])
				 */
				String name = strs[0];
				int age = Integer.parseInt(strs[1]);
				String phoneNum = strs[2];
				Person p = new Person();
				p.setAge(age);
				p.setName(name);
				p.setPhoneNum(phoneNum);
				list.add(p);//将p这个对象放入集合中
			}
		} finally
		{
			closeQuietly(buffReader);
			closeQuietly(reader);
			closeQuietly(fis);
		}
		return list;
	}

	static void closeQuietly(Closeable c)
	{
		if (c != null)
		{
			try
			{
				c.close();
			} catch (IOException e)
			{
				//do nothing
			}
		}
	}

}
