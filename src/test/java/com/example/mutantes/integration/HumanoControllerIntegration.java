package com.example.mutantes.integration;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.mutantes.MutantesApplication;
import com.example.mutantes.entities.Humano;
import com.example.mutantes.repositories.HumanoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest(classes = MutantesApplication.class)
@AutoConfigureMockMvc
@TestPropertySource(
        locations = "classpath:application.properties"
)
public class HumanoControllerIntegration {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private HumanoRepository humanoRepository;

    @Test
    public void TestFindAll() throws Exception{
        Humano h = new Humano();
        h.setEsMutante(true);
        h.setAdn("ATGCGA,AAGTGC,ATATGT,AGAAGG,CCCCTA,TCACTG");

        humanoRepository.save(h);

        mockMvc.perform(get("/mutantes/v1/humanos/")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

  /*  @Test
    public void TestSave() throws Exception{
        Humano h = new Humano();
        h.setEsMutante(true);
        h.setAdn("ATGCGA,AAGTGC,ATATGT,AGAAGG,CCCCTA,TCACTG");

        humanoRepository.save(h);

        mockMvc.perform(post("/mutantes/v1/humanos/")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }*/

  /*  @Test
    public void TestDelete() throws Exception{
        Humano h = new Humano();
        h.setEsMutante(true);
        h.setAdn("ATGCGA,AAGTGC,ATATGT,AGAAGG,CCCCTA,TCACTG");
        h.setId(10L);
        List<Humano> listaEnviada = new ArrayList<>();
        listaEnviada.add(h);

        humanoRepository.save(h);

        mockMvc.perform(get("/mutantes/v1/humanos//{10L}")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());
    }*/


}
