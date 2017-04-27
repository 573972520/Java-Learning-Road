package src;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
import java.net.URL;

public class AccessResource
{
	
		//��η�����Ŀsrc�µ���Դ�ļ���
		//ʵ��ִ��ʱ��������η���binĿ¼�µ���Դ�ļ�
		//bin---java������صĸ�·��
		
		
		//��λ����Դ��·����
		//java�ṩ�����ַ�ʽ����������Ŀ¼�µ���Դ·��
	
		//��һ��
		/*
		public static void main(String[] args) throws Exception
		{
			//ʹ��class�����getResource�����������Դ��URLʱ�����ݵĲ���Ҫ��/��ͷ�������б�߾ʹ�����Ŀ��binĿ¼��Ҳ��������صĸ�Ŀ¼
			
			//�����Դ�ڰ����棬ָ����Դ���Ƶ�ʱ����Ҫָ��������Ӧ��Ŀ¼
			//URL resourceURL = AccessResource.class.getResource("/a.txt");//��Ҫָ����Դ�����ƣ���Դ����AccessResource.java�ļ�ͬ����
			URL resourceURL = AccessResource.class.getResource("/src/a.txt");//��Ҫָ����Դ�����ƣ���Դ��AccessResource.java�ļ�ͬ����
			//�õ���Դ�ľ���·��
			String resourcePath = resourceURL.getFile();
			System.out.println(resourceURL);
			//�����URL resourceURL = AccessResource.class.getResource("a.txt");��û�м���б�ߣ���ô�����null
			//�����URL resourceURL = AccessResource.class.getResource("/a.txt");������б�ߣ���ô�����file:/Z:/JavaDay/src/bin/src/a.txt
			System.out.println(resourcePath);//�����/Z:/JavaDay/src/bin/src/a.txt
			FileReader reader = new FileReader(new File(resourcePath));
			BufferedReader bufferedReader = new BufferedReader(reader);
			String line = bufferedReader.readLine();
			System.out.println(line);
		}
		*/
		
		//��Դ��·���������ǲ��̶��ģ�  ---  ������Ҫ��̬�Ļ�ȡ��Դ�ľ���·��
		//File
		//Reader
		
		
		//�ڶ���
		public static void main(String[] args) 
		{
			//���������ȡ��Դ��URLʱ����Դ���Ʋ�����б��(/)��ͷ
			
			/*
			//��1����Դ����AccessResource.javaͬ��
			URL resourceURL = AccessResource.class.getClassLoader().getResource("a.txt");
			//System.out.println(resourceURL);//��URL resourceURL = AccessResource.class.getClassLoader().getResource("/a.txt");����б�ߵ�ʱ�򣬽��Ϊnull
			System.out.println(resourceURL);//��URL resourceURL = AccessResource.class.getClassLoader().getResource("a.txt");������б�ߵ�ʱ�򣬽��Ϊfile:/Z:/JavaDay/src/bin/a.txt
			*/
			
			//��2����Դ��AccessResource.javaͬ��
			URL resourceURL = AccessResource.class.getClassLoader().getResource("src/a.txt");
			//System.out.println(resourceURL);//��URL resourceURL = AccessResource.class.getClassLoader().getResource("/src/a.txt");����б�ߵ�ʱ�򣬽��Ϊnull
			System.out.println(resourceURL);//��URL resourceURL = AccessResource.class.getClassLoader().getResource("src/a.txt");������б�ߵ�ʱ�򣬽��Ϊfile:/Z:/JavaDay/src/bin/a.txt
			
			//��ȡ��������������Դ
			InputStream in = AccessResource.class.getClassLoader().getResourceAsStream("src/s.txt");
		}

}

