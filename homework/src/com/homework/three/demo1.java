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
		System.out.println("ִ�о�̬a����");
	}

	{
		System.out.println("ִ����ͨ�����1");
	}
	public static demo1 sDemo1 = new demo1();

	public demo1() {
		System.out.println("ִ�й�����");
	}

	{
		System.out.println("ִ����ͨ�����2");
	}
}

/**
 * �����ǵ������෽��ʱ��
 * 1.����ľ�̬��Ա����ִ��
 * 2.����ľ�̬�����ִ��
 * 3.����ľ�̬��Ա����ִ��
 * 4.����ľ�̬�����ִ��
 * 5.����ķ���
 * �ڶ�newһ������
 * 1.����ľ�̬��Ա����ִ��
 * 2.����ľ�̬�����ִ��
 * 3.����ľ�̬��Ա����ִ��
 * 4.����ľ�̬�����ִ��
 * 5.�������ͨ�����
 * 6.����Ĺ��췽��
 * 7.�������ͨ�����
 * 8.����Ĺ��췽��
 * @author xunfeng
 *
 */
class A {
	public static int t = AMethod();
	public static int AMethod() {
		System.out.println("A��ľ�̬����AMethod");
		return 0;
	}
	static{
		System.out.println("A��ľ�̬�����");
	}
	{
		System.out.println("A�����ͨ��");
	}
	public A(){
		System.out.println("A��Ĺ��췽��");
	}
	public static int AMethod2(){
		System.out.println("A��ľ�̬����AMethod2");
		return 0;
	}
}
class B extends A{
	public static int t = BMethod();

	public static int BMethod() {
		System.out.println("B��ľ�̬����BMethod");
		return 0;
	}
	static{
		System.out.println("B��ľ�̬�����");
	}
	{
		System.out.println("B�����ͨ��");
	}
	public B(){
		System.out.println("B��Ĺ��췽��");
	}
	public static int BMethod2(){
		System.out.println("B��ľ�̬����BMethod2");
		return 0;
	}
}
