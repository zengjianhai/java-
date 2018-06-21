package composite;

public class Demo1 {

	public static void main(String[] args) {
		AbstractDemo1 root = new EADemo1();
		root.setName("组合");
		root.add(new FirstDemo1("组合的颜色"));
		root.add(new SecordDemo1("组合的大小"));
		AbstractDemo1 root2 = new EADemo1("圆");
		root2.add(new FirstDemo1("圆的颜色"));
		root2.add(new SecordDemo1("圆的大小"));
		AbstractDemo1 root3 = new EADemo1("圆角");
		root3.add(new FirstDemo1("圆角的颜色"));
		root3.add(new SecordDemo1("圆角的大小"));
		AbstractDemo1 root3_2 = new EADemo1("圆环");
		root3_2.add(new FirstDemo1("圆环的颜色"));
		root3_2.add(new SecordDemo1("圆环的大小"));
		root2.add(root3);
		root2.add(root3_2);
		AbstractDemo1 root2_2 = new EADemo1("矩形");
		root2_2.add(new FirstDemo1("矩形的颜色"));
		root2_2.add(new SecordDemo1("矩形的大小"));
		AbstractDemo1 root3_2_2 = new EADemo1("矩形边");
		root3_2_2.add(new FirstDemo1("矩形边的颜色"));
		root3_2_2.add(new SecordDemo1("矩形边的大小"));
		root2_2.add(root3_2_2);
		root.add(root2);
		root.add(root2_2);
		root.display(0);
	}

}
