package Socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class MyHttpBrowser1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
		{
			Socket socket = new Socket("www.rupeng.com",80);
//			Socket socket = new Socket("www.baidu.com",80);
			//浏览器向服务器发送请求
			OutputStream os = socket.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(os);
			osw.append("GET /index.shtml HTTP/1.1\n");
			osw .append("HOST: www.rupeng.com:80\n");
//			osw.append("GET /index.html HTTP/1.1\n");
//			osw .append("HOST: www.baidu.com:80\n");
			osw.append("\n");
			osw.flush();//强制OutputStreamWriter把缓冲的数据写入OutputStream
			//接受服务器返回的请求
			InputStream inStream = socket.getInputStream();
			InputStreamReader inReader = new InputStreamReader(inStream,"UTF-8");
			BufferedReader buffReader = new BufferedReader(inReader);
			String line;
			while ((line = buffReader.readLine()) != null) {
				System.out.println(line);
			}
			buffReader.close();
			inReader.close();
			inStream.close();
			osw.close();
			os.close();
			socket.close();
		}
		catch (IOException ioex)
		{
			ioex.printStackTrace();
		}
	}
}
