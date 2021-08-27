package com.mercadolibre.mutant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mercadolibre.mutant.entity.Mutant;
import com.mercadolibre.mutant.service.MutantService;

//Indicamos que es un controlador rest
@RestController
@RequestMapping("/api") //esta sera la raiz de la url, es decir http://127.0.0.1:8080/api/
@CrossOrigin(origins = "*", methods= {RequestMethod.POST})
public class MutantRest {

    //Inyectamos el servicio para poder hacer uso de el
    @Autowired
    private MutantService mutantService;

    /*Este método se hará cuando por una petición POST (como indica la anotación) se llame a la url
    http://127.0.0.1:8080/api/mutant/  */
    @PostMapping("/mutant")
    public ResponseEntity<Mutant> addUser(@RequestBody Mutant mutant) {
    	int status = 200;
        boolean isMutant = mutantService.isMutant(mutant.dna);
        if (!isMutant) {
        	status = 403;
        }
        return ResponseEntity.status(status).build();
    }

}
