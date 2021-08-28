package com.codegym.service;

import com.codegym.model.User;

import java.util.List;

public interface IUserService {
    List<User> findAll();

    List<User> findAllExceptId(int id);

    User findOne(int id) ;

    User save(User user);

    User insert(User user);

    User findById(int id);

    void update(User user);

    void remove(int id);

    void deposit(int id, float deposit);

    void withdraw(int id, float withdraw);
}
