package file;

public class Shufa2 {
	void Traceback(int i, int j, int[][] s) {
		if (i == j)
			return;
		Traceback(i, s[i][j], s);
		Traceback(s[i][j] + 1, j, s);
		System.out.println("Multiply A" + i + "," + s[i][j] + "\tand A" + (s[i][j] + 1) + "," + j);
	}

	int RecurMatrixChain(int i, int j, int[][] s, int[] p) {
		if (i == j)
			return 0;
		int u = RecurMatrixChain(i, i, s, p) + RecurMatrixChain(i + 1, j, s, p) + p[i - 1] * p[i] * p[j];
		s[i][j] = i;

		for (int k = i + 1; k < j; k++) {
			int t = RecurMatrixChain(i, k, s, p) + RecurMatrixChain(k + 1, j, s, p) + p[i - 1] * p[k] * p[j];
			if (t < u) {
				u = t;
				s[i][j] = k;
			}
		}
		return u;
	}

	public static void main(String[] args) {
		int L = 7;  
		Shufa2 shufa2 = new Shufa2();
		int[] p={13,15,3,5,12,20,2};  
		for (int i = 0; i < p.length; i++) {
			System.out.print(p[i]+"   ");
		}
		System.out.println();
	    int[][] s = new int[L][L];
	    for(int i=0;i<L;i++)    
	    {    
			s[i] = new int[L];    
	    }   
	    System.out.println("矩阵的最少计算次数为："+shufa2.RecurMatrixChain(1,6,s,p));
	    System.out.println("矩阵最优计算次序为：");
	    shufa2.Traceback(1,6,s);  
	}

}
