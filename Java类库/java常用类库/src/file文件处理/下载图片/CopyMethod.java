package file文件处理.下载图片;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class CopyMethod
{
	public static void copy(InputStream inStream, OutputStream outStream, int bufferSize) throws IOException //buffer：缓冲区 size：大小
	{
		if(inStream == null)
		{
			throw new IllegalArgumentException("instream不能为空");
		}
		if(outStream == null)
		{
			throw new IllegalArgumentException("outstream不能为空");
		}
		if(bufferSize <= 0)
		{
			throw new IllegalArgumentException("bufferSize必须大于0");
		}
		byte[] buffer = new byte[bufferSize];
		int len;
		//在这里不用catch异常，因为你不知道怎么处理，让调用者处理
		while((len = inStream.read(buffer)) > 0)
		{
			outStream.write(buffer,0,len);
		}
	}
	
	//重载copy方法，给它一个bufferSize的默认值为1M
	public static void copy(InputStream inStream, OutputStream outStream) throws IOException //buffer：缓冲区 size：大小
	{
		copy(inStream,outStream,1024*1024);
	}
}
