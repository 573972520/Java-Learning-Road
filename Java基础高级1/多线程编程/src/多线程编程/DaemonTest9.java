package 多线程编程;

public class DaemonTest9
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Thread thread1 = new Thread(new Runnable()
		{
			
			@Override
			public void run()
			{
				System.out.println("守护线程主要是提供某种服务");
				try
				{
					Thread.sleep(1000);
				} catch (InterruptedException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		thread1.setDaemon(true);
		thread1.start();

		Thread thread2 = new Thread(new Runnable()
		{

			@Override
			public void run()
			{
				try
				{
					Thread.sleep(5000);
				} catch (InterruptedException e)
				{
					e.printStackTrace();
				}
			}
		});
		thread2.start();
	}

}
