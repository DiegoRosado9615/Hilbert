
public class Det { 

	public void cofactor(int mat[][], int temp[][], int p, int q, int n) { 
		int i = 0, j = 0; 
		for (int reng = 0; reng < n; reng++) { 
			for (int col = 0; col < n; col++) { 
				if (reng != p && col != q) { 
					temp[i][j++] = mat[reng][col]; 
					if (j == n - 1) { 
						j = 0; 
						i++; 
					} 
				} 
			} 
		} 
	} 
	
	public int determinante(int mat[][], int n) { 

		if (n == 1) 
			return mat[0][0]; 

		int res = 0; 
		int signo = 1; 
		int cof[][] = new int[n][n]; 

		for (int f = 0; f < n; f++) { 
			this.cofactor(mat, cof, 0, f, n); 
			res += signo * mat[0][f] * this.determinante(cof, n - 1); 
			signo = -signo; 
		} 
	
		return res; 
	} 

	public static void main (String[] args) { 
		
		Det m = new Det();
		int mat[][] = {{1, 2, 3}, 
					   {4, 5, 6}, 
					   {7, 8, 9}}; 
		System.out.print("Determinante : "+ m.determinante(mat, mat[0].length)+ "\n"); 
		
	} 

} 
