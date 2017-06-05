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
		writer.println("<table><thead><tr><td>����</td><td>�ǳ�</td><td>����</td><td>�Ƿ񸻶���</td><td>רҵ</td><td>��ȡ��</td></tr></thead>");
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
						majorName = "�����";
					}
					else if(major.equals("xxgl"))
					{
						majorName = "��Ϣ����";
					}
					else if(major.equals("jixie"))
					{
						majorName = "��е";
					}
					else
					{
						majorName = "δ֪";
					}
					String xqx = rs.getString("XQX");
					String xqxName = "";
					if(xqx.equals("male"))
					{
						xqxName = "ϲ���е�";
					}
					else if(xqx.equals("female"))
					{
						xqxName = "ϲ��Ů��";
					}
					else if(xqx.equals("both"))
					{
						xqxName = "ͨ��";
					}
					else
					{
						xqxName = "δ֪";
					}
					writer.println("<tr><td>"+name+"</td><td>"+nickName+"</td><td>"+age+"</td><td>"+(isTuHao?"����":"������")+
							"</td><td>"+majorName+"</td><td>"+xqxName+"</td></tr>");
					
				}
			}
			finally
			{
				JdbcUtils.closeAll(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			writer.println("��ѯ����");
		}
		writer.println("</tbody>");
		writer.println("</table>");
		writer.println("</body></html>");
		
	}
}
