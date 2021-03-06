package 多线程编程;

import java.util.ArrayList;
import java.util.List;

public class SynchronizedBlockTest5
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		List<Integer> list = new ArrayList<Integer>();
		
		for (int i = 0; i < 100000; i++)
		{
			list.add(i);
		}
		
		Thread thread1 = new Thread(new Runnable()
		{
			
			@Override
			public void run()
			{
				synchronized (list)
				{
					for (int i = 0; i < list.size(); i++)
				{
					System.out.println(list.get(i));
				}
			}
			}
		});
		
		Thread thread2 = new Thread(new Runnable()
		{
			
			@Override
			public void run()
			{
				synchronized (list)
				{
					list.clear();
				}
			}
		});
		thread1.start();
		thread2.start();
	}

}
