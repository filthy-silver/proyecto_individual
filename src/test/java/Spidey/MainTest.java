package Spidey;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    //Datos válidos

    /**
     * Prueba que verifica el comportamiento de spideyDistMin cuando Spidey está en el límite máximo.
     */
    @Test
    void spideyDistMin_SpideyAtMaxBoundary() {
        int[] pos = {10000, 5000, 3000};
        int[] result = Main.spideyDistMin(pos);
        assertNotNull(result);
        assertArrayEquals(pos, result);
    }

    /**
     * Prueba que verifica el comportamiento de spideyDistMin cuando las bombas están en el límite máximo.
     */
    @Test
    void spideyDistMin_BombsAtMaxBoundary() {
        int[] pos = {5000, 10000, 10000};
        int[] result = Main.spideyDistMin(pos);
        assertNotNull(result);
        assertArrayEquals(pos, result);
    }

    /**
     * Prueba que verifica el comportamiento de spideyDistMin cuando Spidey y las bombas están en el límite máximo.
     */
    @Test
    void spideyDistMin_SpideyAndBombsAtMaxBoundary() {
        int[] pos = {10000, 10000, 10000};
        int[] result = Main.spideyDistMin(pos);
        assertNotNull(result);
        assertArrayEquals(pos, result);
    }

    /**
     * Prueba que verifica el comportamiento de spideyDistMin cuando Spidey está en el límite mínimo.
     */
    @Test
    void spideyDistMin_SpideyAtMinBoundary() {
        int[] pos = {0, 5000, 3000};
        int[] result = Main.spideyDistMin(pos);
        assertNull(result);
    }

    /**
     * Prueba que verifica el comportamiento de spideyDistMin cuando las bombas están en el límite mínimo.
     */
    @Test
    void spideyDistMin_BombsAtMinBoundary() {
        int[] pos = {5000, 0, 0};
        int[] result = Main.spideyDistMin(pos);
        assertNull(result);
    }

    /**
     *Prueba que vuelve a verificar el comportamiento de spideyDistMin cuando Spidey y las bombas están en el límite mínimo.
     */
    @Test
    void spideyDistMin_SpideyAndBombsAtMinBoundary() {
        int[] pos = {0, 0, 0};
        int[] result = Main.spideyDistMin(pos);
        assertNull(result);
    }

    //Datos inválidos

    /**
     * Prueba que verifica el comportamiento de spideyDistMin cuando Spiderman está por encima del límite máximo.
     */
    @Test
    void spideyDistMin_SpideyOverMaxBoundary() {
        int[] pos = {10001, 5000, 3000};
        int[] result = Main.spideyDistMin(pos);
        assertNull(result);
    }

    /**
     * Verificamos el comportamiento de spideyDistMin cuando Spidey está en un valor negativo.
     */
    @Test
    void spideyDistMin_SpideyAtNegativeBoundary() {
        int[] pos = {-1, 5000, 3000};
        int[] result = Main.spideyDistMin(pos);
        assertNull(result);
    }

    /**
     * Y volvemos a verificar el comportamiento de spideyDistMin cuando las bombas están en un valor negativo.
     */
    @Test
    void spideyDistMin_BombsAtNegativeBoundary() {
        int[] pos = {5000, -1, -1};
        int[] result = Main.spideyDistMin(pos);
        assertNull(result);
    }

    /**
     * SPiderman y las bombas están en un valor negativo.
     */
    @Test
    void spideyDistMin_SpideyAndBombsAtNegativeBoundary() {
        int[] pos = {-1, -1, -1};
        int[] result = Main.spideyDistMin(pos);
        assertNull(result);
    }
}