package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.List;

public class UserServiceImpl extends UserDaoJDBCImpl implements UserService {
    UserDaoJDBCImpl daojdbc = new UserDaoJDBCImpl();

    public void createUsersTable() {
        daojdbc.createUsersTable();
    }

    public void dropUsersTable() {
        daojdbc.dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) {
        daojdbc.saveUser(name, lastName, age);
    }

    public void removeUserById(long id) {
        daojdbc.removeUserById(id);
    }

    public List<User> getAllUsers() {
        return daojdbc.getAllUsers();
    }

    public void cleanUsersTable() {
        daojdbc.cleanUsersTable();
    }
}
