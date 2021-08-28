package com.codegym.service;

import com.codegym.model.User;

import javax.servlet.ServletException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface IUserService {
    List<User> listUser() throws SQLException, IOException, ServletException;
}
