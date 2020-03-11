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
          vectorNumerico=mensaje.vectorDenumero(menSeparado);
          System.out.println("Vector numerico");
          mensaje.imprimeArrInt(vectorNumerico);
          vectorIncriptado=numeros.multiplicaMAtrices(vectorNumerico,numeros);
          numeros.vectorInt(vectorIncriptado);
          System.out.println("La matriz encriptada");
          vectorChar = numeros.convertidorChar(vectorIncriptado);
          numeros.vectorChar(vectorChar);
        }else{
          Matriz pruebas=new Matriz(2);
          int [] [] valorPruebas = {{1,2,3},{4,5,6}};
          pruebas.setMatriz(valorPruebas);
          //pruebas.vectorInt(pruebas.getMatriz()[1]);
        pruebas.productoEscalar(2,3,pruebas);
        }



    }


}
