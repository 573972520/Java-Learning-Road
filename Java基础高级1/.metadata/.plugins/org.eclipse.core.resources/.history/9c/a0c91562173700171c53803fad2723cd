package 网络编程;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server1
{

	public static void main(String[] args) throws IOException
	{
		ServerSocket server = new ServerSocket(10002); //设置服务器端的端口号为10002
		Socket socket = server.accept(); //设置服务器端开始接受请求
		InputStream input = socket.getInputStream();
		OutputStream output = socket.getOutputStream();
		byte[] info = "hello".getBytes();//将hello转成字节流传给字节数组info
		output.write(info); //写入字节流的数据到output中
		server.close(); //记得关闭，Socket中包含I/O流的关闭
	}

}
