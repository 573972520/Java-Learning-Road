package Socket;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class MyHttpServer2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			ServerSocket  serverSocket = new ServerSocket(8050);
			while(true)
			{
				Socket clientSocket = serverSocket.accept();
				InputStream inStream = clientSocket.getInputStream();
				InputStreamReader inReader = new InputStreamReader(inStream);
				BufferedReader buffReader = new BufferedReader(inReader);
				String line = buffReader.readLine();//读取HTTP请求第一行
				
				if(line == null) //偶尔line也会为null
				{
					buffReader.close();
					inReader.close();
					inStream.close();
					continue;
				}
				
				System.out.println("客户端请求是"+line);
				String fileName = line.split(" ")[1];//从GET /2.html HTTP/1.1中取出"2.html"文件名
				System.out.println("开始读取"+fileName);
				
				OutputStream os = clientSocket.getOutputStream();
				OutputStreamWriter osw = new OutputStreamWriter(os);
				osw.write("HTTP/1.1 200 OK\r\n");
				osw.write("\r\n");
				osw.flush();//!!!
				
				//拼文件的全路径
				File file = new File("D:\\Code", fileName);
				//如果是文件，并且存在，就把文件内容返回
				if(file.exists() && file.isFile())
				{
					//写报文体，也就是文件的正文内容
					FileInputStream fis = new FileInputStream(new File("D:\\Code", fileName));
					copy(fis,os);
					fis.close();
				}
				else
				{
					osw.append("没有找到！！！");
				}
				osw.close();
				os.close();
				clientSocket.close();
			}
		}catch(IOException ioex)
		{
			ioex.printStackTrace();
		}
	}
	/**
	 * 流拷贝
	 * @param inStream
	 * @param outStream
	 * @throws IOException
	 */
	static void copy (InputStream inStream,OutputStream outStream) throws IOException
			{
				byte[] bytes = new byte[1024];
				int len;
				while((len = inStream.read(bytes)) > 0)
				{
					outStream.write(bytes,0,len);
				}
			}
}
