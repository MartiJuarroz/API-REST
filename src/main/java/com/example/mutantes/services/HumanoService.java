package com.example.mutantes.services;

import com.example.mutantes.detector.ComprobarADN;
import com.example.mutantes.entities.Humano;
import com.example.mutantes.repositories.HumanoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class HumanoService implements BaseService<Humano> {

    @Autowired
    private HumanoRepository humanoRepository;

    public HumanoService(HumanoRepository humanoRepository) {
        this.humanoRepository = humanoRepository;
    }

   @Override
   @Transactional
    public boolean isMutant(String[] dna) throws Exception {
        try {
            Humano h = new Humano();
            ComprobarADN det = new ComprobarADN();
            List<String> ADN = det.Convertir(dna);
            if (!det.ComprobarMatriz(ADN)){
                return false;
            }
            int contador = 0; // empezamos a recorrer la matriz
            contador = det.RecorrerDiagonal(ADN, contador);
            contador = det.RecorrerVertical(ADN, contador);
            contador = det.RecorrerHorizontal(ADN, contador);
            contador = det.RecorrerContraDiagonal(ADN, contador);
            if (contador >= 2){
                h.setEsMutante(true);
                h.setAdn(ADN.toString());
                humanoRepository.save(h);
                return true;
            }
            h.setEsMutante(false);
            h.setAdn(ADN.toString());
            humanoRepository.save(h);
            return false;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public List<Humano> findAll() throws Exception {
        try{
            List<Humano> entities = humanoRepository.findAll();
            return entities;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Humano findById(long id) throws Exception {
        try{
            Optional<Humano> entityOptional = humanoRepository.findById(id);
            return entityOptional.get();
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Humano save(Humano entity) throws Exception {
        try{
            entity = humanoRepository.save(entity);
            return entity;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

   @Override
    @Transactional
    public Humano update(long id,Humano entity) throws Exception {
        try{
            Optional<Humano> entityOptional = humanoRepository.findById(id);
            Humano entityUpdate = entityOptional.get();
            entityUpdate = humanoRepository.save(entity);
            return entityUpdate;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean delete(long id) throws Exception {
        try{
            if (humanoRepository.existsById(id)){
                humanoRepository.deleteById(id);
                return true;
            } else {
                throw new Exception();
            }
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public List<Humano> findAllByNoEsMutante() throws Exception{
        try{
            List<Humano> humanos = humanoRepository.findAllByNoEsMutante();
            return humanos;
        }catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public List<Humano> findAllByEsMutante() throws Exception{
        try{
            List<Humano> humanos = humanoRepository.findAllByEsMutante();
            return humanos;
        }catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }



}















