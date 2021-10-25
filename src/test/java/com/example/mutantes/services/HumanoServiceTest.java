package com.example.mutantes.services;

import com.example.mutantes.entities.Humano;
import com.example.mutantes.repositories.HumanoRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class HumanoServiceTest {

    @MockBean
    private HumanoRepository humanoRepository;

    @Autowired
    private HumanoService humanoService;

    @Test
    public void findAll() throws Exception {
        String adn = "[\"ATGCGA\",\"CAGTGC\",\"TTATGT\",\"AGAAGG\",\"CCCCTA\",\"TCACTG\"]";
        Humano h = new Humano();
        h.setEsMutante(true);
        h.setAdn(adn);

        List<Humano> listaEnviada = new ArrayList<>();
        listaEnviada.add(h);
        when(humanoRepository.findAll()).thenReturn(listaEnviada);

        assertEquals(listaEnviada,humanoService.findAll());
    }

   @Test
    public void findById() throws Exception {

        String adn = "[\"ATGCGA\",\"CAGTGC\",\"TTATGT\",\"AGAAGG\",\"CCCCTA\",\"TCACTG\"]";

        Humano h = new Humano();
        h.setEsMutante(true);
        h.setId(10L);

        Mockito.when(humanoRepository.findById(h.getId())).thenReturn(Optional.of(h));

        Humano encontrado = humanoService.findById(h.getId());

        assertEquals(encontrado.getId(),h.getId());
    } 



    @Test
    public void testSaveHumano() throws Exception {
        Humano h = new Humano();
        h.setAdn("[\"ATGCGA\",\"CAGTGC\",\"TTATGT\",\"AGAAGG\",\"CCCCTA\",\"TCACTG\"]");
        h.setEsMutante(true);
        Mockito.when(humanoRepository.save(h)).thenReturn(h);

        Humano encontrado = humanoService.save(h);

        assertEquals(encontrado, h);
    }


    @Test
    public void testFindAllByEsMutante() throws Exception{
        Humano h = new Humano();
        h.setEsMutante(true);

        List<Humano> listaEnviada = new ArrayList<>();
        listaEnviada.add(h);
        when(humanoRepository.findAllByEsMutante()).thenReturn(listaEnviada);

        assertEquals(listaEnviada,humanoService.findAllByEsMutante());
    }

    @Test
    public void testFindAllByNoEsMutante() throws Exception{
        Humano h = new Humano();
        h.setEsMutante(false);

        List<Humano> listaEnviada = new ArrayList<>();
        listaEnviada.add(h);
        when(humanoRepository.findAllByNoEsMutante()).thenReturn(listaEnviada);

        assertEquals(listaEnviada, humanoService.findAllByNoEsMutante());
    }

    @Test
    public void testIsMutanteTrue() throws Exception{
        String[] dna = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};

        assertEquals(true,humanoService.isMutant(dna));
    }

    @Test
    public void testIsMutanteFalse() throws Exception{
        String[] dna = {"ATGCGA","CAGTGC","TTATCT","AGAAGG","CCCATA","TCACTG"};

        assertEquals(false,humanoService.isMutant(dna));
    }


    @Test
    public void testWrongMatrix() throws Exception{
        String[] dna = {"ATGCG","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};

        assertEquals(false,humanoService.isMutant(dna));
    }


}
