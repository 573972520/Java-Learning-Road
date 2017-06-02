package Socket;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class MyHttpServer1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			ServerSocket  serverSocket = new ServerSocket(8080);
			while(true)
			{
				Socket clientSocket = serverSocket.accept();
				OutputStream os = clientSocket.getOutputStream();
				OutputStreamWriter osw = new OutputStreamWriter(os);
				osw.write("HTTP/1.1 200 OK\n");
				osw.write("\n");
				osw.write("<html><head></head><body>\n");
				osw.write("<a href='http://www.rupeng.com'>rupeng</a>\n");
				osw.write("</body></html>\n");
				osw.flush();
				osw.close();
				os.close();
				clientSocket.close();
			}
		}catch(IOException ioex)
		{
			ioex.printStackTrace();
		}
	}

}
