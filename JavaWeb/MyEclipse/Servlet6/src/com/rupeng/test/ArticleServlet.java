package com.rupeng.test;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ArticleServlet extends HttpServlet {
	
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
		String action = req.getParameter("action");
		if(action.equals("view"))
		{
			int id = Integer.parseInt(req.getParameter("id"));
			ArticleInfo article = new ArticleDAO().getById(id);
			if(article == null)
			{
				req.setAttribute("msg", "ָ��id�����²�����");
				req.getRequestDispatcher("/Error.jsp").forward(req, resp);
			}
			else
			{
				req.setAttribute("model", article);
				req.getRequestDispatcher("/ViewArticle.jsp").forward(req, resp);
			}
		}
		else if(action.equals("postComment"))
		{
			//AJAX����Ҫ�������봦����
			String content =  req.getParameter("content"); //RuPengUtils.getParameter(req, "content");
			AjaxResult result = new AjaxResult();
			if(content.contains("ȥ��") ||content.contains("�����") )
			{
				result.setErrorCode("diryWord"); //�໰
			}
			else
			{
				Integer aId = Integer.parseInt(req.getParameter("aId"));
				new ArticleCommentDAO().postComment(aId, content);
				result.setErrorCode("ok");
			}
			resp.getWriter().print(result.toString());
		}
		else if(action.equals("loadComment"))
		{
			resp.setContentType("application/json;charset=UTF-8");
			resp.setCharacterEncoding("UTF-8"); //���ñ���
			int aId = Integer.parseInt(req.getParameter("aId"));
			List<ArticleCommentInfo> list  = new ArticleCommentDAO().getByArticleId(aId);
			AjaxResult result = new AjaxResult();
			result.setErrorCode("ok");
			result.setData(list);
			resp.getWriter().print(result.toString());
		}
	}
}
