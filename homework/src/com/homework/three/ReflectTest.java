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
			
			//实例化有参的对象
			Constructor cons=class1.getConstructor(String.class);
	        demo demo=(demo)cons.newInstance("nihao");
	        System.out.println(demo.getString());
	        
	        Method method = class1.getMethod("as");
	        Object object2 = method.invoke(object);
	        //as方法返回是void，所以object2是null
	        System.out.println(object2);
	        //declare声明，宣布。demo类声明了的方法
	        Method DeclaredMethods[]=class1.getDeclaredMethods();
	        for(Method metho:DeclaredMethods){
	            System.out.println(metho);
	        }
	        
	        Method AllMethods[]=class1.getMethods();
	        for(Method metho:AllMethods){
	            System.out.println("method :"+metho);
	        }
	        //成员变量的字段
	        Field fields[]=class1.getDeclaredFields();
	        for(Field field:fields){
	            System.out.println(field);
	        }
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
