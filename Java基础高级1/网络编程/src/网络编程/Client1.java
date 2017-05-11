package 网络编程;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client1
{

	public static void main(String[] args) throws IOException
	{
		// TODO Auto-generated method stub
		Socket socket = new Socket("localhost", 10002); //设置客户端需要连接的服务器IP地址和端口
		byte[] buff = new byte[1024];//读取缓存区
		InputStream input = socket.getInputStream();
		OutputStream output = socket.getOutputStream();
		int len = input.read(buff); //input.read(buff)读取数据       
		//int len = input.read(buff) ---> len返回读取到数据的个数
		System.out.println(new String(buff, 0, len)); //后面的两个参数是获取字节流的长度范围，如果没有那么获取的是长度为1024的字节流
		socket.close();
	}

}
