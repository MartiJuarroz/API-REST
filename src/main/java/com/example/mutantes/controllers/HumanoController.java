package com.example.mutantes.controllers;

import com.example.mutantes.detector.ComprobarADN;
import com.example.mutantes.entities.ADN;
import com.example.mutantes.entities.Humano;
import com.example.mutantes.services.HumanoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "mutantes/v1/humanos")
public class HumanoController {

    @Autowired
    protected HumanoService humanoService;

    @GetMapping("")
    public ResponseEntity<?> getAll() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(humanoService.findAll());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Por favor intente mas tarde.\"}");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(humanoService.findById(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Por favor intente mas tarde.\"}");
        }
    }

    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody Humano entity){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(humanoService.save(entity));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Por favor intente mas tarde.\"}");
        }
    }

 /*   @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable  Long id,@RequestBody  Humano entity){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(humanoService.update(id,entity));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Por favor intente mas tarde.\"}");
        }
    }*/

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        try {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(humanoService.delete(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Por favor intente mas tarde.\"}");
        }

    }

    @PostMapping("/mutant")
    public ResponseEntity<?> isMutant (@RequestBody ADN adn){
        try{
            String[] adn2 = adn.getDna();
            ComprobarADN comp = new ComprobarADN();
            List<String> DNA = comp.Convertir(adn2);
            if(!comp.ComprobarMatriz(DNA)){ // verificamos que la matriz cumpla algunas condiciones minimas
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El adn ingresado es incorrecto");
            }
            if(humanoService.isMutant(adn2)) {
                return ResponseEntity.status(HttpStatus.OK).body("Mutante positivo");
            } else {
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Humano");
            }
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\";\"Error. Por favor intente más tarde.\"}");
        }
    }


    @GetMapping("/buscarMutantes")
    public ResponseEntity<?> findAllByEsMutante(){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(humanoService.findAllByEsMutante());
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage()+ "\"}"));
        }
    }

    @GetMapping("/buscarNoMutantes")
    public ResponseEntity<?> findAllByNoEsMutante(){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(humanoService.findAllByNoEsMutante());
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage()+ "\"}"));
        }
    }





}
