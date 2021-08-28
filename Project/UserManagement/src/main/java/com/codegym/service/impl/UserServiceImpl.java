package com.codegym.service.impl;

import com.codegym.model.User;
import com.codegym.repository.IUserRepository;
import com.codegym.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private IUserRepository userRepository;

    @Override
//    @Transactional
    public List<User> findAll() {
        List<User> listUser = userRepository.selectAllUsers();
        return listUser;
    }

    @Override
    public List<User> findAllExceptId(int id) {
        List<User> listUser = userRepository.selectAllUsersExceptId(id);
        return listUser;
    }

    @Override
//    @Transactional
    public User findOne(int id)  {
        User user = userRepository.selectUser(id);
        return user;
    }


    @Override
//    @Transactional
    public User save(User user) {
        return null;
    }

    @Override
//    @Transactional
    public User insert(User user) {
        userRepository.insertUser(user);
        return user;
    }

    @Override
//    @Transactional
    public User findById(int id) {
        return null;
    }

    @Override
//    @Transactional
    public void update(User user) {
        userRepository.updateUser(user);
    }

    @Override
//    @Transactional
    public void remove(int id) {
        userRepository.deleteUser(id);
    }

    @Override
//    @Transactional
    public void deposit(int id, float deposit){
        userRepository.depositBalance(id, deposit);
    }

    @Override
//    @Transactional
    public void withdraw(int id, float withdraw) {
        userRepository.withdrawBalance(id, withdraw);
    }
}
