package 多线程编程;

public class RunnableTest2
{
	public static void main(String[] args)
	{
		Thread thread = new Thread(new Runnable()
		{
			@Override
			public void run()
			{
				// TODO Auto-generated method stub
				System.out.println("Runnabel接口的方式实现多线程");
			}
		});

		thread.start();
	}
}
