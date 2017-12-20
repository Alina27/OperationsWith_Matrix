import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class SImpleMatrixMultiply {

	 public SImpleMatrixMultiply(){}
	  
	public int[][] readMatrix(int k, File file) throws IOException{
		
    int[][] array = new int[k][k];
    BufferedReader br = new BufferedReader(new FileReader(file)); 
		  
	    for(int i = 0; i < k; i++){
		  String[] str = br.readLine().trim().split(" ");
			for(int j = 0; j < k; j++){
				array[i][j] = Integer.parseInt(str[j]);
			}
		  }
		  
		 return array;
	  }
		
	  public void printMatrix(int[][] array){
		  
		  for(int i = 0; i < array.length; i++){
			  for(int j = 0; j < array.length; j++){
				  System.out.print(array[i][j] + " ");
			  }
			  System.out.println();
		  }  
	  }
	 
	  public int[][] matrixMultiply(int[][]arr1,int[][]arr2){
		  
		  int N = arr1.length;
		  
		  int[][]arr3 = new int[N][N];
		  
		  for(int i = 0; i < N; i++){
			  for(int j = 0; j < N; j++){
				  for(int k = 0; k < N; k++){
					  arr3[i][j] += (arr1[i][k] * arr2[k][j]);
				  }
			  }
		  }
		  return arr3;
	  }
}
