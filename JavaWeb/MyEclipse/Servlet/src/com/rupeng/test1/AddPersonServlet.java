package com.rupeng.test1;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddPersonServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		//如果数据库中打开是乱码，处理步骤如下：
		//1 获取的请求参数是不是乱码
		//2 数据库连接字符串，数据可靠编码等是否乱码
		String name = RuPengUtils.getParameter(req, "name");
		String nickName = RuPengUtils.getParameter(req, "nickName");
		int age = Integer.parseInt(req.getParameter("age"));
		//boolean isTuHao = req.getParameter("isTuHao").equals("on");
		boolean isTuHao = "on".equals(req.getParameter("isTuHao")); //但此选项不选的时候，值为null如果使用上述的代码则会出现NullPointerException错误
		String major = req.getParameter("major");
		String xqx = req.getParameter("xqx");
		
		resp.setContentType("text/html;charset=UTF-8");
		resp.setCharacterEncoding("UTF-8");
		try {
			JdbcUtils.executeUpdate("Insert into T_Persons(Name,NickName,Age,isTuHao,Major,XQX) values(?,?,?,?,?,?)",
									name,nickName,age,isTuHao,major,xqx);
		resp.getWriter().print("插入成功");
		} catch (SQLException e) {
			e.printStackTrace();
			resp.getWriter().print("数据库执行失败");
		}
		
				
				
		
	}
}
