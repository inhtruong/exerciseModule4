package com.codegym.service.impl;

import com.codegym.model.Bill;
import com.codegym.service.IBillService;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Service
public class HiberBillServiceImpl implements IBillService {
    private static SessionFactory sessionFactory;
    private static EntityManager entityManager;

    static {
        try {
            sessionFactory = new Configuration()
                    .configure("hibernate.conf.xml")
                    .buildSessionFactory();
            entityManager = sessionFactory.createEntityManager();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Bill> findAll() {
        String queryStr = "SELECT b FROM Bill AS b";
        TypedQuery<Bill> query = entityManager.createQuery(queryStr, Bill.class);
        return query.getResultList();
    }

    @Override
    public Bill findOne(Long id) {
        String queryStr = "SELECT b FROM Bill AS b WHERE b.id = :id";
        TypedQuery<Bill> query = entityManager.createQuery(queryStr, Bill.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }
}
