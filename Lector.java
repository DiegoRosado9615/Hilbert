import java.math.*;
 class Lector {
  private String mensaje;
  public Lector(String x){
    mensaje=x;
  }

  /**
  Método auxiliar que me permite decidir si un número es primo
  o no, recibe el número que queremos saber si es primo.
  @param int x
  @return boolean
  */
  public static boolean esPrimo(int x){
    int contador=0;
    if(x==2) return true;
    if(x%2==0) return false;
      for (int i=3;i<x ;i++ ) {
        if((x%i)==0)  return false;
        contador ++;
      }

    return true;
  }
  /**
  Método que nos dice si se puede colocar el mensaje en una matriz n*n
  */
  public boolean sepuedeColocarMatriz(){
    String mensaje = this.getMensaje();
    int longitud= mensaje.length();
    int tamMatriz=0;
    double numero=Math.sqrt(longitud);
    Integer sinDecimal=(int)Math.round(numero);
    double esIgual= sinDecimal.doubleValue();
    boolean prueba= esIgual==numero;
    if(esPrimo(longitud)) return false;
    if(prueba) return true;
    return  false;
  }

  /**
  */
  public int longitudTexto(){
    int largo=this.getMensaje().length();
    double raiz =Math.sqrt(largo);
    return (int) raiz;
  }

  /**
  Metodo auxiliar privado que hace que si nuestro mensaje no es de una longitud esperada
  lo rellena con
  **/
  private  String completaTexto(String mensaje , int y){
    int nueva=mensaje.length();
    double cadena= (double) nueva/y;
    boolean estaCompleta= (cadena%1 ==0);
    while(!estaCompleta){
      mensaje+="#";
      nueva=mensaje.length();
      cadena= (double) nueva/y;
      estaCompleta= (cadena%1 ==0);
    }
    return  mensaje;
  }//completaTexto
  /**
  *Metodo que te permite separar el mensaje que se va a  separar en subcadenas,
  *recibe la cadena a dividir y el numero de el tamaño de los substring
  *devuelve un areglo de String con todos  los substring
  */
  public String [] subArreglos(String mensaje, int tam){
    int longmen= mensaje.length();
    int tamArreglo= Math.round(longmen/tam);
    double operacion=(double)longmen/tam;
    String subMensaje="";
    String[] divicionArreglos=null;
    int contador=0;
    int tamIn=0;
    int j=0;
    if( (operacion)%1 ==0){
      divicionArreglos= new String[tamArreglo];
    }else{
      mensaje=completaTexto(mensaje,tam);
      divicionArreglos=new String[tamArreglo+1];
    }
    for (int i=0;i<divicionArreglos.length;i++) {
      j=tamIn+tam;
      subMensaje=mensaje.substring(tamIn,j);
      tamIn=tamIn+tam;
      divicionArreglos[contador]=subMensaje;
      contador++;
    }

    return divicionArreglos;
  }//subArreglos

  /**
  Metodo que recibe una cadena de String y la convierte en una cadena
  */
  public int[] vectorDenumero(String x[]){
    String nuevo="abcdefghijklmnñopqrstuvwxyz";
    String palabra="" ;
    int guarda=0;
    char posicion=' ';
    for (int i=0;i<x.length ;i++ ) {
      palabra+=x[i];
    }
    int [] vectorNumerico=new int [palabra.length()];
    for (int i=0;i<palabra.length() ;i++) {
      posicion=palabra.charAt(i);
      guarda=nuevo.lastIndexOf(posicion);
      vectorNumerico[i]=guarda;
    }
    //imprimeArrInt(vectorNumerico);
    return vectorNumerico;
  }

  /*Metodo que me permite imprimr una lista arreglos
    solo para ver los sub arreglos  de string :V
  */
  public void imprimeArrString(String [] x){
    for (int i=0;i<x.length ;i++ ) {
      System.out.print("| " + x[i] + "|");
    }
    System.out.println("");
  }
    public void imprimeArrInt(int [] x){
      for (int i=0;i<x.length ;i++ ) {
        System.out.print("| " + x[i] + "|");
      }
      System.out.println("");
    }
  ///Metodo que imprime array de int
  //Metodos get y set
  public String getMensaje(){
    return mensaje;
  }
  public void setMensaje(String x){
    mensaje=x;
  }

  public static void main(String[] args) {
    Lector pruebas= new Lector("fortaleza");
    MatrizLetra prueba2= new MatrizLetra(4);
    Matriz numerica= new Matriz(4);
    prueba2= prueba2.rellenaMatrizLetra(pruebas);
    prueba2.imprimeMatrizLetra();
    System.out.println("<<<<<<<<<<<<<<<<<<<<<<");
    numerica=numerica.transformacionNumerica(prueba2);
    numerica.imprimeMatriz();
    System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxx");
    String[] prueba3=  pruebas.subArreglos("fortaleza",3);
    int[] vector1=new int[3];
    vector1[0]=2;
    vector1[1]=15;
    vector1[2]=13;
    int[] esperanza =numerica.multiplicaMAtrices(vector1,numerica);
    pruebas.imprimeArrInt(esperanza);
  }

}
