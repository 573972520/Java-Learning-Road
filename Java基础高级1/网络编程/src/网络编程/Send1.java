package 网络编程;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Send1
{

	public static void main(String[] args) throws IOException
	{
		// TODO Auto-generated method stub
		//如果只发送数据的话可以不指定具体端口号
		DatagramSocket socket = new DatagramSocket(10123);
		byte[] buff = "hellomotherfucker".getBytes();//要发送的数据
		int len = buff.length;
		DatagramPacket packet = new DatagramPacket(buff, len, InetAddress.getLocalHost(), 10028);//创建数据包，并指定发送目标的IP地址和端口号
		//发送数据包
		socket.send(packet);
		socket.close();
	}

}
