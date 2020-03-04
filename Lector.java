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
    int sinDecimal=(int)Math.round(numero);
    System.out.println(numero);
    System.out.println(sinDecimal);
    if(esPrimo(longitud-1)) return false;
    if(numero==sinDecimal) return true;

    return  false;
  }

  //Metodos get y set
  public String getMensaje(){
    return mensaje;
  }
  public void setMensaje(String x){
    mensaje=x;
  }

  public static void main(String[] args) {
    Lector pruebas= new Lector("Hola");
    System.out.println(pruebas.sepuedeColocarMatriz());
  }

}
