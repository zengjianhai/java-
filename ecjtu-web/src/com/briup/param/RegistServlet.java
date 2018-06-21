package com.briup.param;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import oracle.net.aso.h;

@WebServlet("/servlet/registServlet")
public class RegistServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// ǰ̨�ң���̨����
		resp.setCharacterEncoding("utf-8");
		// ��̨�ң�ǰ̨����
		req.setCharacterEncoding("utf-8");
		String name = req.getParameter("username");
		String passwd = req.getParameter("pwd");
		String gender = req.getParameter("gender");
		// ���յ���������Ϣ
		String[] hobby = req.getParameterValues("hobby");
		int age = Integer.parseInt(req.getParameter("age"));
		String string = hobby[0];
		for (int i = 1; i < hobby.length; i++) {
			string += "," + hobby[i];
		}
		/*//mybatis���
		UserMybatisDao umd = new UserMybatisDao();
		PrintWriter out = resp.getWriter();
		if (umd.select(name)) {
			User user = new User(name, passwd, gender, string, age);
			umd.save(user);
			// out.println("<html><body><h1>");
			// out.println(name+"�ɹ�</h1></body></html>");
			// req.getRequestDispatcher("/login.html").forward(req, resp);
			req.getSession().getServletContext().
					getRequestDispatcher("/login.html").forward(req, resp);
		} else {
			req.getRequestDispatcher("../regist.html").forward(req, resp);
			// out.println("<html><body><h1>");
			// out.println("��½ʧ��</h1></body></html>");
		}*/
		UserDaoImpl impl = new UserDaoImpl();
		User user = impl.findUserByName(name);
		
		if (user==null) {
			User user2 = new User(name, passwd, gender, string, age);
			impl.saveUser(user2);
			
			//�ض���ľ���·����tomcat��·��
			resp.sendRedirect("/ecjtu-web/login.html");
			/*req.getSession().getServletContext().
					getRequestDispatcher("/login.html").forward(req, resp);*/
		} else {
			resp.sendRedirect("../regist.html");
			/*req.getRequestDispatcher("../regist.html").forward(req, resp);*/
		}
		System.out.println("name=" + name);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// resp.setCharacterEncoding("utf-8");
		// req.setCharacterEncoding("utf-8");
		// Map<String, String[]> map = req.getParameterMap();
		// Set<String> set = map.keySet();
		// for (String string : set) {
		// String value = req.getParameter(string);
		// System.out.println(value);
		// }
		// doGet(req, resp);
	}

}
