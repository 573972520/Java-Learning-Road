package com.rupeng.test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;

public class Upload1Servlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8"); //������ȷ�ı���֮��ſ��Ա���FileItem�ļ�����������
		resp.setContentType("text/html;charset=UTF-8");
		resp.setCharacterEncoding("UTF-8");
		//����enctype="multipart/form-data" �ı�������ʹ��req.getParameter("action");����ñ���ֵ
		//������type="file"������ͨ����input �� select �� textarea������һ���Ӧһ��DiskFileItem
		//������ͨ����getFileName()��õ��Ǳ�������֣�getString()��õ���ֵ
		//����type="file" getFileName()��õ��Ǳ�������֣�getName()��õ����û�ѡ����ļ���
		
		//�������enctype="multipart/form-data,��ô�����Content-Type����"multipart/form-data **** "
		//ͨ��request��Content-Type�Ϳ���֪��������˵����ǲ���enctype="multipart/form-data
		
		String action = null;
		List<FileItem> files = null;
		//if(req.getContentType().startsWith("multipart/form-data"))
		//�ж������ContentType��֪�������form��encType�ǲ���multipart/form-data
		
		if(ServletFileUpload.isMultipartContent(req))
		{
			String tempFullPath = this.getServletContext().getRealPath("/WEB-INF/temp");
			File fileTemp = new File(tempFullPath); // �ϴ���ʱ�ļ���
			DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory(2*1024*1024,fileTemp);
			ServletFileUpload upload = new ServletFileUpload(diskFileItemFactory);
			PrintWriter out = resp.getWriter();
			try
			{
				files = upload.parseRequest(req);//�������н����ϴ����ļ�����
				//����multipart/form-data��form����ʹ����ͨ�ı���Ҳ��һ�������Ӧһ��FileItem
				FileItem actionDiskItem = RuPengUtils.findDiskFileItem(files, "action");
				if(actionDiskItem != null)
				{
					action = actionDiskItem.getString(); //ȡ��action����ֵ
				}
			}
			catch(FileUploadException e)
			{
				resp.getWriter().print("�ļ��ϴ�����");
				//e.printStackTrace();
			}
		}
		else
		{
			action = req.getParameter("action");
		}
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset:UTF-8");
		
		
		//String action = req.getParameter("action");
		if(RuPengUtils.isNullOrEmpty(action))
		{
			req.getRequestDispatcher("/Upload1.jsp").forward(req, resp);
		}
		//һ��ʹ��"multipart/form-data",��ô�������˾Ͳ�����String action = req.getParameter("action");��ñ�
		else if(action.equals("uploadSubmit"))
		{
			//��Ϊһ��ִ��һ��parseRequest֮��request������ָ���ָ������ˣ�����һ�㲻�ظ�parseRequest
			//������֮ǰ�Ѿ�parseRequest��ɵĽ��List<FileItem> files = null;
			FileItem f1 = RuPengUtils.findDiskFileItem(files, "f1");
			String fileExt = FilenameUtils.getExtension(f1.getName()); //�õ��ļ��ĺ�׺
			if(!fileExt.equalsIgnoreCase("zip")&&!fileExt.equalsIgnoreCase("rar")&&!fileExt.equalsIgnoreCase("jpg")
					&&!fileExt.equalsIgnoreCase("png")&&!fileExt.equalsIgnoreCase("gif"))
			{
				resp.getWriter().print("�������ϴ�.zip��.jpg��.png��.gif֮����ļ�����");
				return;
			}
			//��õ�ǰʱ�䣬�õ������գ�������ʹ��date��toString������
			Date now = new Date(System.currentTimeMillis()); //��ǰʱ��
			Calendar calendar = Calendar.getInstance();
			int year = calendar.get(Calendar.YEAR);
			int month = calendar.get(Calendar.MONTH)+1; //�·ݴ�0��ʼ�����Լ�1
			int day = calendar.get(Calendar.DAY_OF_MONTH);
			
			//��������Ϊ�ļ���
			String  uploadFullPath = this.getServletContext().getRealPath("/upload/"+year
									+"/"+month+"/"+day+"/"+f1.getName());
			//����ļ��в�������FileOutputStream�ᱨ��
			//���Ҫ�ȴ����ļ���
			File file = new File(uploadFullPath); //�ļ�����
			File parentFile = file.getParentFile(); //�õ����ڵ��ļ���(�ļ��������һ���ļ���)
			if(!parentFile.exists())
			{
				parentFile.mkdirs(); //mkdirs��Ѳ����ڵĸ��ļ��еݹ鴴��
			}
			FileOutputStream fos = new FileOutputStream(uploadFullPath);
			
			//Eclipse�е�upload�ǿ���ʱ����ļ��У� ����tomcat���е�ʱ����ʵ��������.me_tcat\webapps\�µ��ļ���
			try
			{
				//f1.getInputStream(); //�ļ�����
				IOUtils.copy(f1.getInputStream(), fos); //���ϴ��ļ���������������������ļ�����
			}
			finally
			{
				IOUtils.closeQuietly(fos);
			}
			
			resp.getWriter().print("�ϴ����");
			
			FileItem f2 = RuPengUtils.findDiskFileItem(files, "f2");
			if(f2.getSize() <= 0)  //�����ļ���С���ж��Ƿ�ѡ�����ļ������Ǽ�ʹ�û���ʹû��ѡ���ļ���f2Ҳ����null,ֻ��getSize() == 0
			{
				resp.getWriter().print("�û�ûѡ��f2");
			}
			else
			{
				resp.getWriter().print("f2�ļ���"+f2.getName());
			}
		}
		
		
	}
}
