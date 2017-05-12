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
	public static void main(String args)
	{
		// TODO Auto-generated method stub 
		try
		{
			ServerSocket server = new ServerSocket(11011);
			while (true)
			{
				Socket socket = server.accept();
				MyThread2 mythread = new MyThread2(socket);
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

	public MyThread2(Socket socket)
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
				if ("over".equalsIgnoreCase(line))
				{
					break;
				}
				//反转字符操作
					char[] cha = line.toCharArray();
					for(int i = 0; i < cha.length / 2; i++)
					{
						char temp = cha[i];
						cha[i]= cha[cha.length-1-i];
						cha[cha.length - 1 - i] = temp;
					}
					buffWriter.write(cha);
					buffWriter.newLine();
					buffWriter.flush();
			}
			buffReader.read();
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