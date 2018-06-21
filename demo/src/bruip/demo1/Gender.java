package bruip.demo1;

public enum Gender {
	//M,F相当于两个对象，都有Gender（String name）构造器
	M("男"),F("女");
	private String name;
	
	public void say(){
		System.out.println("你好");
	}
	//构造器是私有的，因为枚举的构造器都是私有的
	private Gender(String name){
		this.name = name;
	}
	public String toString(){
		return name;
	}
	
}
