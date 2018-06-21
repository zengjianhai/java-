package bruip.demo1;

public class Test {

	public static void main(String[] args) {

		Test test = new Test();
		test.test(Gender.M);

		Gender[] genders = Gender.values();
		for (Gender g : genders) {
			System.out.println(g);
			g.say();
		}
	}

	public void test(Gender gender) {
	}

}
