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
  int[][] matriz= this.getMatriz()
  for (int i=0;i<matriz.length ; i++ ) {
      for (int j=0;j<matriz[i].length;j++ ) {

      }
  }

}//rellenaMatriz


//Metodos get  y set
public int[][] getMatriz(){
  return tamMatriz;
}

public  void setMatriz(int[][] x){
    tamMatriz=x;
}

}
