import java.util.LinkedList;
import java.util.Queue;

public class java_collection_Test8_队列QueueTest1
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Queue<String> q1 = new LinkedList<String>();
		q1.offer("aa");
		q1.offer("bbb");
		q1.offer("fas");
		q1.offer("ccc");
		while (!q1.isEmpty())
		{
			String s = q1.poll();
			System.out.println(s);
		}
	}

}
