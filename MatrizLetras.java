import java.lang.String;
class MatrizLetra {
  private char [][] matriz;

  public MatrizLetra(int n){
    matriz = new char[n][n];
  }//matrizLetra

  /**
  *Método que nos permite insertar el mensaje en una matriz
  *@param Lector mensaje
  *@return  MatrizLetra
  */
  public MatrizLetra rellenaMatrizLetra(Lector nuevo){
   String mensaje= nuevo.getMensaje();
   int mensajeTam= nuevo.longitudTexto();
   MatrizLetra estructura = new MatrizLetra(mensajeTam);
   int contador=0;
   char posicion='a';
   char [][] insercion = new char[mensajeTam][mensajeTam];
   for (int i=0;i<estructura.getMatrizLetra().length ;i++ ) {
      for (int j=0;j<estructura.getMatrizLetra()[i].length ;j++ ) {

        posicion= mensaje.charAt(((i*mensajeTam) +j) );

        insercion[i][j]=posicion;
      }
   }
   estructura.setMatrizLetra(insercion);
   return estructura;
 }//RellenaMatriz

  // Sirve para ver la matriz
  public void imprimeMatrizLetra(){
    char[][] matriz=this.getMatrizLetra();
    for (int i=0;i<matriz.length ;i++ ) {
      for (int j=0;j < matriz[i].length ;j++ ) {
        System.out.print("|" + matriz[i][j] + "|");
      }
      System.out.println("");
    }
  }//imprimeMatrizLetra


  //  Metodos get y set
  public char[][] getMatrizLetra(){
    return  matriz;
  }

  public void setMatrizLetra(char [][] x){
      matriz=x;
  }
}
