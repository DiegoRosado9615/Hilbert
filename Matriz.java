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
Metodo Auxiliar que sirve para cncctenar 2 arreglos numericos
para poder devolver un areglo de numeros
**/
public int[] juntaAreglos(int[] x1 , int [] x2){
    int longitudArr1=x1.length;
    int longitudArr2=x2.length;
    int contador=0;
    int[] arregloFinal=new  int[longitudArr1+longitudArr2];
    for (int i=0;i<longitudArr1 ;i++ ) {
        arregloFinal[i]=x1[i];
    }
    for (int i=longitudArr1; i< (longitudArr2+longitudArr1) ;i++ ) {
        arregloFinal[i]=x2[contador];
        contador++;
    }
    return arregloFinal;
}
/**
Metodo con el que se hace el producto escalar recibe el escalar por el cual
se va multiplicar
@param Entero y
@return Matriz
*/


public int[] productoEscalar(int x,int tam, Matriz codificacion){
  int [] matriz1=codificacion.getMatriz()[0];
  int [] matriz2=codificacion.getMatriz()[1];
  int producto=0;
  int [] vectorNumerico=new int[tam];
  int [] vectorFaltante  = new int [tam];
  int[] vectorFinal=new int[1];
  for (int i=0;i<matriz1.length ;i++ ) {

    vectorNumerico[i]=matriz1[i]*x;
  }
  for (int i=0;i<matriz2.length ;i++ ) {
    vectorFaltante[i]=matriz2[i]*x;
  }

  vectorFinal=juntaAreglos(vectorNumerico,vectorFaltante);
  vectorInt(vectorFinal);
  return vectorFinal;
}//productoEscalar

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
  }//determinante


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


  /*
  metodo auxiliar que me permite con la multiplicar un vector
  con un
  */
  private int convierteTuplasEnteros(int[]  codf, int[] clave){
    int def=0;
    int escalar=0;
    int aux[] = new int [codf.length];
    for (int i=0;i<clave.length-1 ;i++ ) {

      aux=multVectores(codf,clave);


      escalar=sumaDevector(aux);
      def=escalar;
    }
    return def;
  }

  /**
  Metodo que devuelve un arreglo de operaciones , recibe una matriz, y el vector
  por el que se va a multiplicar
  */
  public int[][] multiplicaMAtrices(int[][] vectores, Matriz matriz){
      int [][]vectorResultante= new int [vectores.length][vectores.length];
      int [] []clave=matriz.getMatriz();
      int [] m= new int [clave.length];
      int nuevo =0;
      for (int i=0;i<vectores.length ;i++ ) {
        for (int j=0;j<clave.length ;j++ ) {
          nuevo= convierteTuplasEnteros(vectores[i],clave[j]);
          m[j]=nuevo;
        }

        vectorResultante[i]=m;

         m= new int [clave.length];
      }
        return vectorResultante;
  }//multiplicaMAtrices

/**
Método que dado un areglo de enteros devuelve su caracter corespondiente en un
el abecedario español
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
  }//convertidorChar


  public void codificacionVarChar(int [] [] x) {
    char mt [][]= new char[x.length][x.length];
      for (int i=0;i<x.length ;i++ ) {
        System.out.println("M  de " + i + " Codificada es  ");
        mt[i]=convertidorChar(x[i]);
        vectorChar(mt[i]);
      }

  }
  /**
  Metodo que me permite ver los vectores de char
  */
public static void vectorChar(char[] x){
    for (int i=0;i<x.length ;i++ ) {


      System.out.print("| " + x[i] + "|");
    }
    System.out.println("");

}


public void vectorInt(int [] x){
  for (int i=0;i<x.length ;i++ ) {
    System.out.print("| " + x[i] + "|");
  }
  System.out.println("");


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
    int [] vectorNumerico = {26,2,3};
    //char [] vectorChar =['a','b','c']
    vectorChar(prueba.convertidorChar(vectorNumerico));
  }//main

}
//mexicas
