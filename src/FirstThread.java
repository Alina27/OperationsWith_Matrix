
public class FirstThread extends Thread{
	
	int[][] a = ThreadMatrix.a;
	int[][] b = ThreadMatrix.b;
	int[][] c = ThreadMatrix.c;
	
	public void run(){
		
		int m = a.length;
		int n = b[0].length;
		int k = a.length/2;
		
		for(int i = 0; i <= k; i++){
			for(int j = 0; j < n; j++){
				for(int l = 0; l < b.length; l++){
					c[i][j] = c[i][j]+a[i][l]*b[l][j];
				}
			}
		}
	} 
	
}
