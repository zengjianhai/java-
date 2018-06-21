package com.briup.dis;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/servlet/sourceServlet")
public class SourceServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("utf-8");
		req.setAttribute("requestScope", "request");
		HttpSession session = req.getSession();
		session.setAttribute("sessionScope", 10);
		ServletContext context = req.getSession().getServletContext();
		context.setAttribute("applicationScope", true);
		Cookie cookie1 = new Cookie("name", "tom");
		Cookie cookie2 = new Cookie("value", "12");
		//保存时间
		cookie1.setMaxAge(60*60*24);
		resp.addCookie(cookie1);
		resp.addCookie(cookie2);
		/*String name = req.getParameter("name");
		System.out.println("sourceServlet:"+name);
		PrintWriter out = resp.getWriter();
		out.println("<html><body>");
		out.println("<h2>sourceServlet to targetServlet</h2>");
		out.println("</body></html>");*/
		//forward会跳转前的清空信息，include不会清空信息，req一个request
//		req.getRequestDispatcher("/servlet/targetServlet").
//			forward(req, resp);
//			include(req, resp);
		//重定向有两个request
		resp.sendRedirect("/ecjtu-web/servlet/targetServlet");
//		out.flush();	
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}

}
