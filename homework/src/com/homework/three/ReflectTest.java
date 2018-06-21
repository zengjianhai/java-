package com.homework.three;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectTest {

	public static void main(String[] args) {
		String str = "com.homework.three.demo";
		try {
			Class class1 = Class.forName(str);
			Object object = class1.newInstance();
			System.out.println(object instanceof demo);
			
			//ʵ�����вεĶ���
			Constructor cons=class1.getConstructor(String.class);
	        demo demo=(demo)cons.newInstance("nihao");
	        System.out.println(demo.getString());
	        
	        Method method = class1.getMethod("as");
	        Object object2 = method.invoke(object);
	        //as����������void������object2��null
	        System.out.println(object2);
	        //declare������������demo�������˵ķ���
	        Method DeclaredMethods[]=class1.getDeclaredMethods();
	        for(Method metho:DeclaredMethods){
	            System.out.println(metho);
	        }
	        
	        Method AllMethods[]=class1.getMethods();
	        for(Method metho:AllMethods){
	            System.out.println("method :"+metho);
	        }
	        //��Ա�������ֶ�
	        Field fields[]=class1.getDeclaredFields();
	        for(Field field:fields){
	            System.out.println(field);
	        }
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
