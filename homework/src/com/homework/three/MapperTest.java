package com.homework.three;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * ����
 * @author xunfeng
 *
 */
public class MapperTest {

	public static void main(String[] args) {
		String str = "com.homework.three.A";
		try {
			//cΪA�������ͱ���,�����ͱ��������������Ķ���
			Class c = Class.forName(str);
			Object obj = c.newInstance();
			System.out.println("obj:"+obj);
			String method = "AMethod2";
			Method getM = c.getMethod(method);
			System.out.println("Method:"+obj);
			Object object = getM.invoke(obj);
			System.out.println(object);
			//����ֻ�ڱ���ִ�У�ͨ�������ƹ����룬����Ч��
			ArrayList list1 = new ArrayList();
			ArrayList<String> list2 = new ArrayList<String>();
			
			list2.add("hello"); 
			Class cList1 = list1.getClass();
			Class cList2 = list2.getClass();
			System.out.println(cList1==cList2);
			
			String add = "add";
			Method cL = cList2.getMethod(add, Object.class);
			cL.invoke(list2, 20);
			System.out.println(list2.size());
			System.out.println(list2);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

}
