class Principal  {

    public static void main(String[] args) {
        System.out.println("Bienvenido a nuestro sistema para encriptar");
        Lector palabraClave= new Lector ("fortaleza");
        Lector mensaje= new Lector("consul");
        String men2= mensaje.getMensaje();
        int[] vectorNumerico ;
        int[] vectorIncriptado;
        char[] vectorChar;
        if(palabraClave.sepuedeColocarMatriz()){
          int longitud= palabraClave.longitudTexto();
          Matriz numeros= new Matriz(longitud);
          MatrizLetra mensajeEncr= new MatrizLetra(longitud);
          mensajeEncr= mensajeEncr.rellenaMatrizLetra(palabraClave);
          System.out.println("Este es la palbara clave con la cual se va a encriptar");
          mensajeEncr.imprimeMatrizLetra();
          System.out.println("Esta es su forma Numerica");
          numeros=numeros.transformacionNumerica(mensajeEncr);
          numeros.imprimeMatriz();
          System.out.println("Este es el mensaje que se va a encriptar ");
          System.out.println(men2);
          String [] menSeparado=mensaje.subArreglos(men2,longitud);
          System.out.println("En forma de arreglo se ve a si");
          mensaje.imprimeArrString(menSeparado);
          int [] [] formaNumero=mensaje.vectorDenumero(menSeparado);
          int [] [] codift= numeros.multiplicaMAtrices(formaNumero,numeros);
          System.out.println("Su mensaje codificado es ");
          numeros.codificacionVarChar(codift);

        }else{
          Matriz pruebas=new Matriz(2);
          int [][] porDos = {{5,15,18} ,{20,0,11} , {4,26,0}};
          pruebas.setMatriz(porDos);
          Lector verificacion=new Lector("Hola");
          String [] ejemplo = {"con","sul"};
          int[][] veamos=verificacion.vectorDenumero(ejemplo);
          pruebas.multiplicaMAtrices(veamos,pruebas);
        }



    }


}
