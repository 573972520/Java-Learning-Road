package com.rupeng.web;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
public class Test2Filter implements Filter {

	public void destroy() {
		
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("test2Filter开始执行前期处理");
		chain.doFilter(request, response);
		System.out.println("test2Filter开始执行后续处理");
		
	}

	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
