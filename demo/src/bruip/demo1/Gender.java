package bruip.demo1;

public enum Gender {
	//M,F�൱���������󣬶���Gender��String name��������
	M("��"),F("Ů");
	private String name;
	
	public void say(){
		System.out.println("���");
	}
	//��������˽�еģ���Ϊö�ٵĹ���������˽�е�
	private Gender(String name){
		this.name = name;
	}
	public String toString(){
		return name;
	}
	
}
