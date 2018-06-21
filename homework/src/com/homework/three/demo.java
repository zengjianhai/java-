package com.homework.three;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class demo {

	public static void main(String[] args) {
		demo demo = new demo();
		demo.s();
		System.out.println(demo.s());
		// System.out.println(demo.add(1, 0));
//		new D();
//		Thread thread1 = new MyThread();
//		Thread thread2 = new MyThread();
//		thread1.start();
//		thread2.start();
		String str = "com.homework.three.ShapeTest";
		try {
			Class class1 = Class.forName(str);
			Object object = class1.newInstance();
			String method = "leftTriangle";
			Method method2 = class1.getMethod(method);
			Object object2 = method2.invoke(object);
			System.out.println(object2+"");
		} catch (Exception e) {
			e.printStackTrace();
		} 
		List list = new ArrayList();
		test(list);
		System.out.println(list.size());
		test2(list);
		System.out.println(list.size());
	}
	public static void test(List list){
		list = null;
	}
	public static void test2(List list){
		list.add("aaa");
	}
	/**
	 * ������û��finally�еĳ����ִ��
	 * @return
	 */
	public String s(){
		try {
			return "1";
		} catch (Exception e) {
		}finally {
			System.out.println("s()");
		}
		return "";
	}
	public demo(){}
	String string;
	public demo(String string){
		this.string = string;
	}
	public String getString(){
		return string;
	}
	public void as(){
		System.out.println("as");
	}
	/**
	 * �ݹ��������:1!+2!+...+n!
	 * 
	 * @param j
	 * @param count
	 * @return
	 */
	public int add(int j, int count) {
		for (int i = 1; i <= j; i++) {
			count = count + i;
			System.out.println("count=" + count);
		}
		if (j >= 10) {
			return count;
		} else {
			j++;
			System.out.println(j);
			return add(j, count);
		}
	}
}

class D extends C {
	public String sd1 = getSd1();
	public static String sd = getSd();
	static {
		System.out.println("ִ��D��static��̬�����");
	}
	{
		System.out.println("ִ��D����ͨ��ʼ����");
	}

	D() {
		System.out.println("D�Ĺ��캯��");
	}

	static public String getSd() {
		System.out.println("��ʼ��D��ʵ������sd");
		return "sd";
	}

	public String getSd1() {
		System.out.println("��ʼ��D��ʵ������sd1");
		return "sd1";
	}
}

class C {
	static {
		System.out.println("ִ��C��static��̬�����");
	}
	{
		System.out.println("ִ��C����ͨ��ʼ����");
	}

	C() {
		System.out.println("C�Ĺ��캯��");
	}
}

class MyThread extends Thread {
	private static int num;
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			synchronized (this.getClass()) {
				num++;
				System.out.println("num="+num);
				System.out.println("getClass="+this.getName());
				if(num==5){
					try {
						this.getClass().wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				this.getClass().notify();
			}
		}
	}
}