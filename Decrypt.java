import java.math.*;

public class Decrypt {
    

    public int[][] matrizInversa(int [][] x) {
        int det = inversoMultiplicativo(determinante(x,x.length),27);
        int [][] adj= matrizAdjunta(x);
        return productoEscalarInversa(det,adj);
    }

    public int [][] productoEscalarInversa(int det, int [][] x){        
        int f [][] = new int[x.length][x.length];
        for (int i=0;i<x.length ;i++ ) {
            for (int j=0;j<x.length ;j++ ) {
                f[i][j] = x[i][j]*det ; 
            }
        }
        return f;

    }

    public  int[][] matrizCofactores(int[][] x){
        int[][] res = new int[x.length][x.length];
        for(int i=0;i<x.length;i++) {
            for(int j=0;j<x.length;j++) {
                int[][] det=new int[x.length-1][x.length-1];
                int detValor;
                for(int k=0;k<x.length;k++) {
                    if(k!=i) {
                        for(int l=0;l<x.length;l++) {
                            if(l!=j){
                                int indice1=k<i ? k : k-1 ;
                                int indice2=l<j ? l : l-1 ;
                                det[indice1][indice2]=x[k][l];
                            }
                        }
                    }
                }
                detValor=determinante(det,det.length);
                res[i][j]=detValor * (int)Math.pow(-1, i+j+2);
            }
        }
        return res;
    }

    public int [][] matrizTranspuesta(int [][] x){
        int mat[][] = new int[ x.length][x.length];
        for(int i=0; i<x.length; i++){
            for(int j=0; j<x.length; j++)
                mat[i][j]=x[j][i];
        }
        return mat;
    }

        public  int [][] matrizAdjunta(int [][] x){
        return matrizTranspuesta(matrizCofactores(x));
    }

    public int determinante(int [][] mat, int n) { 

        if (n == 1) 
            return mat[0][0]; 

        int res = 0; 
        int signo = 1; 
        int cof[][] = new int[n][n]; 

        for (int f = 0; f < n; f++) { 
            cofactor(mat, cof, 0, f, n); 
            res += signo * mat[0][f] * determinante(cof, n - 1); 
            signo = -signo; 
        } 
    
        return res; 
    } 

    public void cofactor(int [][] mat, int [][] temp, int p, int q, int n) { 
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

    
    public int [] multiplicaRenglonXColumnaINT(int [][] x, int [] vec){
       int m [] = new int [vec.length] ;

       if (x.length==2){
            m[0] = x[0][0]*vec[0] + x[0][1]*vec[1];
            m[1] = x[1][0]*vec[0] + x[1][1]*vec[1];
       } else{

        m[0] = (x[0][0]*vec[0]) + (x[0][1]*vec[1]) + (x[0][2] * vec[2]);
        m[1] = (x[1][0]*vec[0]) + (x[1][1]*vec[1]) + (x[1][2] * vec[2]);
        m[2] = (x[2][0]*vec[0]) + (x[2][1]*vec[1]) + (x[2][2] * vec[2]);

        }

        return m;   

    }

    public void imprimeMatriz(int [][] x){
  
        for (int i=0;i<x.length ;i++) {
            for(int j=0; j<x.length;j++){
                System.out.print("| " + x[i][j] + "");
            }
            System.out.println("|");
            }
    }


    public void imprimeMatrizXColumnaINT(int [] x){
        for (int i=0;i<x.length ;i++ ) {
            System.out.println(" | "+ x[i]+ " | " );
        }

    }

    public int [] moduloVector(int [] x){
        int mat[] = new int [x.length];
        for (int i=0; i<x.length ;i++ ) {
                mat[i] = (x[i] < 0) ? (27 - (Math.abs(x[i]) % 27) ) % 27 : (x[i] % 27);
            
        }
        return mat;
    }

    public int [][] moduloMatriz(int [][] x ){
        int mat[][] = new int [x.length][x.length];
        for (int i=0; i<x.length ;i++ ) {
            for (int j=0;j<x.length ;j++ ) {
                mat[i][j] = (x[i][j] < 0) ? (27 - (Math.abs(x[i][j]) % 27) ) % 27 : (x[i][j] % 27);
            }
        }
        return mat;
    }

    public int inversoMultiplicativo(int a, int n) { 
        a = a % n; 
        for (int x = 1; x < n; x++) 
           if ((a * x) % n == 1) 
              return x; 
        return 1; 
    } 
    
    public  static void main(String[] args) {
        Decrypt i = new Decrypt();
        int mat [][] = {{5,15,18},{20,0,11},{4,26,0}};
        int vec1 [] = {10,21,20};
        int vec2 [] = {14,15,1};
Fraccion f = new Fraccion(1,i.determinante(mat,mat.length));
        System.out.println("LLave");
        i.imprimeMatriz(mat);
System.out.println();
        System.out.println("Determiante");
        System.out.println(i.determinante(mat,mat.length));
System.out.println("Inverso multiplicativo del determinante ");
System.out.println(i.inversoMultiplicativo(i.determinante(mat,mat.length),27));
System.out.println();
        System.out.println("Matriz adjunta ");
        i.imprimeMatriz(i.matrizAdjunta(mat));
System.out.println();
        System.out.println("inversa multiplicada por el inverso multiplicativo: "+ i.inversoMultiplicativo(i.determinante(mat,mat.length),27));
        i.imprimeMatriz(i.matrizInversa(mat));
System.out.println();
System.out.println("matriz con modulo 27");
i.imprimeMatriz(i.moduloMatriz(i.matrizInversa(mat)));

i.imprimeMatrizXColumnaINT(i.multiplicaRenglonXColumnaINT(i.moduloMatriz(i.matrizInversa(mat)),vec1));
i.imprimeMatrizXColumnaINT(i.moduloVector(i.multiplicaRenglonXColumnaINT(i.moduloMatriz(i.matrizInversa(mat)),vec1)));


    }

}