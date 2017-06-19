package com.rupeng.test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ArticleCommentDAO {
	
	/**
	 * 获得主键为aID的文章的所有评论
	 * @param aId
	 * @return
	 */
	public List<ArticleCommentInfo> getByArticleId(int aId)
	{
		ResultSet rs = null;
		try
		{
			rs = JdbcUtils.executeQuery("select * from T_ArticleComments where ArticleId=?", aId);
			List<ArticleCommentInfo> list = new ArrayList<ArticleCommentInfo>();
			while(rs.next())
			{
				ArticleCommentInfo comment = new ArticleCommentInfo();
				comment.setArticleId(aId);
				comment.setContent(rs.getString("Content"));
				comment.setId(rs.getInt("Id"));
				comment.setPostDataTime(rs.getDate("PostDataTime"));
				list.add(comment);
			}
			return list;
		}
		catch(SQLException e)
		{
			throw new RuntimeException(e);
		}
		finally
		{
			JdbcUtils.closeAll(rs);
		}
	}
	
	public void postComment(int aId,String content)
	{
		try
		{
			JdbcUtils.executeUpdate("Insert into T_ArticleComments(ArticleId,Content,PostDataTime) values(?,?,now())", aId,content);
		}
		catch(SQLException e)
		{
			throw new RuntimeException(e);
		}
	}
}
