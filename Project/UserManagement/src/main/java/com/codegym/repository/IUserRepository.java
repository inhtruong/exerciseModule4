package com.codegym.repository;

import com.codegym.model.User;

import java.util.List;

public interface IUserRepository {
    void insertUser(User user);

    User selectUser(int id);

    List<User> selectAllUsers();

    List<User> selectAllUsersExceptId(int id);

    void deleteUser(int id);

//    public boolean updateBalance(User userSend,User userReceive, float balance) throws SQLException;

    void depositBalance(int id, float deposit);

    void withdrawBalance(int id, float withdraw);

//    public boolean updateReceive(User user) throws SQLException;

    User updateUser(User user);


//    public List<User> searchUser(String name) throws SQLException;
}
