package composite;


import java.util.ArrayList;
import java.util.List;

public class EADemo1 extends AbstractDemo1 {
	private List<AbstractDemo1> lists;

	public EADemo1() {
		lists = new ArrayList<>();
	}

	public EADemo1(String name) {
		super(name);
		lists = new ArrayList<>();
	}

	@Override
	protected void add(AbstractDemo1 aDemo1) {
		lists.add(aDemo1);
	}

	@Override
	protected void remove(AbstractDemo1 aDemo1) {
		lists.remove(aDemo1);
	}

	@Override
	protected void display(int depth) {
		StringBuilder sBuilder = new StringBuilder("");
		for(int i = 0;i<depth;i++){
			sBuilder.append("-");
		}
		System.out.println(new String(sBuilder)+this.getName());
		for(AbstractDemo1 ad:lists){
			ad.display(depth+2);
		}
	}

}
