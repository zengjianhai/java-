package composite;

public class Demo1 {

	public static void main(String[] args) {
		AbstractDemo1 root = new EADemo1();
		root.setName("���");
		root.add(new FirstDemo1("��ϵ���ɫ"));
		root.add(new SecordDemo1("��ϵĴ�С"));
		AbstractDemo1 root2 = new EADemo1("Բ");
		root2.add(new FirstDemo1("Բ����ɫ"));
		root2.add(new SecordDemo1("Բ�Ĵ�С"));
		AbstractDemo1 root3 = new EADemo1("Բ��");
		root3.add(new FirstDemo1("Բ�ǵ���ɫ"));
		root3.add(new SecordDemo1("Բ�ǵĴ�С"));
		AbstractDemo1 root3_2 = new EADemo1("Բ��");
		root3_2.add(new FirstDemo1("Բ������ɫ"));
		root3_2.add(new SecordDemo1("Բ���Ĵ�С"));
		root2.add(root3);
		root2.add(root3_2);
		AbstractDemo1 root2_2 = new EADemo1("����");
		root2_2.add(new FirstDemo1("���ε���ɫ"));
		root2_2.add(new SecordDemo1("���εĴ�С"));
		AbstractDemo1 root3_2_2 = new EADemo1("���α�");
		root3_2_2.add(new FirstDemo1("���αߵ���ɫ"));
		root3_2_2.add(new SecordDemo1("���αߵĴ�С"));
		root2_2.add(root3_2_2);
		root.add(root2);
		root.add(root2_2);
		root.display(0);
	}

}
