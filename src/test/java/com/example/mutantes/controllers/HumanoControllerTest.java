package com.example.mutantes.controllers;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.mutantes.entities.ADN;
import com.example.mutantes.entities.Humano;
import com.example.mutantes.services.HumanoService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@WebMvcTest(HumanoController.class)
public class HumanoControllerTest {

    @MockBean
    private HumanoService humanoService;

    @Autowired
    private MockMvc mockMvc;


    @Test
    public void TestFindAllByEsMutante() throws Exception {
        Humano h = new Humano();
        h.setEsMutante(true);
        List<Humano> listaEnviada = new ArrayList<>();
        listaEnviada.add(h);

        when(humanoService.findAllByEsMutante()).thenReturn(listaEnviada);

        mockMvc.perform(get("/mutantes/v1/humanos/buscarMutantes")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

 /*   @Test
    public void TestFindAllByEsMutanteExcep() throws Exception {
        Humano h = new Humano();
        h.setEsMutante(true);
        List<Humano> listaEnviada = new ArrayList<>();
        listaEnviada.add(h);

        when(humanoService.findAllByEsMutante()).thenReturn(listaEnviada);

        mockMvc.perform(get("/mutantes/v1/humanos/buscarMutantes")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }*/

    @Test
    public void TestFindAllByNoEsMutante() throws Exception {
        Humano h = new Humano();
        h.setEsMutante(false);
        List<Humano> listaEnviada = new ArrayList<>();
        listaEnviada.add(h);

        when(humanoService.findAllByNoEsMutante()).thenReturn(listaEnviada);

        mockMvc.perform(get("/mutantes/v1/humanos/buscarNoMutantes")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void TestIsMutante() throws Exception {
   //     Humano h = new Humano();
   //     ADN adn = new ADN();
   //    h.setAdn("[\"ATGCGA\",\"CAGTGC\",\"TTATGT\",\"AGAAGG\",\"CCCCTA\",\"TCACTG\"]");
        String[] dna = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};

        when(humanoService.isMutant(dna)).thenReturn(true);

        mockMvc.perform(post("/mutantes/v1/humanos/mutant")
                .content("{\"dna\": [\"ATGCGA\",\"CAGTGC\",\"TTATGT\",\"AGAAGG\",\"CCCCTA\",\"TCACTG\"]}")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void TestIsMutanteExcep() throws Exception {
        //     Humano h = new Humano();
        //     ADN adn = new ADN();
        //    h.setAdn("[\"ATGCGA\",\"CAGTGC\",\"TTATGT\",\"AGAAGG\",\"CCCCTA\",\"TCACTG\"]");
        String[] dna = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};

        when(humanoService.isMutant(dna)).thenReturn(true);

        mockMvc.perform(post("/mutantes/v1/humanos/mutant")
                .content("{\"dna3\": [\"ATGCGA\",\"CAGTGC\",\"TTATGT\",\"AGAAGG\",\"CCCCTA\",\"TCACTG\"]}")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    public void TestIsNotMutante() throws Exception {
  /*      Humano h = new Humano();
        ADN adn = new ADN();
        h.setAdn("[\"ATGCGA\",\"CAGTAC\",\"TTATGT\",\"AGAAGG\",\"CCTCTA\",\"TCACTG\"]");*/
        String[] dna = {"ATGCGA","CAGTAC","TTATGT","AGAAGG","CCTCTA","TCACTG"};

        when(humanoService.isMutant(dna)).thenReturn(false);

        mockMvc.perform(post("/mutantes/v1/humanos/mutant")
                .content("{\"dna\": [\"ATGCGA\",\"CAGTAC\",\"TTATGT\",\"AGAAGG\",\"CCTCTA\",\"TCACTG\"]}")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isForbidden());
    }

    @Test
    public void TestWrongMatrix() throws Exception {
    /*    Humano h = new Humano();
        ADN adn = new ADN();
        h.setAdn("[\"ATGCG\",\"CAGTAC\",\"TTATGT\",\"AGAAGG\",\"CCTCTA\",\"TCACTG\"]");*/
        String[] dna = {"ATGCG","CAGTAC","TTATGT","AGAAGG","CCTCTA","TCACTG"};

        when(humanoService.isMutant(dna)).thenReturn(false);

        mockMvc.perform(post("/mutantes/v1/humanos/mutant")
                        .content("{\"dna\": [\"ATGCG\",\"CAGTAC\",\"TTATGT\",\"AGAAGG\",\"CCTCTA\",\"TCACTG\"]}")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void TestGetAll() throws Exception {
        Humano h = new Humano();
        h.setAdn("[\"ATGCGA\",\"CAGTGC\",\"TTATGT\",\"AGAAGG\",\"CCCCTA\",\"TCACTG\"]");
        h.setEsMutante(true);
        List<Humano> listaEnviada = new ArrayList<>();
        listaEnviada.add(h);

        when(humanoService.findAll()).thenReturn(listaEnviada);

        mockMvc.perform(get("/mutantes/v1/humanos/")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

   @Test
    public void TestGetOne() throws Exception {
        Humano h = new Humano();
        h.setAdn("[\"ATGCGA\",\"CAGTGC\",\"TTATGT\",\"AGAAGG\",\"CCCCTA\",\"TCACTG\"]");
        h.setEsMutante(true);
        h.setId(100L);

        when(humanoService.findById(h.getId())).thenReturn(h);

        mockMvc.perform(get("/mutantes/v1/humanos/100")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void saveHumano() throws Exception {
        Humano h = new Humano();
        h.setAdn("[\"ATGCGA\",\"CAGTGC\",\"TTATGT\",\"AGAAGG\",\"CCCCTA\",\"TCACTG\"]");
        h.setEsMutante(true);

        when(humanoService.save(h)).thenReturn(h);

        mockMvc.perform(post("/mutantes/v1/humanos/")
                .content("{\"adn\":\"ATGCGA,CAGTGC,TTATGT,AGAAGG,CCCCTA,TCACTG\"}")
                .content("{\"EsMutante\" : true}")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
