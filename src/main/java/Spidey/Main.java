package Spidey;

import java.util.Scanner;

/**
 * Clase principal de un programa <b>excesivamente</b> complicado para calcular la distancia mínima de <i>Spiderman</i> a dos bombas.
 * @author Alecs
 */
public class Main {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {

        // Verifica si la entrada no contiene un número entero
        if (!in.hasNextInt()) {
            System.out.println("Invalid input");
            return;
        }

        // Si el programa continúa, se lee el número de casos
        int numCasos = in.nextInt();
        in.nextLine(); // Limpia la línea para evitar problemas con la entrada

        // Itera sobre los casos ingresados
        for (int i = 0; i < numCasos; i++) {
            // Si el resultado de la entrada es nulo (inválido), muestra un mensaje de error
            if (spideyDistMin(setPosVector()) == null) {
                System.out.println("Invalid input");
            }
        }
    }    /**
     * Método principal donde se leerá la entrada y se llamará a los métodos necesarios para calcular el resultado.
     * @param args Entrada por consola
     */


    /**
     * Método que lee la entrada y la convierte en un vector de enteros.
     * <br>
     * Ejemplo de entrada válida:
     * <blockquote><pre>
     *      100 150 300
     *      0 0 0
     *      10000 5000 3000
     * </pre></blockquote>
     * Nota: Los números deben ser enteros y estar separados por un espacio.
     * @return Vector de enteros con las posiciones de Spidey y las bombas.
     *         Si la entrada no es válida, devuelve {@code null}.
     * @see Caso
     */
    public static int[] setPosVector() {
        String caso = in.nextLine().trim();

        // Verifica si la entrada cumple con el formato esperado
        if (!caso.matches("\\d{1,5}\\s+\\d{1,5}\\s+\\d{1,5}")) {
            return null;
        }

        // Convierte la entrada en un vector de enteros, con \\s+ separamos los números ya estén separados
        // por un único espacio o más, evitando crear un vector con un elemento vacío
        String[] auxS = caso.split("\\s+");

        // Al  ser un vector pequeño es factible no meterlo en un bucle
        return new int[] {Integer.parseInt(auxS[0]), Integer.parseInt(auxS[1]), Integer.parseInt(auxS[2])};
    }

    /**
     * Método que calcula la distancia mínima entre Spidey y las bombas.
     * <br>
     * Inicializa un objeto de la clase {@link Caso} y establece las posiciones de Spidey y las bombas.
     * @param pos Vector de posiciones de Spidey y las bombas.
     * @return El mismo vector si es válido, o {@code null} si es inválido.
     */
    public static int[] spideyDistMin(int[] pos) {
        // Verifica si el vector de posiciones es nulo
        if (pos == null) {
            return null;
        }

        // Inicializa un objeto de la clase Caso y establece las posiciones
        Caso c = new Caso();
        c.setPosSpidey(pos[0]);
        c.setPosBomb1(pos[1]);
        c.setPosBomb2(pos[2]);

        // Verifica si las posiciones son válidas o si la distancia mínima es negativa
        if (c.getPosSpidey() == -1 || c.getPosBomb1() == -1 || c.getPosBomb2() == -1 || c.getDistanciaMinima() < 0) {
            return null;
        }
        return pos;
    }
}

/**
 * Clase que representa un caso con las posiciones de Spideyrman y dos bombas. <br> Contiene las funcionas para calcular las distancias relacionadas.
 */
class Caso {
    private int posSpidey = -1;
    private int posBomb1 = -1;
    private int posBomb2 = -1;

    /**
     * Establece la posición de Spidey si es válida.
     * <br>
     * Nota: La posición de Spidey debe estar entre 1 y 10000.
     * @param spidey Posición de Spidey.
     */
    public void setPosSpidey(int spidey) {
        if (spidey >= 0 && spidey <= 10000) {
            this.posSpidey = spidey;
        }
    }

    public int getPosSpidey() {
        return posSpidey;
    }

    /**
     * Establece la posición de la primera bomba si es válida.
     * @param posBomb1 Posición de la primera bomba.
     */
    public void setPosBomb1(int posBomb1) {
        if (posBomb1 >= 0 && posBomb1 <= 10000) {
            this.posBomb1 = posBomb1;
        }
    }

    public int getPosBomb1() {
        return posBomb1;
    }

    /**
     * Establece la posición de la segunda bomba si es válida.
     * @param posBomb2 Posición de la segunda bomba.
     */
    public void setPosBomb2(int posBomb2) {
        if (posBomb2 >= 0 && posBomb2 <= 10000) {
            this.posBomb2 = posBomb2;
        }
    }

    public int getPosBomb2() {
        return posBomb2;
    }

    /**
     * Calcula la distancia de Spidey a la primera bomba.
     * @return Distancia entre Spiderman y la primera bomba.
     */
    public int distanciaSpideyB1() {
        return Math.abs(posSpidey - posBomb1);
    }

    /**
     * Calcula la distancia de Spiderman a la segunda bomba.
     * @return Distancia entre Spiderman y la segunda bomba.
     */
    public int distanciaSpideyB2() {
        return Math.abs(posSpidey - posBomb2);
    }

    /**
     * Calcula la distancia mínima considerando las posiciones de Spiderman y las bombas.
     * @param posSpidey Posición de Spiderman.
     * @param posBomb1 Posición de la primera bomba.
     * @param posBomb2 Posición de la segunda bomba.
     * @return Distancia mínima o {@code -1} si alguna posición es inválida.
     */
    public int distanciaMinima(int posSpidey, int posBomb1, int posBomb2) {
        if (posSpidey == -1 || posBomb1 == -1 || posBomb2 == -1) {
            return -1;
        }

        if (distanciaSpideyB1() < distanciaSpideyB2()) {
            System.out.println(distanciaSpideyB1() + Math.abs(posBomb1 - posBomb2));
            return distanciaSpideyB1() + Math.abs(posBomb1 - posBomb2);
        } else {
            System.out.println(distanciaSpideyB2() + Math.abs(posBomb2 - posBomb1));
            return distanciaSpideyB2() + Math.abs(posBomb2 - posBomb1);
        }
    }

    /**
     * Devuelve la distancia mínima calculada.
     * @return {@code 0} si la distancia mínima es válida, o {@code -1} si no lo es.
     */
    public int getDistanciaMinima() {
        if (distanciaMinima(posSpidey,posBomb1,posBomb2) < 0) {
            return -1;
        }
        return 0;
    }
}