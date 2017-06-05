package com.rupeng.test1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowPersonsServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		resp.setCharacterEncoding("UTF-8");
		PrintWriter writer = resp.getWriter();
		writer.println("<html><head><meta charset='utf-8' /></head><body>");
		writer.println("</head><body>");
		writer.println("<table><thead><tr><td>姓名</td><td>昵称</td><td>年龄</td><td>是否富二代</td><td>专业</td><td>性取向</td></tr></thead>");
		writer.println("<tbody>");
		
		try {
			ResultSet rs = JdbcUtils.executeQuery("select * from T_Persons");
			try
			{
				while(rs.next())
				{
					String name = rs.getString("Name");
					String nickName = rs.getString("NickName");
					int age = rs.getInt("Age");
					boolean isTuHao = rs.getBoolean("IsTuHao");
					String major = rs.getString("Major");
					String majorName = "";
					if(major.equals("jsj"))
					{
						majorName = "计算机";
					}
					else if(major.equals("xxgl"))
					{
						majorName = "信息管理";
					}
					else if(major.equals("jixie"))
					{
						majorName = "机械";
					}
					else
					{
						majorName = "未知";
					}
					String xqx = rs.getString("XQX");
					String xqxName = "";
					if(xqx.equals("male"))
					{
						xqxName = "喜欢男的";
					}
					else if(xqx.equals("female"))
					{
						xqxName = "喜欢女的";
					}
					else if(xqx.equals("both"))
					{
						xqxName = "通吃";
					}
					else
					{
						xqxName = "未知";
					}
					writer.println("<tr><td>"+name+"</td><td>"+nickName+"</td><td>"+age+"</td><td>"+(isTuHao?"土豪":"非土豪")+
							"</td><td>"+majorName+"</td><td>"+xqxName+"</td></tr>");
					
				}
			}
			finally
			{
				JdbcUtils.closeAll(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			writer.println("查询出错！");
		}
		writer.println("</tbody>");
		writer.println("</table>");
		writer.println("</body></html>");
		
	}
}
