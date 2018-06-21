package com.homework.three;

public class Test {
	String string = "good";
	char[] ch = { 'a', 'b', 'c' };
	int[] is = { 1, 2, 3, 5 };
	
	public static void main(String[] args) {
		D1 d=new D1();
		d.value();
		int a = 99;
		Test test = new Test();
		test.add(a);
		System.out.println("a=" + a);
		test.change(test.string, test.ch);
		System.out.print(test.string + " and ");
		System.out.print(test.ch);
		System.out.println(test.is);
		A1 aa = new A1();
		aa.b = 7;
		test.go(aa.b);
		System.out.println(aa.b);
	}

	public void go(int a) {
		System.out.println(a);
		a = 10;
		System.out.println(a);
	}

	public void change(String string, char ch[]) {
		string = "task ok";
		ch[0] = 'g';
	}

	public void add(int a) {
		a = a++;
		System.out.println(a);
	}
}

class A1 {
	int b = 0;
}
class C1{
	static int a=init();
	static{
		System.out.println("this is c类的静态代码块");
	}
	{
		System.out.println("this is c类的普通代码块");
	}
	public C1(){
		System.out.println("this is c类的构造函数");
	}
	private static int init() {
		System.out.println("this is c init()");
		return 0;
	}
	private static void value() {
		System.out.println("this is c value()");
	}
}

class D1 extends C1{
	static int a=init();
	private static int init() {
		System.out.println("this is d init()");
		return 0;
	}
	public static int value() {
		System.out.println("this is d value()");
		return 0;
	}
	static{
		System.out.println("this is d类的静态代码块");
	}
	{
		System.out.println("this is d类的普通代码块");
	}
	public D1(){
		System.out.println("this is d类的构造函数");
	}
}