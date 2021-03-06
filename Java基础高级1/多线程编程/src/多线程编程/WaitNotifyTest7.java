package 多线程编程;

public class WaitNotifyTest7
{

	public static void main(String[] args)
	{
		Object lockObject = new Object();
		Thread thread1 = new Thread(new Runnable()
		{

			@Override
			public void run()
			{
				synchronized (lockObject)
				{

					try
					{
						System.out.println("线程1即将开始在lockObject上等待");
						lockObject.wait();
						System.out.println("线程1收到了通知并且获得了锁，然后开始继续执行");
					} catch (InterruptedException e)
					{
						e.printStackTrace();
					}

				}
			}
		});
		
		Thread thread2 = new Thread(new Runnable()
		{
			
			@Override
			public void run()
			{
				synchronized (lockObject)
				{
					System.out.println("线程2即将随机的通知一个在lockObject上等待的线程");
					lockObject.notify();
				}

			}
		});

		thread1.start();
		thread2.start();

	}

}
