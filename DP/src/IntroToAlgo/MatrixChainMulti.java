package IntroToAlgo;

import java.util.ArrayList;

class matrix {
	
	int rows;
	int cols;
	public matrix(int rows, int cols) {
		this.rows = rows;
		this.cols = cols;
	}
	int matrix [][] = new int[rows][cols];
}

public class MatrixChainMulti {
	

	public static void main(String[] args) {
		
		// 4x6 MATRIX
		int [][] A = {{1,5,9,7,3,4},
				      {2,1,9,7,2,6},
				      {9,5,2,2,3,5},
				      {6,6,1,3,1,7}};
		
		// 6x3 MATRIX
		int [][] B = {{5,1,3},
					  {9,5,1},
					   {8,7,6},
					   {9,6,8},
					   	{8,1,3},
					   	{2,2,9}};

		// total 72 # of multiplications b/c 4*6*3
		int [][] result = matrixMultiply(A,B);
		
		matrix A1 = new matrix(3,2);
		matrix A2 = new matrix(2,4);
		matrix A3 = new matrix(4,2);
		matrix A4 = new matrix(2,5);
		
		matrix [] list = new matrix[] {A1,A2,A3,A4};
		//matrixChainOrder(new int[]{5,4,6,2,7});
		ArrayList<int [][]> output = matrixChainOrder(new int[]{3,2,4,2,5});
		display(output.get(0));
	//	display(output.get(1));

	}
	
	
	public static ArrayList<int[][]> matrixChainOrder(int[] p ) {
		
		int n = p.length;
		int [][] m = new int[n][n];
		int [][] s = new int[n-1][n];    // need one less row
		int q; 
		
		for(int i = 1; i < n; i++) {
			m[i][i] = 0;
		}
		
		
		for(int L =2; L < n; L++) {				// L=2
			for(int i = 1; i < n-L +1; i++) {	// i=1
				
				int j = i + L -1;			// j = 2
			//	if (j == n) continue; System.out.println("here"); why do i need this
				
				m[i][j] = Integer.MAX_VALUE; 
				
				for(int k = i; k <= j-1; k++ ) {	// 1 <= 1
					q = m[i][k] + m[k+1][j] + p[i-1] * p[k] * p[j];
					if(q < m[i][j] ) {
						m[i][j] = q;
						s[i][j] = k;
					}
				}
			}
		}

		ArrayList<int [][]> result = new ArrayList<>();
		result.add(m);
		result.add(s);
		return result;
	}
	
	/**
	 * We can multiply two matrices A and B iff they are A.cols == B.rows
	 * 
	 * @param A
	 * @param B
	 * @return
	 */
	public static int [][] matrixMultiply(int [][] A, int [][] B) {
		
		// if A.cols != B.rows
		if(A[0].length != B.length) {
			System.out.println("incompatiable dimenstions");
			return null;
		}
		int A_rows = A.length;
		int B_cols = B[0].length;
		int [][] C = new int[A_rows][B_cols];
		
		for(int i = 0; i < A_rows; i++) {
			for(int j = 0; j <  B_cols; j++) {
				C[i][j] = 0;
				for(int k = 0; k < A[0].length; k++) {
					C[i][j] = C[i][j] + A[i][k] * B[k][j];
				}
			}
		}	
		return C;
	}
	
	public static void display(int A [][]) {
		System.out.println("---------------");
		for(int i = 0; i < A.length; i++) {
			for (int j = 0; j < A[i].length; j++) {
				System.out.print(A[i][j] +" ");
			}
			System.out.println();
		}
		System.out.println("---------------");
	}
}
