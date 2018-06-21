package com.briup.dis;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet/targetServlet")
public class TargetServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("utf-8");
		Cookie[] cookies = req.getCookies();
		for (Cookie cookie : cookies) {
			String name = cookie.getName();
			String value = cookie.getValue();
			System.out.println(name+value);
		}
		/*PrintWriter out = resp.getWriter();
		String reqValue = (String) req.getAttribute("requestScope");
		//浏览器没关就一直存在
		int sessionValue = (int)req.getSession().getAttribute("sessionScope");
		//服务器没关就一直存在
		boolean appValue = (boolean)req.getSession().getServletContext().
				getAttribute("applicationScope");
		out.println("<html><body>");
		out.println("<h2>reqS:"+reqValue+"</h2>");
		out.println("<h2>sesS:"+sessionValue+"</h2>");
		out.println("<h2>appS:"+appValue+"</h2>");
		out.println("</body></html>");
		out.flush();*/
		/*String name = req.getParameter("name");
		System.out.println("targetServlet:"+name);
		PrintWriter out = resp.getWriter();
		out.println("<html><body>");
		out.println("<h2>targetServlet from sourceServlet</h2>");
		out.println("</body></html>");
		out.flush();*/
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}

}
