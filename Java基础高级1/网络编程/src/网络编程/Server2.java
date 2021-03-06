package 网络编程;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server2
{

	/**
	 * 把从客户端读取到的一行数据的字符进行反转，然后发送给客户端
	 * 当读取到over时，连接断开
	 * @param args
	 */
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub 
		try
		{
			ServerSocket server = new ServerSocket(10013);
			while (true) //可以一直接受客户端的请求
			{
				Socket socket = server.accept();
				MyThread2 mythread = new MyThread2(socket); //创建一个线程
				mythread.start();
			}
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

class MyThread2 extends Thread
{
	private Socket socket;

	public MyThread2(Socket socket) //构造函数
	{
		this.socket = socket;
	}

	@Override
	public void run()
	{
		try
		{
			BufferedReader buffReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			BufferedWriter buffWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			String line = null;
			while ((line = buffReader.readLine()) != null)
			{
				if ("over".equalsIgnoreCase(line)) //如果line的值是over(不管大小写)
				{
					break; //退出while循环
				}
				//反转字符操作
				char[] cha = line.toCharArray(); //将字符串转换成字节数组
				for (int i = 0; i < cha.length / 2; i++) //长度为一半
				{
					char temp = cha[i]; //中间变量
					cha[i] = cha[cha.length - 1 - i];
					cha[cha.length - 1 - i] = temp;
				}
				//下面的代码一般都是连在一起的
				buffWriter.write(cha); //缓存字节数据，但没有写入
				buffWriter.newLine(); //写入换行
				buffWriter.flush(); //写入数据
			}
			buffReader.read();//读取数据
		} catch (IOException e1)
		{
			e1.printStackTrace();
		}
		finally
		{
			try
			{
				socket.close();
			} catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}