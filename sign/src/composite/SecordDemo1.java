package composite;

public class SecordDemo1 extends AbstractDemo1{

	public SecordDemo1() {
	}
	public SecordDemo1(String name){
		super(name);
	}
	@Override
	protected void add(AbstractDemo1 aDemo1) {
	}

	@Override
	protected void remove(AbstractDemo1 aDemo1) {
	}

	@Override
	protected void display(int depth) {
		StringBuilder sBuilder = new StringBuilder("");
		for(int i = 0;i<depth;i++){
			sBuilder.append("=");
		}
		System.out.println(new String(sBuilder)+this.getName());

	}

}
