package 多线程编程;

import java.util.LinkedList;
import java.util.List;

public class ProducerConsumerTest8
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		List<Integer> buffer = new LinkedList<Integer>(); //需要频繁的添加删除元素所以使用LinkedList
		int maxSize = 0;
		Producer producer = new Producer(buffer, maxSize);
		Consumer consumer = new Consumer(buffer);
		producer.start();
		consumer.start();
	}
}

class Producer extends Thread
{
	private List<Integer> buffer;
	private int maxSize;

	public Producer(List<Integer> buffer, int maxSize) //构造函数
	{
		this.buffer = buffer;
		this.maxSize = maxSize;
	}

	int id = 0;
	@Override
	public void run()
	{
		while (true)
		{
			synchronized (buffer)
			{
				if (buffer.size() < 10)
				{
					id++; //表示生产了一个产品
					buffer.add(id);//表示把产品放入空盘子里面
					System.out.println("生产者生产了产品" + id + ",并将通知消费者可以消费了");
					buffer.notify();//通知消费者线程，可以消费了
				}
				else
				{
					System.out.println("已经没有空盘子了，生产者开始等待");
					try
					{
						buffer.wait();
					} catch (InterruptedException e)
					{
						e.printStackTrace();
					}
				}

			}
		}

	}

}

class Consumer extends Thread
{
	private List<Integer> buffer;

	public Consumer(List<Integer> buffer)
	{
		this.buffer = buffer;
	}
	@Override
	public void run()
	{
		while (true)
		{
			synchronized (buffer)
			{
				if (buffer.size() > 0)
				{
					Integer id = buffer.remove(0);//表示消费了一个产品
					System.out.println("消费者消费了产品" + id + ",并将通知生产者可以生产了");
					buffer.notify();//通知生产者，可以生产了
				} else
				{
					try
					{
						System.out.println("全部都是空盘子，消费者开始等待");
						buffer.wait();
					} catch (InterruptedException e)
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	}
}
