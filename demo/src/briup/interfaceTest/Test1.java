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
	//�����˶���˵�������������
	public void say();
}
class PersonA implements PersonSay{
	/*����say������ʵ��
	 * ��ͬ���˿���˵��ͬ�Ļ�
	 * */
	@Override
	public void say() {
		System.out.println("PersonA˵����A");
	}
	
}
class PersonB implements PersonSay{

	@Override
	public void say() {
		System.out.println("PersonB˵����B");
	}
	
}