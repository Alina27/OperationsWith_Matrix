import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ThreadMatrix {
	
	public static int a[][];
	public static int b[][];
	public static int c[][];
	
	
	public int[][] readMatrixA(int N, File file1) throws IOException{
		
		a = new int[N][N];
		
		BufferedReader br = new BufferedReader(new FileReader(file1));
		
		for(int i = 0; i < N; i++){
			String[] str = br.readLine().trim().split(" ");
			for(int j = 0; j < N; j++){
				a[i][j] = Integer.parseInt(str[j]); 
			}
		}
		return a;
	}
	
 public int[][] readMatrixB(int N, File file1) throws IOException{	
		BufferedReader br = new BufferedReader(new FileReader(file1));
		
		b = new int[N][N];
		
		for(int i = 0; i < N; i++){
			String[] str = br.readLine().trim().split(" ");
			for(int j = 0; j < N; j++){
				b[i][j] = Integer.parseInt(str[j]); 
			}
		}
		return b;
	}

 public void printMatrix(int[][] array){
	  
	  for(int i = 0; i < array.length; i++){
		  for(int j = 0; j < array.length; j++){
			  System.out.print(array[i][j] + " ");
		  }
		  System.out.println();
	  }  
  }
 
 public static void main(String[] args) throws IOException, InterruptedException {
	
		Stopwatch timer1 = new Stopwatch();
		
		File a_5 = new File("a_5.txt");
		File b_5 = new File("b_5.txt");
		
		File a_30 = new File("a_30.txt");
		File b_30 = new File("b_30.txt");
		
		File a_200 = new File("a_200.txt");
		File b_200 = new File("b_200.txt");
		
		File a_700 = new File("a_700.txt");
		File b_700 = new File("b_700.txt");
		
		SImpleMatrixMultiply simple = new SImpleMatrixMultiply();
		
		int[][] matrixA_200 = simple.readMatrix(700,a_700);
		int[][] matrixB_200 = simple.readMatrix(700, b_700);
		int[][] res = simple.matrixMultiply(matrixA_200, matrixB_200);
		
		System.out.println("Simple multiplicationn of matrix 700 x 700: " + timer1.elapsedTime());
        //simple.printMatrix(res);
		
		ThreadMatrix thread = new ThreadMatrix();
		
		Stopwatch timer2 = new Stopwatch();
		
		a = thread.readMatrixA(700, a_700);
		b = thread.readMatrixB(700, b_700);
		//int c[][] = new int[a.length-1][a.length-1];
		c = new int[a.length][a.length];
		
		FirstThread t1 = new FirstThread();
	    SecondThread t2 = new SecondThread();
	    
	    t1.start();
	    t2.start();
	    
	    t1.join();
	    t2.join(); 
	    
	    System.out.println("Multiply matrix 700 x 700 with threads took: " + timer2.elapsedTime());
	    //thread.printMatrix(c);
	}

}
