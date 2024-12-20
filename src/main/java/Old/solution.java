package Old;

import java.util.Scanner;

public class solution {

    static Scanner in;

    /**
     * Método que calcula la distancia que recorrerá Spiderman para desactivar dos bombas.
     * @author Arecs
     */
    public static void casoDePrueba() {
        String caso = "";
        caso = in.nextLine();

        //Vamos a quitar posibles espacios en blanco al principio y al final
        caso = caso.trim();

        /* Formato de la entrada:
         \\d => Dígitos
         \\s => Espacio en blanco
         {1,5} => de 1 a 5 dígitos
         + => obliga a aparecer al menos una vez
         */
        if (!caso.matches("\\d{1,5}\\s+\\d{1,5}\\s+\\d{1,5}")) {
            return;
        }

        String []  auxS = caso.split(" ");

        //Convertimos manualmente los valores a enteros
        int [] pos = new int[] {Integer.parseInt(auxS[0]), Integer.parseInt(auxS[1]), Integer.parseInt(auxS[2])};

        //Comprobamos que los valores esten en el rango permitido
        for (int d : pos) {
            if (d < 0 || d > 10000) {
                return;
            }
        }

        //Vamos a calcular la distancia entre los puntos
        int a = Math.abs(pos[0] - pos[1]), b = Math.abs(pos[0] - pos[2]);

        /*
        Si Spiderman se encuentra entre los dos puntos, será clave ir al punto más cercano para evitar
        recorrer una distancia mayor. Si Spiderman está al principio o al final de los puntos de las bombas
        será irrelevante el orden en el que se visiten los puntos gracias a la distancia "absoluta" que hemos calculado
        */

        //Ahora vamos a averiguar qué punto es el más cercano a Spidey
        if (a < b){  //Si el punto 1 es el más cercano iremos primero a él
            System.out.println(Math.abs(pos[0] - pos[1])+ Math.abs(pos[1] - pos[2]));

        } else if (a > b){ //Si el punto 2 es el más cercano iremos primero a él
            System.out.println(Math.abs(pos[0] - pos[2])+ Math.abs(pos[2] - pos[1]));

        } else { //Si se encuentra al principio o al final del recorrido lo calcularemos de manera standard
            System.out.println(Math.abs(pos[0] - pos[1])+ Math.abs(pos[1] - pos[2]));
        }
    }

    public static void main(String[] args) {

        in = new java.util.Scanner(System.in);

        int numCasos = in.nextInt();
        in.nextLine();

        for (int i = 0; i < numCasos; i++)
            casoDePrueba();
    }
}