package com.briup.dis;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.briup.param.User;
import com.briup.param.UserDao;
import com.briup.param.UserDaoImpl;

@WebServlet("/servlet/loginServlet")
public class LoginServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		String name = req.getParameter("username");
		String pwd = req.getParameter("pwd");
		UserDao dao = new UserDaoImpl();
		User user = dao.findUserByName(name);
		if (user != null) {
			if (user.getPasswd().equals(pwd)) {
				HttpSession session = req.getSession();
				session.setAttribute("user", user);
				out.println("<html><body><h2>登陆成功</h2></body></html>");
			} else {
				out.println("<html><body><h2>密码不正确</h2></body></html>");
			}
		} else {
			out.println("<html><body><h2>用户不正确</h2></body></html>");
		}
		out.flush();

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
