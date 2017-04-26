package file文件处理.下载图片;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import file文件处理.IOUtils;

public class StreamTest
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
			CopyMethod.copy(fis,fos);
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
