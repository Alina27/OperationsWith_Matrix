import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Random;


public class MatrixGenerator {

    static int[][] a;
	
	public int[][] fillMatrix(int N){
		
		a = new int[N][N];
		Random rand = new Random();
		
		for(int i = 0; i < N; i++){
			for(int j = 0; j < N; j++){
				int r = rand.nextInt()%10;
				a[i][j] = Math.abs(r);
			}
		}
		
		return a;
	} 
	
	public void printArray(int[][] array){
		  
		  for(int i = 0; i < array.length; i++){
			  for(int j = 0; j < array.length; j++){
				  System.out.print(array[i][j] + " ");
			  }
			  System.out.println();
		  }  
	  }
	
	
	public void writeToFile(int a[][], String filename) throws FileNotFoundException{
		PrintWriter pw = new PrintWriter(new FileOutputStream(filename));
		int rows = a.length;
		int cols = a[0].length;
		pw.println(rows + "\t" + cols);
		for(int i = 0; i < rows; i++){
			for (int j = 0; j < cols; j++){
				pw.print(a[i][j] + " ");
			}
			pw.println();
		}
		pw.close();
	}

	public static void main(String[] args) throws FileNotFoundException {
		
		MatrixGenerator generator = new MatrixGenerator();
		// 5x5
		generator.fillMatrix(5);
		generator.writeToFile(a,"a_5.txt");
		generator.fillMatrix(5);
		generator.writeToFile(a,"b_5.txt");
		
		//30x30
		generator.fillMatrix(30);
		generator.writeToFile(a,"a_30.txt");
		generator.fillMatrix(30);
		generator.writeToFile(a,"b_30.txt");
		
		//200x200
		generator.fillMatrix(200);
		generator.writeToFile(a,"a_200.txt");
		generator.fillMatrix(200);
		generator.writeToFile(a,"b_200.txt");
		
		//700x700
		generator.fillMatrix(700);
		generator.writeToFile(a,"a_700.txt");
		generator.fillMatrix(700);
		generator.writeToFile(a,"b_700.txt");
        
	}

}
