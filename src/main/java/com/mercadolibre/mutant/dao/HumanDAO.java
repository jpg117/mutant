package com.mercadolibre.mutant.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mercadolibre.mutant.entity.Human;

@Repository
public class HumanDAO {

    @Autowired
    private EntityManager entityManager;
    
    public List<Human> findAll() {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<Human> query = currentSession.createQuery("from Human", Human.class);
        List<Human> humans = query.getResultList();
        return humans;
    }
    
    public void save(Human human) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(human);  
    }

}