package Spidey;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Clase de pruebas unitarias para la clase Caso. <br>
 * Vamos a probar el método distanciaMinima de la clase Caso con datos
 * válidos e inválidos introducidos con setters.
 */
class CasoTest {

    // Pruebas con datos válidos
    // Spidey más cerca de la bomba 1
    @Test
    void spideyCloserToBomb1() {
        Caso caso = new Caso();
        caso.setPosSpidey(100);
        caso.setPosBomb1(150);
        caso.setPosBomb2(300);
        assertEquals(200,caso.distanciaMinima(caso.getPosSpidey(), caso.getPosBomb1(), caso.getPosBomb2()));
    }

    // Spidey más cerca de la bomba 2
    @Test
    void spideyCloserToBomb2() {
        Caso caso = new Caso();
        caso.setPosSpidey(100);
        caso.setPosBomb1(300);
        caso.setPosBomb2(150);
        assertEquals(200, caso.distanciaMinima(caso.getPosSpidey(), caso.getPosBomb1(), caso.getPosBomb2()));
    }

    // Spidey equidistante a las bombas
    @Test
    void spideyEquidistantToBombs() {
        Caso caso = new Caso();
        caso.setPosSpidey(100);
        caso.setPosBomb1(200);
        caso.setPosBomb2(200);
        assertEquals(100, caso.distanciaMinima(caso.getPosSpidey(), caso.getPosBomb1(), caso.getPosBomb2()));
    }

    // Spidey en el medio de las bombas
    @Test
    void spideySamePosition() {
        Caso caso = new Caso();
        caso.setPosSpidey(100);
        caso.setPosBomb1(100);
        caso.setPosBomb2(100);
        assertEquals(0, caso.distanciaMinima(caso.getPosSpidey(), caso.getPosBomb1(), caso.getPosBomb2()));
    }

    // Pruebas con datos inválidos
    // Spidey en posición negativa
    @Test
    void invalidInput() {
        Caso caso = new Caso();
        caso.setPosSpidey(-100);
        caso.setPosBomb1(200);
        caso.setPosBomb2(300);
        assertEquals(-1, caso.distanciaMinima(caso.getPosSpidey(), caso.getPosBomb1(), caso.getPosBomb2()));
    }

    // Bomba 1 muy, muy lejos
    @Test
    void bombsOutOfRange() {
        Caso caso = new Caso();
        caso.setPosSpidey(100);
        caso.setPosBomb1(10001);
        caso.setPosBomb2(300);
        assertEquals(-1, caso.distanciaMinima(caso.getPosSpidey(), caso.getPosBomb1(), caso.getPosBomb2()));
    }
}