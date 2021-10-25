package com.example.mutantes.detector;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ComprobarADNTest {

    public ComprobarADN comprobarADN = new ComprobarADN();

    @Test
    public void VerificarMatrizCuadrada(){
        List<String> dna = new ArrayList<>();
        dna.add("ATGCGA");
        dna.add("CAGTGC");
        dna.add("TTATGT");
        dna.add("AGAAGG");
        dna.add("CCCCTA");
        dna.add("TCACTGA");

        Boolean resultado = comprobarADN.ComprobarMatrizCuadrada(dna);

        assertEquals(resultado,false);
    }

    @Test
    public void VerificarTamañoMatriz(){
        List<String> dna = new ArrayList<>();
        dna.add("ATGCGA");
        dna.add("CAGTGC");
        dna.add("TTATGT");

        Boolean resultado = comprobarADN.TamañoMinimo(dna);

        assertEquals(resultado,false);
    }

    @Test
    public void VerificarLetrasMatriz(){
        List<String> dna = new ArrayList<>();
        dna.add("ATGCGA");
        dna.add("CAGTGC");
        dna.add("TTFTGT");
        dna.add("AGAAGG");
        dna.add("CCCCTS");
        dna.add("TCACTG");

        Boolean resultado = comprobarADN.ComprobarLetrasMatriz(dna);

        assertEquals(resultado,false);
    }

    @Test
    public void VerificarMatriz(){
        List<String> dna = new ArrayList<>();
        dna.add("ATGCGA");
        dna.add("CAGTGC");
        dna.add("TTTTGT");
        dna.add("AGAAGG");
        dna.add("CCCCTA");
        dna.add("TCACTG");

        Boolean resultado = comprobarADN.ComprobarMatriz(dna);

        assertEquals(resultado,true);
    }

    @Test
    public void RecorrerDiagonal() {
        List<String> dna = new ArrayList<>();
        dna.add("ATGCGA");
        dna.add("CAGTGC");
        dna.add("TTATGT");
        dna.add("AGAAGG");
        dna.add("CCCCTA");
        dna.add("TCACTG");

        int resultado = comprobarADN.RecorrerDiagonal(dna, 0);

        assertEquals(resultado, 1);
    }

    @Test
    public void RecorrerVertical() {
        List<String> dna = new ArrayList<>();
        dna.add("ATGCGA");
        dna.add("CAGTGC");
        dna.add("TTATGT");
        dna.add("AGAAGG");
        dna.add("CCCCTA");
        dna.add("TCACTG");

        int resultado = comprobarADN.RecorrerVertical(dna, 0);

        assertEquals(resultado, 1);
    }

    @Test
    public void RecorrerHorizontal() {
        List<String> dna = new ArrayList<>();
        dna.add("ATGCGA");
        dna.add("CAGTGC");
        dna.add("TTATGT");
        dna.add("AGAAGG");
        dna.add("CCCCTA");
        dna.add("TCACTG");

        int resultado = comprobarADN.RecorrerHorizontal(dna, 0);

        assertEquals(resultado, 1);
    }

    @Test
    public void RecorrerContraDiagonal() {
        List<String> dna = new ArrayList<>();
        dna.add("ATGCGA");
        dna.add("CAGTAC");
        dna.add("TTAAGT");
        dna.add("AGAAGG");
        dna.add("CCCCTA");
        dna.add("TCACTG");

        int resultado = comprobarADN.RecorrerContraDiagonal(dna, 0);

        assertEquals(resultado, 1);
    }

    @Test
    public void RecorrerVerticalSaltear() {
        List<String> dna = new ArrayList<>();
        dna.add("ATGCGA");
        dna.add("CAGTGC");
        dna.add("TTATGT");
        dna.add("AGAAGG");
        dna.add("CCCCTA");
        dna.add("TCACTG");

        int resultado = comprobarADN.RecorrerVertical(dna, 2);

        assertEquals(resultado, 2);
    }


    @Test
    public void RecorrerVerticalSinCoincidencia() {
        List<String> dna = new ArrayList<>();
        dna.add("ATGCGA");
        dna.add("CAGTCC");
        dna.add("TTATGT");
        dna.add("AGAAGG");
        dna.add("CCCCTA");
        dna.add("TCACTG");

        int resultado = comprobarADN.RecorrerVertical(dna, 0);

        assertEquals(resultado, 0);
    }

    @Test
    public void RecorrerHorizontalSaltear() {
        List<String> dna = new ArrayList<>();
        dna.add("ATGCGA");
        dna.add("CAGTGC");
        dna.add("TTATGT");
        dna.add("AGAAGG");
        dna.add("CCCCTA");
        dna.add("TCACTG");

        int resultado = comprobarADN.RecorrerHorizontal(dna, 2);

        assertEquals(resultado, 2);
    }


    @Test
    public void RecorrerHorizontalSinCoincidencia() {
        List<String> dna = new ArrayList<>();
        dna.add("ATGCGA");
        dna.add("CAGTCC");
        dna.add("TTATGT");
        dna.add("AGAAGG");
        dna.add("CACCTA");
        dna.add("TCACTG");

        int resultado = comprobarADN.RecorrerHorizontal(dna, 0);

        assertEquals(resultado, 0);
    }

    @Test
    public void RecorrerContraDiagonalSaltear() {
        List<String> dna = new ArrayList<>();
        dna.add("ATGCGA");
        dna.add("CAGTGC");
        dna.add("TTATGT");
        dna.add("AGAAGG");
        dna.add("CCCCTA");
        dna.add("TCACTG");

        int resultado = comprobarADN.RecorrerContraDiagonal(dna, 2);

        assertEquals(resultado, 2);
    }


    @Test
    public void RecorrerContraDiagonalSinCoincidencia() {
        List<String> dna = new ArrayList<>();
        dna.add("ATGCGA");
        dna.add("CAGTCC");
        dna.add("TTATGT");
        dna.add("AGAAGG");
        dna.add("CCCCTA");
        dna.add("TCACTG");

        int resultado = comprobarADN.RecorrerContraDiagonal(dna, 0);

        assertEquals(resultado, 0);
    }


    @Test
    public void RecorrerDiagonalSinCoincidencia() {
        List<String> dna = new ArrayList<>();
        dna.add("ATGCGA");
        dna.add("CAGTCC");
        dna.add("TTCTGT");
        dna.add("AGAAGG");
        dna.add("CCCCTA");
        dna.add("TCACTG");

        int resultado = comprobarADN.RecorrerDiagonal(dna, 0);

        assertEquals(resultado, 0);
    }




}
