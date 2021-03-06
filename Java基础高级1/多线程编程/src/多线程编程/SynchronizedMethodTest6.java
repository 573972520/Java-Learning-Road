package 多线程编程;

import java.util.ArrayList;
import java.util.List;

public class SynchronizedMethodTest6
{

	public static void main(String[] args)
	{
		Data data = new Data();
		Thread thread1 = new Thread(new Runnable()
		{
			
			@Override
			public void run()
			{
				data.bianliList();
			}
		});
		Thread thread2 = new Thread(new Runnable()
		{
			
			@Override
			public void run()
			{
				data.clearList();
			}
		});
		thread1.start();
		thread2.start();
	}

}

class Data
{
	private List<Integer> list;

	public Data()
	{
		list = new ArrayList<Integer>();
		for (int i = 0; i < 100000; i++)
		{
			list.add(i);
		}
	}

	public synchronized void bianliList()
	{
		for (int i = 0; i < list.size(); i++)
		{
			System.out.println(list.get(i));
		}
	}
	
	public synchronized void clearList()
	{
		list.clear();
	}

}