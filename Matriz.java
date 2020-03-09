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
Metodo que recibe una matriz de letra  y la transforma en una matriz de enteros
*@param MatrizLetra Matriz de letras
*@return Matriz
*/

public Matriz transformacionNumerica(MatrizLetra mensaje){
  String abecedario="abcdefghijklmnñopqrstuvwxyz";
  char [][] recipiente= mensaje.getMatrizLetra();
  int tam=recipiente.length;
  Matriz transformada = new Matriz(tam);
  int [][] recipienteTran= transformada.getMatriz();
  char letra=' ';
  int posicion=0;
  for (int i=0;i<recipiente.length ;i++ ) {
    for (int j=0;j<recipiente[i].length ; j++) {
      letra=recipiente[i][j];
      posicion=abecedario.lastIndexOf(letra);
      recipienteTran[i][j]=posicion;
    }
  }
  transformada.setMatriz(recipienteTran);
  return transformada;
}



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

}//productoEscalar

/**
Metodo que nos permite saca el determinante de una matrizes
*/
public static double determinante(double[][] matriz){
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
  }//determinante
  /**
  Metodo auxiliar que suma los valores de un vector automaticamente
  *@param int[] x
  *@return int
  */
  private int sumaDevector(int [] x){
    int nuevo=0;
      for (int i=0;i<x.length ;i++) {
        nuevo+=x[i];
      }
    return nuevo;
  }

  /**
  Metodo auxiliar que muliplica 2 vectores, siempre y cuando los 2 vectores sea
  del mismo tamaño
  */

  private int[] multVectores(int [] vector1, int vector2[]){
    int[] vectorFinal=new int[vector1.length];
      for (int i=0;i<vector1.length ;i++) {
        vectorFinal[i]=vector1[i]*vector2[i];
      }
      return vectorFinal;
  }

  /**
  Metodo que devuelve un arreglo de operaciones , recibe una matriz, y el vector
  por el que se va a multiplicar

  */
  public int[] multiplicaMAtrices(int[] vector, Matriz matriz){
        int tamVector=vector.length;
        int [] vectorResultante= new int [tamVector] ;
        int[][] matrizNumerica= matriz.getMatriz();
        int numeroMultiplicar=0;
        int [] vectorAuxiliar= new int[tamVector];
        for (int i=0;i<matrizNumerica.length;i++ ) {
          for (int j=0;j<matrizNumerica[i].length ;j++ ) {
              numeroMultiplicar=matrizNumerica[i][j];
              vectorAuxiliar[j]=numeroMultiplicar;
          }
          vectorResultante[i]=sumaDevector(multVectores(vector,vectorAuxiliar));
        }

        return vectorResultante;
  }



//Metodos get  y set
  public int[][] getMatriz(){
    return tamMatriz;
  }

  public  void setMatriz(int[][] x){
      tamMatriz=x;
  }
  //Metodo Main
  public static void main(String[] args) {
    Matriz prueba= new Matriz(2);
    Lector nuevo2=new Lector("Hola");
    String nuevo = "abcdefghijklmnñopqrstuvwxyz";
    char x= 'x';
    //int[] vector1=[1,2,3];

    //int[] esperanza =prueba.multiplicaMAtrices();
    System.out.println(nuevo.lastIndexOf(x));
  }//main

}
