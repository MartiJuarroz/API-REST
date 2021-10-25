package com.example.mutantes.services;

import com.example.mutantes.entities.Humano;

import java.io.Serializable;
import java.util.List;

public interface BaseService<E> {

    public List<E> findAll() throws Exception;
    public E findById(long id) throws Exception;
    public E save(E entity) throws Exception;
    public E update(long id, E entity) throws Exception;
    public boolean delete(long id) throws Exception;
    public boolean isMutant(String[] dna) throws Exception;
    public List<Humano> findAllByEsMutante() throws Exception;
    public List<Humano> findAllByNoEsMutante() throws Exception;


}
