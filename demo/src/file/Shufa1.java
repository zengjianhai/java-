package file;

public class Shufa1 {

	public static void main(String[] args) {
		move(4, "1��", "2��", "3��");
	}
	private static void show(int n ,String from,String to) {
		System.out.println("�ƶ�"+n+":\t��\t"+from+"��\t"+to);
	}
	private static void move(int n,String from,String str,String to) {
		if(n==1){
			show(1, from, to);
		}else{
			move(n-1, from, to, str);
			show(n, from, to);
			move(n-1, str, from, to);
		}
	}

}
