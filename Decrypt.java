import java.math.*;
import java.util.ArrayList;

public class Decrypt {
    
    private int [][] mat ;
    private int [][] vec ;  
    private ArrayList<int []> vectores = new ArrayList<int []>();
    private ArrayList<int []> vectoresModulo = new ArrayList<int []>();
    public Decrypt (int [][] mat, int[][] vec){
        this.mat = mat;
        this.vec = vec;
    }

    public int [][] getM() {
        return this.mat;
    }

    /**
    *    Método que regresa la matriz inversa de una matriz M
    *    @param x La Matriz a la que se le desea obtener su inversa    
    *    @return la matriz inversa de x
    **/
   
    public int[][] matrizInversa(int [][] x) {
        int det = inversoMultiplicativo(determinante(x),27);
        int [][] adj= matrizAdjunta(x);
        return productoEscalar(det,adj);
    }
    /**
    *   Método que aplica el producto escalar a la matriz 
    *   @param v el determiante de la matriz inversa
    *   @param x la matriz a la que se le multiplicara entrada por entrada el valor v 
    *   @return la matriz inversa multiplicada por el determinate (inverso multiplicativo)
    *
    */

    public int [][] productoEscalar(int v, int [][] x){        
        int f [][] = new int[x.length][x.length];
        for (int i=0;i<x.length ;i++ ) {
            for (int j=0;j<x.length ;j++ ) {
                f[i][j] = v*x[i][j]; 
            }
        }
        return f;
    }

    /**
    *   Método que obtiene los cofactores de una matriz X 
    *   @param x la matriz a la que se le desea obtener sus cofactores
    *   @return una matriz con los cofactores de X
    *
    */

