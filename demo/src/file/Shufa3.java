package file;

public class Shufa3 {
	void Traceback(int i,int j,int[][] s)  
	{  
	    if(i==j) return;  
	    Traceback(i,s[i][j],s);  
	    Traceback(s[i][j]+1,j,s);  
		System.out.println("Multiply A" + i + "," + s[i][j] + "\tand A" + (s[i][j] + 1) + "," + j);
	}  
	int MemoizedMatrixChain(int n,int[][] m,int[][] s,int[] p)  
	{  
	    for(int i=1; i<=n; i++)  
	    {  
	        for(int j=1; j<=n; j++)  
	        {  
	            m[i][j]=0;  
	        }  
	    }  
	    return LookupChain(1,n,m,s,p);  
	}  
	  
	int LookupChain(int i,int j,int[][] m,int[][] s,int[] p)  
	{  
	    if(m[i][j]>0)  
	    {  
	        return m[i][j];  
	    }  
	    if(i==j)  
	    {  
	        return 0;  
	    }  
	  
	    int u = LookupChain(i,i,m,s,p) + LookupChain(i+1,j,m,s,p)+p[i-1]*p[i]*p[j];  
	    s[i][j]=i;  
	    for(int k=i+1; k<j; k++)  
	    {  
	        int t = LookupChain(i,k,m,s,p) + LookupChain(k+1,j,m,s,p) + p[i-1]*p[k]*p[j];  
	        if(t<u)  
	        {  
	            u=t;  
	            s[i][j] = k;  
	        }  
	    }  
	    m[i][j] = u;  
	    return u;  
	}  
	public static void main(String[] args) {
	int L = 7;
	Shufa3 shufa3 = new Shufa3();
	int[] p={12,5,1,5,10,7,25};  
	  
    int[][] s = new int[L][L];  
    int[][] m = new int[L][L];  
    for(int i=0;i<L;i++)    
    {    
        s[i] = new int[L];  
        m[i] = new int[L];  
    }   
  System.out.println("矩阵的最少计算次数为："+shufa3.MemoizedMatrixChain(6,m,s,p));
System.out.println("矩阵最优计算次序为：");      
    shufa3.Traceback(1,6,s);  

	}
}
