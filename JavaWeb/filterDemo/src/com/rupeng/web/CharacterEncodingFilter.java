package com.rupeng.web;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CharacterEncodingFilter implements Filter {

	public void destroy() {
		
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//由于是使用Tomcat8服务器，所以只需要对post请求时的请求体进行编码处理就可以了
		request.setCharacterEncoding("UTF-8");
		
		//顺便把响应的编码也做下处理
		response.setCharacterEncoding("UTF-8");
		
		System.out.println("字符编码过滤器执行了");
		chain.doFilter(request, response);
		
	}
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
