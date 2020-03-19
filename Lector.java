import java.math.*;
import java.util.ArrayList;
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
    String subMensaje="";
    int longmen= mensaje.length();
    int tamArreglo= Math.round(longmen/tam);
    double operacion=(double)longmen/tam;
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
  Metodo que recibe una cadena y la convierte a un arreglo de  enteros
  *@param String x
  *@return int []
  */
  private int[] creadorNumeros(String x){
    String abecedario="abcdefghijklmnñopqrstuvwxyz";
    int [] codificacion= new int[x.length()];
    int guarda=0;
    char posicion=' ';
    for (int i=0;i<x.length() ;i++ ) {
      posicion=x.charAt(i);

      guarda=abecedario.lastIndexOf(posicion);

      codificacion[i]=guarda;
    }


    return codificacion;
  }
  /**
  Metodo que recibe una cadena de String y la convierte en una cadena
  */
  public int[][] vectorDenumero(String x[]){
    int[][] mensCompleto=new int [x.length][x[0].length()];
    int [] cachos= new int [x[0].length()];
    for (int i=0;i<x.length ;i++ ){
    cachos=creadorNumeros(x[i]);
    mensCompleto[i] = cachos;
    }

    for (int i=0;i<mensCompleto.length;i++ ) {
      System.out.println("m " + i);
      imprimeArrInt(mensCompleto[i]);
      System.out.println("");
    }

    return mensCompleto;
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
    public static void imprimeArrInt(int [] x){
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

  public static int[] posiciones(String x, String[] lista,int incidencias ){
    int MAX =20;
    int contador=0;
    int [] posicion= new int [incidencias];
    for (int i=0;i<lista.length ;i++ ) {
      System.out.println(lista[i]);
      System.out.println(x.equals(lista[i]));
       if (x.equalsIgnoreCase(lista[i]) ) {
         System.out.println("Entre");
         posicion[contador]=i;
         contador++;
       }
    }
    return  posicion;
  }

  public static void main(String[] args) {
    Lector pruebas= new Lector("TSIICHGDEAMUEGBPXBKCSDWLJTEEUWBAERAFSOMU"+
    "MWJMZIPOKRESWTILAWZWOEFLEOMROJMPDCPOKPII" +
    "QVEJMXRZCQMQLBTGIVAIIXTIEQVLLGLIGIBAERAN"+
    "MOMCLYAIPLGJSUQBACBAZIPOWTAQVOMBQMQRXKKO"+
    "WZXRFELSSYQQGRJQDBVNOHQVPWPADZSQWSUWEYMW"+
    "GSAMHXJCGADSPQPEKBIOIFOKBEOIOUWEXOINESYS"+
    "PCPFJMKJMPTGPIIXQEEMXFBWLSPSIWUAEAVLAQSD"+
    "AWXUQRGESPKCLDMRBTCMGDIPMNSAXIKKKOEMWCQP"+
    "OWXQXAVEENPLZQSGQPJIUIFESMWTTSNPBTQSSYSO"+
    "WUOKNYPKCNDAWXUQRGESPAQNDAWNCGATMRAWPAFE"+
    "SKTQSIGIZIOBAMRIWUQMQSIDKDSZWRKQRSLSKTGS"+
    "VUGBYWEFGRZIJAFPIBVEOFFVXZPOWZGRMPTJMRYC"+
    "UCSZIKMUTWRVXOOEFFSNCGHWYSPTGIVATLLGMGEZ"+
    "BZNOKMQLZQSGEFRAEAFQMKUGDAMXXUGNLQPBAKGM"+
    "QPLACMGDSPWUSGZPLASUWMFXVFOFMRLBTOWEGOQV"+
    "OJQWBUKLAAEYZGUYAQBHSUWZEZQQEFYIOQFAZMEN"+
    "CKUFRVXOOEFFSJCAPWCYBVQDWEYIQDRGFMQCNAVA"+
    "GXVGKZUWQWTISKPBGGNVMHBCPHWDSBUCYSQPEMTR"+
    "WDSAMNAZMGFMPDSEIXKGRUAEIVWENAEJWALWPMGW"+
    "UEFAVVIGSLMXBZOIFMHLMNHAQVOWRAJMQXZEAJMP"+
    "XADEKFMXAJAYASQZQPSDEJITCSDEIWUIFPMLAGLS"+
    "YSZWPTWEXLCUAWXQFAOOUMRBSTOEBMLMNHAQVOWG"+
    "NWEXBNTAYYIKBQPGPIJWUVWDURMGMAXMLVQLWMKO"+
    "IFATMPXLGSASYXTFAVXERTVIEMSYZCDWXMQMTALG"+
    "VXYWEUUXXZGEKQPIQDRGFMQCNAVAIITCBWDMKBQD"+
    "WXEPWNEVMHVAKNVGHXMNEKOVFBQRWESZBCVAATXH"+
    "JESCYFCPFJMKJMPTGHMBRQOSPSIMEEFFIZZKODXS"+
    "LUGZLUDLOGNWDEIWDRWDSLTKCWZGFIFOWXQBFKCS"+
    "ZSPMOASBEOMEEUAQLCPSWDURMUEWZGFMTRSKWBXT"+
    "EKQVSIOAKOEOIGLJAWQZQYEMWZITADMWLVTRAEEX"+
    "YWIGOXXDKOHMDEIEEMZEAMUCJUTZQQNVQRLAQTJA"+
    "WIWUMWJMZIPOKYYVIEEJFEAIROJAXOWNAVARLXWE"+
    "VQRCINTSDQFAGSUDMQWTEKYIUQEAFAWAMCLYQFOI"+
    "HANAVFBQSMZSAMGLDAWBAJUYAEIJGRLAVFVEOFYI"+
    "GQCQMQIKAWSDUFOWUHSZSQIFOIGIIIUIENSIWIIS"+
    "PIXKWEJPSXTNEFSYXRGNGETBZOILQEPWEISDQBRQ"+
    "RWXGLVEEHFSAMNCMMPPMGSLMIPBWDAMRAWGLKUKR"+
    "QGNLQIPKTILAVCCGBSEMZWRAJMQFKWAFPSSQVEGD"+
    "MXLGGSXSFAALGCYBDKEFEYPTKBJAWBAWNEMRBRQD"+
    "WXEPQFESEGIITAKKIKUKLWZKRILEWXIPXCNGXIIC"+
    "NTAYSAMNQMQIPKTITUVBMUGMUPIMTMGSVXJKNKWC"+
    "BVUUKOPXAGSVQWMMTTGYMFVVEJQWMWTEDMRXTKSA"+
    "ECPCNITDSQMQRAMHBTCMWPMAIUEZMGLVXEJFMAWG"+
    "NEUFXAGEFXSPKWRKAWNCGIEBEOBKDGMRQMUDWFIO"+
    "UKNSDIPBCCZMVIINEKBVBOWNLAGRINEKESKAWSSG"+
    "XLZGSXMZLZKTGEQBFKCSZSP"
    );
    String nuevo= pruebas.getMensaje();
    String casillas[]= pruebas.subArreglos(nuevo,7);
    pruebas.imprimeArrString(casillas);
    //int busca[]= posiciones("QDRG",casillas,5);
    //imprimeArrInt(busca);
    //int[] esperanza =numerica.multiplicaMAtrices(vector1,numerica);
    //pruebas.imprimeArrInt(esperanza);
  }

}
