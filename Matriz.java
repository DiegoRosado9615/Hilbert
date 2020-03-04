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
