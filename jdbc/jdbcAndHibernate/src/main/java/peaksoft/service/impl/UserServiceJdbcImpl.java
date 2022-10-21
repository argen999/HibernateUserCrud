package peaksoft.service.impl;

import peaksoft.dao.impl.UserDaoJdbcImpl;
import peaksoft.model.User;
import peaksoft.service.UserService;

import java.sql.SQLException;
import java.util.List;

public class UserServiceJdbcImpl implements UserService {
    private final UserDaoJdbcImpl userDao = new UserDaoJdbcImpl();
    @Override
    public void createUsersTable() {
        userDao.createUsersTable();
    }
    @Override
    public void dropUsersTable() {
        userDao.dropUsersTable();
    }
    @Override
    public void saveUser(String name, String lastName, byte age) {
        userDao.saveUser(name, lastName, age);
    }
    @Override
    public void removeUserById(long id) {
        userDao.removeUserById(id);
    }
    @Override
    public List<User> getAllUsers() throws SQLException {
        return userDao.getAllUsers();
    }
    @Override
    public void cleanUsersTable() {
        userDao.cleanUsersTable();
    }
}
