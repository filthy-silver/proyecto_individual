# Proyecto

## Planteamiento

Debemos averiguar cuál es la ruta más corta entre Spiderman y ambas bombas. Hay que tener en cuenta que el orden importa, pues de la posición 0 a la 300 y después a la 600 son 600 en total. Sin embargo de la 0 a la 600, y después a la 300 son 900m.

## Resolución

Tenemos dos tipos de datos en el problema. El número de casos y las posiciones. Dentro de las posiciones tenemos la posición de las bombas colocadas por el duende verde y la posición de Spiderman en la comisaría.

```java
class Caso {
    private int posSpidey = -1;
    private int posBomb1 = -1;
    private int posBomb2 = -1;

    public void setPosSpidey(int spidey) {
        if (spidey > 0 && spidey <= 10000) {
            this.posSpidey = spidey;
        }
    }

    public int getPosSpidey() {
        return posSpidey;
    }

    public void setPosBomb1(int posBomb1) {
        if (posBomb1 > 0 && posBomb1 <= 10000) {
            this.posBomb1 = posBomb1;
        }
    }

    public int getPosBomb1() {
        return posBomb1;
    }

    public void setPosBomb2(int posBomb2) {
        if (posBomb2 > 0 && posBomb2 <= 10000) {
            this.posBomb2 = posBomb2;
        }
    }

    public int getPosBomb2() {
        return posBomb2;
    }
```

Primero vamos a crear la clase para los casos, con sus variables y sus *getters* y *setters*.

Podemos comprobar como dentro de los métodos para introducir los datos hemos limitado los números en un rango, esto nos permitirá despreocuparnos del rango más adelante.

```java
public int distanciaSpideyB1() {
        return Math.abs(posSpidey - posBomb1);
    }

    public int distanciaSpideyB2() {
        return Math.abs(posSpidey - posBomb2);
    }
```

A continuación hemos definido un par de métodos para obtener rápidamente la distancia entre los puntos y Spiderman de una manera rápida.

```java
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

    public int getDistanciaMinima() {
        if (distanciaMinima(posSpidey,posBomb1,posBomb2) < 0) {
            return -1;
        }
        return 0;
    }
```

Al ejecutar `distanciaMinima()` vamos a comprobar que se hayan introducido datos en las posiciones. Esto quiere decir, que si el valor de las variables sigue siendo `-1` es que no se alteró el valor o no es válido, por lo que el método va a devolver `-1` indicándole a la función que lo llamó que hay un error en su funcionamiento.

Si todo es correcto, calculará cuánta distancia hay desde la bomba más cercana hasta la primera y le sumará la distancia de ésta con Spiderman.

Éste método lo hemos dejado abierto para poder hacer mejor las pruebas posteriormente. Para obtener directamente el resultado en el programa lo vamos a llamar a través de `getDistanciaMinima()`, el cual sí devolverá `0` si el programa se ejecuta correctamente.

```java
public static int[] spideyDistMin(int[] pos) {
        // Verifica si el vector de posiciones es nulo
        if (pos == null) {
            return null;
        }

        Caso c = new Caso();
        c.setPosSpidey(pos[0]);
        c.setPosBomb1(pos[1]);
        c.setPosBomb2(pos[2]);

        if (c.getPosSpidey() == -1 || c.getPosBomb1() == -1 || c.getPosBomb2() == -1 || c.getDistanciaMinima() < 0) {
            return null;
        }
        return pos;
    }
```

En `spideyDistMin(int[] pos)` vamos a inicializar un Caso. Si el vector de posiciones estuviese vacío devolveríamos `null`, al igual que si algún valor introducido no fuese válido.
Si no fuera el caso, devolveríamos el vector de posición `pos`.

```java
public static int[] setPosVector() {
        String caso = in.nextLine().trim();

        if (!caso.matches("\\d{1,5}\\s+\\d{1,5}\\s+\\d{1,5}")) {
            return null;
        }

        String[] auxS = caso.split("\\s+");

        return new int[] {Integer.parseInt(auxS[0]), Integer.parseInt(auxS[1]), Integer.parseInt(auxS[2])};
    }
```

Con `setPosVector()` vamos a introducir las 3 posiciones que requerimos, las cuales separaremos, convertiremos y devolveremos como el vector que necesitamos.

Ahora vamos a crear el `main` donde se ejecutará nuestro programa:

```java
public static void main(String[] args) {

        if (!in.hasNextInt()) {
            System.out.println("Invalid input");
            return;
        }

        int numCasos = in.nextInt();
        in.nextLine(); 

        for (int i = 0; i < numCasos; i++) {
            if (spideyDistMin(setPosVector()) == null) {
                System.out.println("Invalid input");
            }
        }
    }
```

Para la correcta ejecución del programa, necesitamos introducir primero cuántos casos se tienen que ejecutar.

Una vez asegurados que es un número, ejecutaremos `setPosVector()` para que nos devuelva un vector que `spideyDistMin()` lo lea. Si por algún casual, en algún punto del programa se dieran las condiciones que devolvían un `null` se pararía el programa y nos indicaría que hemos introducido un ~~"Invalid input"~~ "Valor inválido".

> Nota: El programa funciona perfectamente sin el "Invalid input". Está puesto por claridad. Si se elimina, cumple con los requisitos de *aceptaelreto.com*.
