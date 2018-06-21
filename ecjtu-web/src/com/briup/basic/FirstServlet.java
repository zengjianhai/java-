package com.briup.basic;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;

//@WebServlet(name = "FirstServlet", urlPatterns = { "/servlet/FirstServlet", "/servlet/FirstServlet.do" }, initParams = {
//		@WebInitParam(name = "tom", value = "1.0"), @WebInitParam(name = "java", value = "1.7") }
//		,loadOnStartup=-1)
public class FirstServlet implements Servlet {
	public FirstServlet() {
		System.out.println("FirstServlet");
	}

	@Override
	public void destroy() {
		System.out.println("destroy");
	}

	@Override
	public ServletConfig getServletConfig() {
		return null;
	}

	@Override
	public String getServletInfo() {
		return null;
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init");
		Enumeration<String> enu = config.getInitParameterNames();
		while (enu.hasMoreElements()) {
			String name = (String) enu.nextElement();
			String value = config.getInitParameter(name);
			System.out.println("name=" + name + " value=" + value);
		}
	}
	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		System.out.println("service");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>≤‚ ‘</title></head>");
		out.println("<body><font size='6'><b>" + Math.random() + "</b></font></body></html>");
		out.flush();
		out.close();
	}

}
