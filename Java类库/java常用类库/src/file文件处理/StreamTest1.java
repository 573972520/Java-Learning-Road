package file�ļ�����;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class StreamTest1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//FileOutputStream fos = new FileOutputStream("");
		/*
		String s = "a��";
		System.out.print(s.length());
		byte[] bytes1 = s.getBytes();
		System.out.print(bytes1.length);
		*/
		
		try 
		{
			OutputStream fos = new FileOutputStream("d:\\1.txt");//��̬   �������;�������ɸ�������ͣ����ܹ��������������£�
			byte[] bytes = "abc��ð�".getBytes();
			//'a'��ĸ,'1'ռһ���ֽ�byte
			//'��'��ռ�����ֽ�
			fos.write(bytes);
			fos.close();
			
		} 
		catch (FileNotFoundException e) 
		{
			System.out.print("�ļ��Ҳ���");
		}
		catch (IOException e)	//��IOException�ŵ�FileNotFoundException���棬FileNotFoundException��û�������ˣ���ΪFileNotFoundException��IOException������
		{
			System.out.print("д�����");
		}
		
	}

}
