package briup.interfaceTest;

public class Test1 {

	public static void main(String[] args) {
		PersonA a=new PersonA();
		a.say();
		PersonB b=new PersonB();
		b.say();
	}

}
interface PersonSay{
	//给出人都有说话这个方法功能
	public void say();
}
class PersonA implements PersonSay{
	/*方法say（）的实现
	 * 不同的人可以说不同的话
	 * */
	@Override
	public void say() {
		System.out.println("PersonA说我是A");
	}
	
}
class PersonB implements PersonSay{

	@Override
	public void say() {
		System.out.println("PersonB说我是B");
	}
	
}