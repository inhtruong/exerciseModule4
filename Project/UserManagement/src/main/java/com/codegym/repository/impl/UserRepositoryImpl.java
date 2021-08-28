package com.codegym.repository.impl;

import com.codegym.model.User;
import com.codegym.repository.IUserRepository;
import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserRepositoryImpl implements IUserRepository {
    @Autowired
    private SessionFactory sessionFactory;

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public User selectUser(int id) {
        String queryStr = "SELECT u FROM User AS u WHERE u.id = :id";
        TypedQuery<User> query = entityManager.createQuery(queryStr, User.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public List<User> selectAllUsers() {
        String queryString = "SELECT u FROM User AS u ORDER BY u.id desc";
        TypedQuery<User> query = entityManager.createQuery(queryString, User.class);
        return query.getResultList();
    }

    @Override
    public List<User> selectAllUsersExceptId(int id) {
        String queryStr = "SELECT u FROM User AS u WHERE u.id != :id";
        TypedQuery<User> query = entityManager.createQuery(queryStr, User.class);
        query.setParameter("id", id);
        return query.getResultList();
    }


    @Override
    public void insertUser(User user){
        String queryStr = "INSERT INTO users (name_user, email, country, balance)" +
                "VALUES (?, ?, ?, ?)";
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();

            Query query = session.createNativeQuery(queryStr);
            query.setParameter(1, user.getName());
            query.setParameter(2, user.getEmail());
            query.setParameter(3, user.getCountry());
            query.setParameter(4, user.getBalance());

            query.executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }

    }

    @Override
    public void deleteUser(int id) {
        String queryStr = "DELETE FROM User AS u WHERE u.id = :id";
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();

            Query query = session.createQuery(queryStr);
            query.setParameter("id", id);
            query.executeUpdate();

            transaction.commit();

        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }


    @Override
    public User updateUser(User user) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();

            User newUser = selectUser(user.getId());
            newUser.setName(user.getName());
            newUser.setEmail(user.getEmail());
            newUser.setCountry(user.getCountry());
            newUser.setBalance(user.getBalance());

            session.saveOrUpdate(newUser);
            transaction.commit();
            return newUser;
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return null;
    }

//    @Override
//    public List<User> selectAllUsersExceptId() {
//        return null;
//    }

    @Override
    public void depositBalance(int id, float deposit){
        String queryStr = "UPDATE users SET balance = balance + ? WHERE id = ?;";
        Session session = null;
        Transaction transaction = null;

        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();

            Query query = session.createNativeQuery(queryStr);
            query.setParameter(1, deposit);
            query.setParameter(2, id);
            query.executeUpdate();

            transaction.commit();

        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public void withdrawBalance(int id, float withdraw) {
        String queryStr = "UPDATE users SET balance = balance - ? WHERE id = ?;";
        Session session = null;
        Transaction transaction = null;

        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();

            Query query = session.createNativeQuery(queryStr);
            query.setParameter(1, withdraw);
            query.setParameter(2, id);
            query.executeUpdate();

            transaction.commit();

        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

}
