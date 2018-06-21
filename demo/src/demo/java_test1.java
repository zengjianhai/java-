package demo;

public class java_test1 {
	private void say() {
		System.out.println("hello");
	}

	public void go() {
		say();
	}
}

class B extends java_test1 {
	public void Test() {
		//间接调用父类中的私有方法say()
		go();
	}

}
