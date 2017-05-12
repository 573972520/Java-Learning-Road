package 网络编程;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client2
{

	public static void main(String[] args)
	{
		Socket socket = null;
		Scanner scanner = null;
		try
		{
			socket = new Socket("localhost", 10013);
			BufferedReader buffReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			BufferedWriter buffWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			scanner = new Scanner(System.in);//获取console输入的数据
			String line = null;
			while ((line = scanner.nextLine()) != null)
			{
				buffWriter.write(line); //写入从console获取的数据
				buffWriter.newLine();
				buffWriter.flush();

				line = buffReader.readLine(); //不太明白这行代码的意义
				if (line == null)
				{
					break;
				}
				System.out.println(line);
			}
		} catch (UnknownHostException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			if (scanner != null)
			{
				scanner.close();
			}
				try
				{
				if (socket != null)
				{
					socket.close();
				}
				} catch (IOException e)
				{
					e.printStackTrace();
				}

		}

	}

}


