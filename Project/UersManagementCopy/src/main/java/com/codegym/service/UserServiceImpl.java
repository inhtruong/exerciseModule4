package com.codegym.service;

import com.codegym.model.User;
import org.springframework.stereotype.Service;

import javax.servlet.ServletException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@Service
public class UserServiceImpl implements IUserService{
    @Override
    public List<User> listUser() throws SQLException, IOException, ServletException {
        return null;
    }
}
