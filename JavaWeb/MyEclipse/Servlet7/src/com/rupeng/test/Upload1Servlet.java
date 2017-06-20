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
		req.setCharacterEncoding("UTF-8"); //设置正确的编码之后才可以避免FileItem文件名乱码的情况
		resp.setContentType("text/html;charset=UTF-8");
		resp.setCharacterEncoding("UTF-8");
		//对于enctype="multipart/form-data" 的表单，不能使用req.getParameter("action");来获得表单的值
		//无论是type="file"还是普通表单域（input 、 select 、 textarea）都是一项对应一个DiskFileItem
		//对于普通表单域getFileName()获得的是表单域的名字，getString()获得的是值
		//对于type="file" getFileName()获得的是表单域的名字，getName()获得的是用户选择的文件名
		
		//如果表单是enctype="multipart/form-data,那么请求的Content-Type就是"multipart/form-data **** "
		//通过request的Content-Type就可以知道浏览器端到底是不是enctype="multipart/form-data
		
		String action = null;
		List<FileItem> files = null;
		//if(req.getContentType().startsWith("multipart/form-data"))
		//判断请求的ContentType得知浏览器端form的encType是不是multipart/form-data
		
		if(ServletFileUpload.isMultipartContent(req))
		{
			String tempFullPath = this.getServletContext().getRealPath("/WEB-INF/temp");
			File fileTemp = new File(tempFullPath); // 上传临时文件夹
			DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory(2*1024*1024,fileTemp);
			ServletFileUpload upload = new ServletFileUpload(diskFileItemFactory);
			PrintWriter out = resp.getWriter();
			try
			{
				files = upload.parseRequest(req);//从请求中解析上传的文件内容
				//对于multipart/form-data的form，即使是普通的表单域也是一个表单域对应一个FileItem
				FileItem actionDiskItem = RuPengUtils.findDiskFileItem(files, "action");
				if(actionDiskItem != null)
				{
					action = actionDiskItem.getString(); //取得action表单的值
				}
			}
			catch(FileUploadException e)
			{
				resp.getWriter().print("文件上传错误");
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
		//一旦使用"multipart/form-data",那么服务器端就不能用String action = req.getParameter("action");获得表单
		else if(action.equals("uploadSubmit"))
		{
			//因为一旦执行一次parseRequest之后request的流的指针就指向最后了，所以一般不重复parseRequest
			//就是用之前已经parseRequest完成的结果List<FileItem> files = null;
			FileItem f1 = RuPengUtils.findDiskFileItem(files, "f1");
			String fileExt = FilenameUtils.getExtension(f1.getName()); //拿到文件的后缀
			if(!fileExt.equalsIgnoreCase("zip")&&!fileExt.equalsIgnoreCase("rar")&&!fileExt.equalsIgnoreCase("jpg")
					&&!fileExt.equalsIgnoreCase("png")&&!fileExt.equalsIgnoreCase("gif"))
			{
				resp.getWriter().print("不允许上传.zip、.jpg、.png、.gif之外的文件类型");
				return;
			}
			//获得当前时间，拿到年月日（还可以使用date的toString方法）
			Date now = new Date(System.currentTimeMillis()); //当前时间
			Calendar calendar = Calendar.getInstance();
			int year = calendar.get(Calendar.YEAR);
			int month = calendar.get(Calendar.MONTH)+1; //月份从0开始，所以加1
			int day = calendar.get(Calendar.DAY_OF_MONTH);
			
			//以年月日为文件夹
			String  uploadFullPath = this.getServletContext().getRealPath("/upload/"+year
									+"/"+month+"/"+day+"/"+f1.getName());
			//如果文件夹不存在则FileOutputStream会报错
			//因此要先创建文件夹
			File file = new File(uploadFullPath); //文件对象
			File parentFile = file.getParentFile(); //拿到所在的文件夹(文件对象的上一级文件夹)
			if(!parentFile.exists())
			{
				parentFile.mkdirs(); //mkdirs会把不存在的父文件夹递归创建
			}
			FileOutputStream fos = new FileOutputStream(uploadFullPath);
			
			//Eclipse中的upload是开发时候的文件夹， 但是tomcat运行的时候其实操作的是.me_tcat\webapps\下的文件夹
			try
			{
				//f1.getInputStream(); //文件内容
				IOUtils.copy(f1.getInputStream(), fos); //把上传文件的内容流拷贝到输出的文件流中
			}
			finally
			{
				IOUtils.closeQuietly(fos);
			}
			
			resp.getWriter().print("上传完成");
			
			FileItem f2 = RuPengUtils.findDiskFileItem(files, "f2");
			if(f2.getSize() <= 0)  //根据文件大小来判断是否选择了文件，但是即使用户即使没有选择文件，f2也不是null,只是getSize() == 0
			{
				resp.getWriter().print("用户没选择f2");
			}
			else
			{
				resp.getWriter().print("f2文件名"+f2.getName());
			}
		}
		
		
	}
}
