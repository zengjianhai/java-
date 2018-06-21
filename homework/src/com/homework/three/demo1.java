package com.homework.three;

import java.util.Map.Entry;

public class demo1 {
	public static void main(String[] args) {
//		System.out.println("Start");
//		new demo1();
//		System.out.println("end");
		new B();
//		B.BMethod2();
//		for (Entry<Object, Object> entry : System.getProperties().entrySet()) {
//			System.out.println(entry.getKey() + "\t" + entry.getValue());
//		}
		demo1 demo1 = new demo1();
		Class class1 = demo1.getClass();
		ClassLoader loader = class1.getClassLoader(); 
        System.out.println(loader); 
        System.out.println(loader.getParent()); 
        System.out.println(loader.getParent().getParent()); 
	}

	public static void a() {
		System.out.println("执行静态a方法");
	}

	{
		System.out.println("执行普通代码块1");
	}
	public static demo1 sDemo1 = new demo1();

	public demo1() {
		System.out.println("执行构造器");
	}

	{
		System.out.println("执行普通代码块2");
	}
}

/**
 * 首先是调用子类方法时：
 * 1.父类的静态成员变量执行
 * 2.父类的静态代码块执行
 * 3.子类的静态成员变量执行
 * 4.子类的静态代码块执行
 * 5.子类的方法
 * 第二new一个子类
 * 1.父类的静态成员变量执行
 * 2.父类的静态代码块执行
 * 3.子类的静态成员变量执行
 * 4.子类的静态代码块执行
 * 5.父类的普通代码块
 * 6.父类的构造方法
 * 7.子类的普通代码块
 * 8.子类的构造方法
 * @author xunfeng
 *
 */
class A {
	public static int t = AMethod();
	public static int AMethod() {
		System.out.println("A类的静态方法AMethod");
		return 0;
	}
	static{
		System.out.println("A类的静态代码块");
	}
	{
		System.out.println("A类的普通块");
	}
	public A(){
		System.out.println("A类的构造方法");
	}
	public static int AMethod2(){
		System.out.println("A类的静态方法AMethod2");
		return 0;
	}
}
class B extends A{
	public static int t = BMethod();

	public static int BMethod() {
		System.out.println("B类的静态方法BMethod");
		return 0;
	}
	static{
		System.out.println("B类的静态代码块");
	}
	{
		System.out.println("B类的普通块");
	}
	public B(){
		System.out.println("B类的构造方法");
	}
	public static int BMethod2(){
		System.out.println("B类的静态方法BMethod2");
		return 0;
	}
}