    public int[][] cofactores(int[][] x){
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
                detValor=determinante(det);
                res[i][j]=detValor*(int)Math.pow(-1, i+j);
            }
        }
        return res;
    }

    /**
    *   Método que transforma una matriz M a su transpuesta   
    *   @param x la matriz a la que se le desea sacar su transpuesta
    *   @return M^T la matriz transpuesta de M.
    *
    */

    public int [][] transpuesta(int [][] x){
        int mat[][] = new int[ x.length][x.length];
        for(int i=0; i<x.length; i++){
            for(int j=0; j<x.length; j++)
                mat[i][j]=x[j][i];
        }
        return mat;
    }


    public int [][] transpuestaNxM(int [][] x){
        int mat[][] = new int[x[0].length][x.length];
        for(int i=0; i<x[0].length; i++){
            for(int j=0; j<x.length; j++)
                mat[i][j]=x[j][i];
        }
        return mat;
    }
    /**
    *   Método que regresa una matriz adjunta
    *   @param x la matriz a la que se le desae obtener su adjunta
    *   @return una matriz adjunta
    */

        public  int [][] matrizAdjunta(int [][] x){
        return transpuesta(cofactores(x));
    }

    /**
    *   Método que calcula el determinante de una matriz 
    *   @param x la matriz a la que se le desea obtener su determianate
    *   @return el determiante de la matriz 
    */

    public int determinante(int [][] x){
        int det = 0;
        if (x.length==2){
            det = (x[0][0]*x[1][1]) - (x[0][1]*x[1][0]);
        }else{
            det = ((x[0][0])*(x[1][1])*(x[2][2])+(x[1][0])*(x[2][1])*(x[0][2])+(x[2][0])*(x[0][1])*(x[1][2]))-((x[2][0])*(x[1][1])*(x[0][2])+(x[1][0])*(x[0][1])*(x[2][2])+(x[0][0])*(x[2][1])*(x[1][2]));
        }
        return det;
    }


    public void aplicaModuloVectores(){

        for (int i=0;i<this.vectores.size();i++ ) {

            int [] nwVec = this.vectores.get(i);
            int [] nwVec2 = moduloVector(nwVec);
            this.vectoresModulo.add(nwVec2);
            
        }

    }


    /**
    *   Método que aplica modulo a un vector 
    *   @param x un vector 
    *   @return un vector al que s ele aplico modulo 27 
    */


    public int [] moduloVector(int [] x){
        int mat[] = new int [x.length];
        for (int i=0; i<x.length ;i++ ) {
                mat[i] = x[i] % 27; 
        }
        return mat;
    }
    
    /**
    *   Método que aplica modulo a una matriz
    *   @param x la amtriz a la que se le aplicara el modulo 27
    *   @return una matriz aplicada con modulo 27
    */

    public int [][] moduloMatriz(int [][] x){
        int mat[][] = new int [x.length][x.length];
        for (int i=0; i<x.length ;i++ ) {
            for (int j=0;j<x.length ;j++ ) {
                mat[i][j] = (x[i][j] < 0) ? (27 - (Math.abs(x[i][j]) % 27))%27 : (x[i][j] % 27);
            }
        }
        return mat;
    }

    /**
    *   Método que regresa el inverso multiplicativo.
    *   @param a el numero al que se le desea obtener su inverso multiplicativo.
    *   @param n el modulo.
    *   @return el inverso multiplicativo de a mod n
    */

    public int inversoMultiplicativo(int a, int n) { 
        a %= n; 
        for (int i = 1; i < n; i++) 
           if ((a * i) % n == 1) 
              return i; 
        return 1; 
    } 

    /**
    *   Método que imprime una matriz
    *   @param x la latriz que se desea imprimir
    *
    */

    public String imprimeMatriz(int [][] x){
    String cad ="";
        for (int i=0;i<x.length;i++) {
            for(int j=0; j<x.length;j++){
                cad += "| " + x[i][j] + "";
            }
            cad += "|\n";
            }
            return cad;
    }

    /**
    *   Método que imprime un vector
    *   @param x el vector que se desea imprimir
    *   
    */

    public String vector(int [] x){
        String cad ="";
        for (int i=0;i<x.length ;i++ ) {
            cad +="|"+ x[i]+ "|\n" ;
        } 


        return cad ;

    }


    public static int[][] aEentero(Matriz mat){
        return mat.getMatriz();
    }

    public static int[][] nxm(int[][] x){

        int [][] mat = new int [x[0].length][x.length]; 
            
        for (int i=0;i<x[0].length ;i++ ) {
            for (int j= 0;j<x.length ;j++ ) {
                mat[i][j] = x[i][j];
            }
        }

        return mat ;

    }

    public String imprimeNXM(int [][] x){
        String cad = "";
        for (int i=0;i<x.length ;i++ ) {
            for (int j= 0;j<x[0].length ;j++ ) {
                cad += "|"+x[i][j]+"";
            }
            cad += "|\n";
        }
                
        return cad;

    }


    public String decrypt(){
        String cad = "";
        cad += "LLave: \n\n";
        cad += this.imprimeMatriz(this.mat);
        cad += "\n\n";
        cad += "Determinante: " + this.determinante(this.mat);
        cad += "\n\n";
        cad += "Inverso multiplicativo de "+ this.determinante(this.mat) +" es: " +this.inversoMultiplicativo(determinante(this.mat),27)+"\n\n";
        cad += "Matriz Adjunta: \n";
        cad += this.imprimeMatriz(this.matrizAdjunta(this.mat))+"\n\n";
        cad += "Adjunta multiplicada por el inverso multiplicativo o sea:  \n";
        cad += "\nMatriz inversa: \n";
        cad += this.imprimeMatriz(this.matrizInversa(this.mat));
        cad += "\n\n";
        cad += "Matriz inversa mod 27\n\n";
        cad += this.imprimeMatriz(this.moduloMatriz(this.matrizInversa(mat)))+"\n\n";
        cad += "Vectores encriptados\n";
        cad += this.imprimeNXM(this.transpuestaNxM(this.vec))+"\n";
        cad += "Vectores multiplicados por la matriz inversa \n";
        cad += this.regresaListaVectoresSinModulo()+"\n";
        aplicaModuloVectores();
        cad += "Vectores resultantes a los que se les aplico modulo 27\n";
        cad += this.regresaListaVectoresConModulo()+"\n";

    return cad;

    }

    public String regresaListaVectoresSinModulo(){
        
        String cad = "";
        this.multiplicaMxVecI(this.moduloMatriz(this.matrizInversa(this.mat)),this.vec);

        for (int i=0;i<this.vectores.size();i++) {
        
            cad += this.vector(this.vectores.get(i))+"\n";
        
        }
        return cad;

    }


    public String regresaListaVectoresConModulo(){
        
        String cad = "";

        for (int i=0;i<this.vectores.size();i++) {
        
            cad += this.vector(this.vectoresModulo.get(i))+"\n";
        
        }
        return cad;
    }

        /**
    *   Método que multiplica cada renglon de una matriz, por cada una de las entradas de un vector
    *   @param x la matriz 
    *   @param vec el vector
    *   @return un vector que resulta de la multiplicacion de x y vec   
    *
    */

    public int [] multiplicaRenglonXColumna(int [][] x, int [] vec){
       int m [] = new int [vec.length] ;

       if (x.length==2){
            m[0] = x[0][0]*vec[0] + x[0][1]*vec[1];
            m[1] = x[1][0]*vec[0] + x[1][1]*vec[1];
       } else if (x.length==3) {
        m[0] = (x[0][0]*vec[0]) + (x[0][1]*vec[1]) + (x[0][2] * vec[2]);
        m[1] = (x[1][0]*vec[0]) + (x[1][1]*vec[1]) + (x[1][2] * vec[2]);
        m[2] = (x[2][0]*vec[0]) + (x[2][1]*vec[1]) + (x[2][2] * vec[2]);

        }

        return m;   

    }

    public void multiplicaMxVecI(int [][] x, int [][] vec) {
        
        for (int j=0;j<vec.length ;j++ ) { 
            int [] m = this.multiplicaRenglonXColumna(this.moduloMatriz(this.matrizInversa(mat)),this.creaArregloNx1(this.vec,j));
            this.vectores.add(m);
        }

    }

    public int [] creaArregloNx1(int [][] x, int j){

        int [] vec = new int[x[0].length];
        x = this.transpuestaNxM(x);
        for (int i=0;i<x.length ;i++ ) {
            vec[i]=x[i][j];
        }
        
    return vec;        
        
    }


    
    public  static void main(String[] args) {
        int mat [][] = {{5,15,18},{20,0,11},{4,26,0}};
        int vec1 [][] = {{10,21,20},{14,15,1}};

        Decrypt i = new Decrypt(mat,vec1);
        
        System.out.println(i.decrypt());

        

    }

}

        /*
           Pongan esto en Principal.java
          Decrypt decrypt = new Decrypt(Decrypt.aEentero(numeros),formaNumero);
          System.out.println(decrypt.decrypt());
          */
