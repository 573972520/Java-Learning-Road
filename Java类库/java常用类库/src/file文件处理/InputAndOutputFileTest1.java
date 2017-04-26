package file文件处理;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class InputAndOutputFileTest1
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		long startMS = System.currentTimeMillis();// 起始的毫秒数
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try
		{
			fis = new FileInputStream("d:\\1.pdf");// 30.2M
			fos = new FileOutputStream("d:\\2.pdf");
			// byte[] bytes = new byte[10];//缓冲区，用来暂存数据 用时：72732ms
			byte[] bytes = new byte[1024 * 1024];// 编译器会优化1024*1024 用时：146ms
			int len;
			while ((len = fis.read(bytes)) > 0) // 常见的写法
			{
				// fos.write(bytes);//len = 30, 应该只写入bytes前30个有用的数据
				fos.write(bytes, 0, len);// 把bytes的前len个写入
			}
			long endMS = System.currentTimeMillis();// 拷贝结束的毫秒数
			System.out.println("拷贝完成，用时（毫秒）" + (endMS - startMS)); // 考虑执行顺序，所以要加括号
		} catch (FileNotFoundException e)
		{
			System.out.print("文件未找到" + e.getMessage());
		} catch (IOException e)
		{
			System.out.print("拷贝文件错误" + e.getMessage());
		} finally
		{
			IOUtils.closeQuietly(fis); // 封装安静关闭方法
			IOUtils.closeQuietly(fos);
			/*
			 * if (fis != null) { try { fis.close(); } catch (IOException e) {
			 * // do nothing(在这里要安静的关闭，然后不是安静的关闭，抛出异常，那么下面的关闭就不能执行了) } } if (fos
			 * != null) { try { fos.close(); } catch (IOException e) { // do
			 * nothing } }
			 */
		}

	}

}
