package 多线程编程;

public class ThreadTest1
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		MyThread myThread = new MyThread();
		myThread.start();//把myThread加入到就绪队列里面
	}

}

class MyThread extends Thread
{
	@Override
	public void run()
	{
		System.out.println("OK");
	}

}