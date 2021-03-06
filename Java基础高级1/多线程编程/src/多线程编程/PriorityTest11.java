package 多线程编程;

public class PriorityTest11
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		MyThread2 thread0 = new MyThread2();
		MyThread2 thread1 = new MyThread2();
		MyThread2 thread2 = new MyThread2();
		MyThread2 thread3 = new MyThread2();
		MyThread2 thread4 = new MyThread2();

		thread4.setPriority(Thread.MAX_PRIORITY);

		thread0.start();
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
	}

}

class MyThread2 extends Thread
{
	@Override
	public void run()
	{
		for (int i = 0; i < 2000; i++)
		{
			try
			{
				Thread.sleep(1);
			} catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(Thread.currentThread().getName() + "在" + System.currentTimeMillis() + "执行完了");
	}
}
