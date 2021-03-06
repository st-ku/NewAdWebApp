package com.company.service;

import com.company.entity.WebTraffic;
import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
@Service
public class WebTrafficService {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void  save(WebTraffic webTraffic) {
        Session session = entityManager.unwrap(Session.class);
        Assert.notNull(webTraffic, "Entity must not be null.");
        session.saveOrUpdate(webTraffic);
    }
}
