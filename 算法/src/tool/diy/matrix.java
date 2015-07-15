package tool.diy;
import stdlib.StdOut;
import stdlib.StdRandom;

/**
 * Created by Arron on 2015/6/25.
 * @author Arron_lin
 */
public class matrix {
//  转置矩阵
	public static int[][] mig(int[][] a,int[][] b){
		for (int i=0;i<a.length;i++){
			for (int j = 0;j<a[i].length;j++){
				b[j][i] = a[i][j];
			}
		}
		return b;
	}
//	矩阵初始化
	public static int[][] rdm(int[][] a,int N){
		for (int i = 0;i<a.length;i++){
			for (int j = 0;j<a[i].length;j++){
				a[i][j] = StdRandom.uniform(N);
			}
		}
		return a;
	}
//  打印矩阵
	public static void prt(int[][] a){
		for (int i = 0;i<a.length;i++){
			for (int j = 0;j<a[i].length;j++){
				StdOut.print(a[i][j]);
			}
			StdOut.println();
		}
	}
	// This method is just here to test the class
	public static void main(String[] args) {
		// write your code here
		int m = 5,n = 6;
		int[][] a = new int[m][n];
		int[][] b = new int[n][m];
		a = rdm(a,10);
		b = mig(a,b);
		prt(a);
		prt(b);
	}
}
