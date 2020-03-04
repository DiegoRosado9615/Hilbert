import java.util.Scanner;
public class Matriz{
  int [][] tamMatriz;
/**
Recibe un entero que sera el tamanho de la
matriz solo se crean matrizes cuadradas
*/
  public Matriz(int n){
      tamMatriz=new int[n][n];
  }

/**
Metodo con el que rellenas una matriz
*/
public void rellenaMatriz(){
  int[][] matriz= this.getMatriz();
  int columna=0;
  int fila=0;
  Scanner sc= new Scanner(System.in);
  for (int i=0;i<matriz.length ; i++ ) {
      for (int j=0;j<matriz[i].length;j++ ) {
      fila=sc.nextInt();
      matriz[i][j]=fila;
      }
  }

}//rellenaMatriz

/**
Metodo que imprime las matrizes
*/
public void imprimeMatriz(){
  int nueva[][]=this.getMatriz();
  for (int i=0;i<nueva.length ;i++) {
    for(int j=0; j<nueva[i].length;j++){
      System.out.print("| " + nueva[i][j] + "|");
    }
    System.out.println("");
  }
}//imprimeMatriz

/**
Metodo con el que se hace el producto escalar recibe el escalar por el cual
se va multiplicar
@param Entero y
@return Matriz
*/
public void productoEscalar(int x){
  int [][] matriz=this.getMatriz();
  int producto=0;
  for (int i=0;i<matriz.length ;i++ ) {
    for (int j=0;j<matriz[i].length ;j++) {
      producto=matriz[i][j]*x;
      matriz[i][j]=producto;
    }
  }
}

/**
Metodo que nos permite saca el determinante de una matrizes
**/
public static double determinante(double[][] matriz)
{
    double det=0;
    if(matriz.length==2)
    {
        det=(matriz[0][0]*matriz[1][1])-(matriz[1][0]*matriz[0][1]);
        return det;
    }
    double suma=0;
    for(int i=0; i<matriz.length; i++){
    double[][] nm=new double[matriz.length-1][matriz.length-1];
        for(int j=0; j<matriz.length; j++){
            if(j!=i){
                for(int k=1; k<matriz.length; k++){
                int indice=-1;
                if(j<i)
                indice=j;
                else if(j>i)
                indice=j-1;
                nm[indice][k-1]=matriz[j][k];
                }
            }

        }
        if(i%2==0)
        suma+=matriz[i][0] * determinante(nm);
        else
        suma-=matriz[i][0] * determinante(nm);
    }
    return  det;
  }

//Metodos get  y set
public int[][] getMatriz(){
  return tamMatriz;
}

public  void setMatriz(int[][] x){
    tamMatriz=x;
}
public static void main(String[] args) {
  Matriz prueba= new Matriz(2);
  prueba.rellenaMatriz();
  prueba.productoEscalar(2);
  prueba.imprimeMatriz();
}

}
