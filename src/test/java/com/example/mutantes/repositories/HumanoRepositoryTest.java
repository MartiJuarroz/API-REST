package com.example.mutantes.repositories;

import com.example.mutantes.entities.Humano;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class HumanoRepositoryTest {

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private HumanoRepository humanoRepository;

  /*  @Test
    public void TestFindAllByEsMutante() {
        Humano h = new Humano();
        h.setEsMutante(true);

        List<Humano> listaEnviada = new ArrayList<>();
        listaEnviada.add(h);

        entityManager.persist(h);
        entityManager.flush();

        assertEquals(listaEnviada, humanoRepository.findAllByEsMutante());

    }

    @Test
    public void TestFindAllByNoEsMutante() {
        Humano h = new Humano();
        h.setEsMutante(false);

        List<Humano> listaEnviada = new ArrayList<>();
        listaEnviada.add(h);

        entityManager.persist(h);
        entityManager.flush();

        assertEquals(listaEnviada, humanoRepository.findAllByNoEsMutante());

    }*/

}
