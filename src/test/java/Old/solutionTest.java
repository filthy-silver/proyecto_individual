package Old;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class solutionTest {

    @Test
    void casoDePrueba_SpideyBetweenBombs() {
        Scanner in = new Scanner("100 150 200\n");

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        solution.in = in;
        solution.casoDePrueba();
        assertEquals("100\r\n", outContent.toString());
    }

    @Test
    void casoDePrueba_SpideyBeforeBombs() {
        Scanner in = new Scanner("50 100 200\n");
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        solution.in = in;
        solution.casoDePrueba();
        assertEquals("150\r\n", outContent.toString());
    }

    @Test
    void casoDePrueba_SpideyAfterBombs() {
        Scanner in = new Scanner("300 100 200\n");
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        solution.in = in;
        solution.casoDePrueba();
        assertEquals("200\r\n", outContent.toString());
    }

    @Test
    void casoDePrueba_SpideyAtFirstBomb() {
        Scanner in = new Scanner("100 100 200\n");
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        solution.in = in;
        solution.casoDePrueba();
        assertEquals("100\r\n", outContent.toString());
    }

    @Test
    void casoDePrueba_SpideyAtSecondBomb() {
        Scanner in = new Scanner("200 100 200\n");
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        solution.in = in;
        solution.casoDePrueba();
        assertEquals("100\r\n", outContent.toString());
    }

    @Test
    void casoDePrueba_SamePosition() {
        Scanner in = new Scanner("100 100 100\n");
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        solution.in = in;
        solution.casoDePrueba();
        assertEquals("0\r\n", outContent.toString());
    }

    @Test
    void casoDePrueba_InvalidInput() {
        Scanner in = new Scanner("-1 100 200\n");
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        solution.in = in;
        solution.casoDePrueba();
        assertEquals("", outContent.toString());
    }
}