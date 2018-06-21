package com.briup.basic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.charset.Charset;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class SecondServlet extends GenericServlet {

	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		System.out.println("ssdasd年后a");
		File file = new File("F:\\MyJava\\ecjtu-web\\src\\com\\briup\\basic\\employee.xml");
		FileInputStream fr = new FileInputStream(file);
		InputStreamReader isr = new InputStreamReader(fr,Charset.forName("utf-8"));
		BufferedReader br = new BufferedReader(isr);
		PrintWriter out = response.getWriter();
		String string=null;
		while ((string=br.readLine())!=null) {
			System.out.println(string);
			out.println(string);
		}
//		out.println("<students>");
//		out.println("<student id='1'>");
//		out.println("<name>你好</name><age>20</age>");
//		out.println("</student>");
//		out.println("<student id='2'>");
//		out.println("<name>jack</name><age>18</age>");
//		out.println("</student>");
//		out.println("</students>");
		out.flush();
		out.close();
	}

}
