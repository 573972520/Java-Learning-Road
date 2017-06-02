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
				String line = buffReader.readLine();//��ȡHTTP�����һ��
				
				if(line == null) //ż��lineҲ��Ϊnull
				{
					buffReader.close();
					inReader.close();
					inStream.close();
					continue;
				}
				
				System.out.println("�ͻ���������"+line);
				String fileName = line.split(" ")[1];//��GET /2.html HTTP/1.1��ȡ��"2.html"�ļ���
				System.out.println("��ʼ��ȡ"+fileName);
				
				OutputStream os = clientSocket.getOutputStream();
				OutputStreamWriter osw = new OutputStreamWriter(os);
				osw.write("HTTP/1.1 200 OK\r\n");
				osw.write("\r\n");
				osw.flush();//!!!
				
				//ƴ�ļ���ȫ·��
				File file = new File("D:\\Code", fileName);
				//������ļ������Ҵ��ڣ��Ͱ��ļ����ݷ���
				if(file.exists() && file.isFile())
				{
					//д�����壬Ҳ�����ļ�����������
					FileInputStream fis = new FileInputStream(new File("D:\\Code", fileName));
					copy(fis,os);
					fis.close();
				}
				else
				{
					osw.append("û���ҵ�������");
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
	 * ������
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
