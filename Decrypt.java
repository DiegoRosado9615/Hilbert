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
    /**
    *   Método que aplica el modulo a un vector y lo agrega a una lista
    *
    */
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
    /**
    *   Método que imprime un vector de Caracteres
    *   @param x un vector
    *   @return una cadena con el vector de Caracteres.
    */
    public String vectorChar(char [] x){
        String cad ="";
        for (int i=0;i<x.length ;i++ ) {
            cad +="|"+ x[i]+ "|\n" ;
        } 
        return cad ;

    }

    /**
    *   Método que "cambia" un objeto Matriz a un arreglo bidimensional
    *   @param mat La instancia de la clase Matriz
    *   @return un arreglo bidimensional
    */
    public static int[][] aEentero(Matriz mat){
        return mat.getMatriz();
    }

    /**
    *   Método que imprime una matriz de N x M ayuda a vizualizar una matriz de N x M
    *   @param x una matriz de N x M
    *   @return una cadena con el arreglo bidimensional
    *
    */
    public String imprimeNxM(int [][] x){
        String cad = "";
        for (int i=0;i<x.length ;i++ ) {
            for (int j= 0;j<x[0].length ;j++ ) {
                cad += "|"+x[i][j]+"";
            }
            cad += "|\n";
        }
                
        return cad;

    }

    /**
    *   Método que "realiza todas las operaciones para obtener el desencriptado"
    *   @return una cadena con todas las operaciones para obtener la desencriptación.
    *
    */

    public String decrypt(){
        String cad = "";
        cad += "\n\nLLave: \n\n";
        cad += this.imprimeMatriz(this.mat);
        cad += "\n\n";
        mensajeDetermianteEs0();
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
        cad += "Vectores encriptados de forma transpuesta\n";
        cad += this.imprimeNxM(this.transpuestaNxM(this.vec))+"\n";
        cad += "Vectores multiplicados por la matriz inversa \n";
        cad += this.regresaListaVectoresSinModulo()+"\n";
        cad += "Vectores resultantes a los que se les aplico modulo 27\n";
        aplicaModuloVectores();
        cad += this.regresaListaVectoresConModulo()+"\n";
        cad += "Mensaje claro:\n\n";
        cad += this.listaVectoresAchar()+"\n";

    return cad;

    }

    /**
    *   Método que regresa una lista de vectores, en especial a los que no se les a aplicado el modulo
    *   @return una cadena con los vectores dentro de una lista que contiene vecotres sin modulo aplicado
    *
    */
    public String regresaListaVectoresSinModulo(){
        
        String cad = "";
        this.multiplicaMxVecI(this.moduloMatriz(this.matrizInversa(this.mat)),this.vec);

        for (int i=0;i<this.vectores.size();i++) {
        
            cad += this.vector(this.vectores.get(i))+"\n";
        
        }
        return cad;

    }

    /**
    *   Método que regresa una lista de vectores, en especial a los que se les a aplicado el modulo
    *   @return una cadena con los vectores dentro de una lista que contiene vecotres con modulo aplicado   
    *
    */

    public String regresaListaVectoresConModulo(){
        
        String cad = "";
        for (int i=0;i<this.vectoresModulo.size();i++) {
        
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

    /**
    *   Método que multiplica una matriz por una matriz, solo que se aplica el poducto de matriz por renglon
    *   @param x la matriz principal(la inversa)
    *   @param vec una matriz de vectores
    *
    */

    public void multiplicaMxVecI(int [][] x, int [][] vec) {
        
        for (int j=0;j<vec.length ;j++ ) { 
            int [] m = this.multiplicaRenglonXColumna(this.moduloMatriz(this.matrizInversa(mat)),this.creaArregloNx1(this.vec,j));
            this.vectores.add(m);
        }

    }

    /**
    *   Método que crea un arreglo de N x 1 a partir de una matriz bidimensinal. 
    *   Crea columnas a partir de hacerla transpuesta 
    *   @param x una matriz
    *   @param j un indice de columna
    *   @return un vector (la columna j)
    *
    */

    public int [] creaArregloNx1(int [][] x, int j){

        int [] vec = new int[x[0].length];
        x = this.transpuestaNxM(x);
        for (int i=0;i<x.length ;i++ ) {
            vec[i]=x[i][j];
        }
        
    return vec;        
        
    }

    /**
    *   Método que convierte un vector de enteros en un vector de Caracteres.
    *   @param x un vector de enteros
    *   @return un vector de caracteres.
    */

    public char[] convertidorChar(int [] x){
        char[] vectorLetras = new char [x.length];
        char letra=' ';
        String abecedario="abcdefghijklmnñopqrstuvwxyz";
    for (int i=0;i<x.length ;i++ ) {
        letra=abecedario.charAt((x[i]%27));
        vectorLetras[i]=letra;
    }
        return vectorLetras;
    }

    /**
    *   Método que imprime una lista de vectores de caracteres
    *   @return una cadena con una lista de vectores de caracteres.
    *
    */

    public String listaVectoresAchar(){
        String cad ="";
        for (int i=0;i<this.vectoresModulo.size() ;i++ ) {
            
            cad += this.vectorChar(this.convertidorChar(this.vectoresModulo.get(i))) +"\n";
        }
        return cad ;
    }


    /**
    *   Método que manda un mensaje si detecta que el determiante es igual a 0
    */
    public void mensajeDetermianteEs0(){
        if (this.determinante(this.mat)==0){
            System.out.println("El determianate es 0");
            System.exit(0);
        }
    }


    
    public  static void main(String[] args) {
        int mat [][] = {{5,15,0},{20,0,0},{4,26,0}};

        int vec1 [][] = {{10,21,20},{14,15,1}};

        Decrypt i = new Decrypt(mat,vec1);
        System.out.println(i.decrypt());

        System.out.println( i.inversoMultiplicativo(0,27));
    }

}

/*
          int [][] mat = Decrypt.aEentero(numeros);
          int [][] vec = codift;

          Decrypt decrypt = new Decrypt(mat,vec);
          System.out.println(decrypt.decrypt());

          */
