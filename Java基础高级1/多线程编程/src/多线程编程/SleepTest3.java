package 多线程编程;

public class SleepTest3
{

	public static void main(String[] args)
	{
		System.out.println("倒计时开始");
		for (int i = 10; i > 0; i--)
		{
			try
			{
				Thread.sleep(1000);
				System.out.println(i);
			} catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
		System.out.println("泽明炸啦！！！");
	}

}
