package com.mercadolibre.mutant.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mercadolibre.dto.MutantRequest;
import com.mercadolibre.dto.Stat;
import com.mercadolibre.mutant.entity.Human;
import com.mercadolibre.mutant.service.HumanService;
import com.mercadolibre.mutant.service.StatService;

//Indicamos que es un controlador rest
@RestController
@RequestMapping("/api") //esta sera la raiz de la url, es decir http://127.0.0.1:8080/api/
@CrossOrigin(origins = "*", methods= {RequestMethod.GET, RequestMethod.POST})
public class MutantRest {

    //Inyectamos el servicio para poder hacer uso de el
    @Autowired
    private HumanService humanService;
    
    @Autowired
    private StatService statService;

    /*Este método se hará cuando por una petición POST (como indica la anotación) se llame a la url
    http://127.0.0.1:8080/api/mutant/  */
    @PostMapping("/mutant")
    public ResponseEntity<Human> isMutant(@RequestBody MutantRequest request) {
    	int status = 403;
    	String[] dna = request.getDna();
        boolean isMutant = humanService.isMutant(dna);
        Human human = new Human(Arrays.toString(dna), isMutant);
        humanService.save(human);
        if (isMutant) {
        	status = 200;
        }
        return ResponseEntity.status(status).build();
    }
    
    @GetMapping("/stats")
    public ResponseEntity<Stat> getStats() {
    	Stat stats = statService.getStats();
        return ResponseEntity.ok(stats);
    }
    
    @GetMapping("/health-check")
    public ResponseEntity<Object> healthCheck() {
        return ResponseEntity.ok().build();
    }

}
