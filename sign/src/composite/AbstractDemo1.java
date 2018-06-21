package composite;

public abstract class AbstractDemo1 {
	private String name;

	public AbstractDemo1(String name) {
		this.name = name;
	}

	public AbstractDemo1() {
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	protected abstract void add(AbstractDemo1 aDemo1);
	protected abstract void remove(AbstractDemo1 aDemo1);
	protected abstract void display(int depth);
}
