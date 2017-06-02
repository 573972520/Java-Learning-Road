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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.sound.midi.Patch;

public class MyHttpServer3 {

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
				
				//先粗暴的认为只要请求地址中有？就认为是获取动态内容
				if(fileName.contains("?"))
				{
					if(fileName.startsWith("/add"))
					{
						//
						//GET /add?i=5&j=8 HTTP/1.1
						Pattern pattern = Pattern.compile(
								"i=(\\d+)&j=(\\d+)");
						Matcher matcher = pattern.matcher(line);
						if(matcher.find())
						{
							int i = Integer.parseInt(matcher.group(1));
							int j = Integer.parseInt(matcher.group(2));
							System.out.println("i="+i+",j="+j);
							int r = i+j;
							osw.write("<html><head></head><body>");
							osw.write(i+"+"+j+"="+r);
							osw.write("</body>");
							
						}
					}
					else if(fileName.startsWith("/login?"))
					{
						//正则表达式的非贪婪模式
						Pattern pattern = Pattern.compile("username=(.+?)&password=(.+?) HTTP/1.1");
						Matcher matcher = pattern.matcher(line); //  GET /login?username=admin&password=123 HTTP/1.1
						if(matcher.find())
						{
							String username = matcher.group(1);
							String password = matcher.group(2);
							osw.write("<html><head></head><body>");
							if(username.equals("admin") && password.equals("123")){
								osw.write("登录成功");
							}
							else 
							{
								osw.write("登录失败");
							}
							osw.write("</body>");
						}
					}
					
					else if(fileName.startsWith("/login?")
							{
						
							}
							
					
					
				}
				else
				{
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
