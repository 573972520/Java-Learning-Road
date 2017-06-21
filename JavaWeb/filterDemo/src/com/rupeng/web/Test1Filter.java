package com.rupeng.web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Test1Filter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("filter init");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("test1Filter开始执行前期处理");
		chain.doFilter(request, response);
		System.out.println("test1Filter开始执行后续处理");
	}

	@Override
	public void destroy() {
		System.out.println("filter destroy");
	}

}
