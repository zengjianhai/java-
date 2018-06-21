package demo;

import java.lang.reflect.Method;

public class TestToClass {

	public static void main(String[] args) {
		try {
//			Class c1 = Student.class; // 第一种
//
//			Student s = new Student();
//			Class c2 = s.getClass(); // 第二种

			String str = "demo.test";
			Class c = Class.forName(str); // 第三种
//
//			System.out.print(c1 == c2);
//			System.out.print(c2 == c3);
//			System.out.print(c1 == c3);

			Object obj = c.newInstance();

			String methodName = "say";
			Method m = c.getMethod(methodName);
			Object returnValue = m.invoke(obj);
			System.out.println(returnValue+"");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
