package 网络编程;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Receive1
{

	public static void main(String[] args) throws IOException
	{
		// TODO Auto-generated method stub
		DatagramSocket socket = new DatagramSocket(10028);//与发送端的包（packet）的端口相对应
		//用来存储接收到的数据的缓冲区
		byte[] receive = new byte[1024];
		DatagramPacket packet = new DatagramPacket(receive, receive.length); //使用数据包的形式接收数据
		socket.receive(packet); //接收发送过来的数据，并把数据存放到数据包的缓冲区中
		int len = packet.getLength();
		System.out.println(new String(receive, 0, len));
		socket.close();
	}

}
