package com.briup.basic;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.briup.param.User;

import oracle.net.aso.s;

@WebServlet(name ="ThirdServlet",
			urlPatterns = {"/servlet/thirdServlet","/servlet/thirdServlet.do" },
			initParams = {@WebInitParam(name = "tom", value = "1.0"),
						@WebInitParam(name = "java", value = "1.7") })
public class ThirdServlet extends HttpServlet {
	int i = 0;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("this is doget方法");
		resp.setContentType("image/jpeg;charset=utf-8");
		i++;
		System.out.println(i);
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("user");
		System.out.println("==================="+user);
		if (user != null) {
			File file = new File("F:/MyJava/ecjtu-web/src/com/briup/basic/c.jpg");
			BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
			BufferedOutputStream bos = new BufferedOutputStream(resp.getOutputStream());
			byte[] bs = new byte[1024];
			int count = 0;
			while ((count = bis.read(bs)) != -1) {
				bos.write(bs, 0, count);
			}
			bos.flush();
			bos.close();
		}
		// File file = new
		// File("F:/MyJava/ecjtu-web/src/com/briup/basic/f.jpg");
		// FileReader fr = new FileReader(file);
		// BufferedReader br = new BufferedReader(fr);
		// PrintWriter out = resp.getWriter();
		// String string=null;
		// while ((string=br.readLine())!=null) {
		// out.println(string);
		// }
		// out.flush();
		// out.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("this is dopost方法");
		doGet(req, resp);
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		Enumeration<String> enu = config.getInitParameterNames();
		while (enu.hasMoreElements()) {
			String name = (String) enu.nextElement();
			String value = config.getInitParameter(name);
			System.out.println("name=" + name + " value=" + value);
		}
	}

}
