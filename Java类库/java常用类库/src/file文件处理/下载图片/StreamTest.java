package file�ļ�����.����ͼƬ;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import file�ļ�����.IOUtils;

public class StreamTest
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		long startMS = System.currentTimeMillis();// ��ʼ�ĺ�����
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try
		{
			fis = new FileInputStream("d:\\1.pdf");// 30.2M
			fos = new FileOutputStream("d:\\2.pdf");
			CopyMethod.copy(fis,fos);
			long endMS = System.currentTimeMillis();// ���������ĺ�����
			System.out.println("������ɣ���ʱ�����룩" + (endMS - startMS)); // ����ִ��˳������Ҫ������
		} catch (FileNotFoundException e)
		{
			System.out.print("�ļ�δ�ҵ�" + e.getMessage());
		} catch (IOException e)
		{
			System.out.print("�����ļ�����" + e.getMessage());
		} finally
		{
			IOUtils.closeQuietly(fis); // ��װ�����رշ���
			IOUtils.closeQuietly(fos);
			/*
			 * if (fis != null) { try { fis.close(); } catch (IOException e) {
			 * // do nothing(������Ҫ�����Ĺرգ�Ȼ���ǰ����Ĺرգ��׳��쳣����ô����ĹرվͲ���ִ����) } } if (fos
			 * != null) { try { fos.close(); } catch (IOException e) { // do
			 * nothing } }
			 */
		}
	}

}
