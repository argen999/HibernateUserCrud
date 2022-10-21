package peaksoft.service.impl;

import peaksoft.dao.UserDao;
import peaksoft.dao.impl.UserDaoHibernateImpl;
import peaksoft.model.User;
import peaksoft.service.UserService;

import java.util.List;

public class UserServiceHibernateImpl implements UserService {

    private UserDaoHibernateImpl userDaoHibernate = new UserDaoHibernateImpl();
    @Override
    public void createUsersTable() {
        userDaoHibernate.createUsersTable();
        System.out.println("Table is created successfully!");
    }

    @Override
    public void dropUsersTable() {
        userDaoHibernate.dropUsersTable();
        System.out.println("Table is dropped successfully!");
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        userDaoHibernate.saveUser(name, lastName, age);
        System.out.println("User saved is successfully!");
    }

    @Override
    public void removeUserById(long id) {
        userDaoHibernate.removeUserById(id);
        System.out.println("Successfully removed User by id!");
    }

    @Override
    public List<User> getAllUsers() {
        return userDaoHibernate.getAllUsers();
    }

    @Override
    public void cleanUsersTable() {
        userDaoHibernate.cleanUsersTable();
        System.out.println("Table clients cleaned successfully!");
    }
}
