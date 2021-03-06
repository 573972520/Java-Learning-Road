package 多线程编程;

public class InterruptTest10
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Thread thread1 = new Thread(new Runnable()
		{

			@Override
			public void run()
			{
				// TODO Auto-generated method stub
				System.out.println("线程1即将进入阻塞状态");
				try
				{
					Thread.sleep(10000);
				} catch (InterruptedException e)
				{
					System.out.println("线程1被打断，开始执行catch里面的代码");
					e.printStackTrace();
				}
			}
		});

		Thread thread2 = new Thread(new Runnable()
		{

			@Override
			public void run()
			{
				try
				{
					Thread.sleep(10000);
				} catch (InterruptedException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				thread1.interrupt();
			}
		});

		thread1.start();
		thread2.start();
	}

}
