package com.mercadolibre.mutant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mercadolibre.mutant.dao.HumanDAO;
import com.mercadolibre.mutant.entity.Human;
import com.mercadolibre.mutant.entity.Stat;

@Service
public class StatService {
	@Autowired
    private HumanDAO humanDAO;
	
    public Stat getStats() {
        List<Human> listHumans = humanDAO.findAll();
        int humans = listHumans.size();
        int mutants = 0;
        for (Human human:listHumans) {
        	if (human.isMutant()) {
        		mutants++;
        	}
        }
        double ratio = humans/mutants;
        Stat stat = new Stat(humans, mutants, ratio);
        return stat;
    }
}
