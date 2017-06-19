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
				req.setAttribute("msg", "指定id的文章不存在");
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
			//AJAX不需要进行乱码处理了
			String content =  req.getParameter("content"); //RuPengUtils.getParameter(req, "content");
			AjaxResult result = new AjaxResult();
			if(content.contains("去死") ||content.contains("他妈的") )
			{
				result.setErrorCode("diryWord"); //脏话
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
			resp.setCharacterEncoding("UTF-8"); //设置编码
			int aId = Integer.parseInt(req.getParameter("aId"));
			List<ArticleCommentInfo> list  = new ArticleCommentDAO().getByArticleId(aId);
			AjaxResult result = new AjaxResult();
			result.setErrorCode("ok");
			result.setData(list);
			resp.getWriter().print(result.toString());
		}
	}
}
