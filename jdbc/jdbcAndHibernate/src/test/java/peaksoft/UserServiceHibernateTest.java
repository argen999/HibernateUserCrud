package peaksoft;

import org.junit.Assert;
import org.junit.Test;
import peaksoft.dao.UserDao;
import peaksoft.model.User;
import peaksoft.service.UserService;
import peaksoft.service.impl.UserServiceHibernateImpl;


import java.util.List;

public class UserServiceHibernateTest {
    private final UserService userDao = new UserServiceHibernateImpl();

    private final String testName = "Zhanarbek";
    private final String testLastName = "Abdyrasulov";
    private final byte testAge = 20;

    @Test
    public void dropUsersTable() {
        try {
            userDao.dropUsersTable();
            userDao.dropUsersTable();
        } catch (Exception e) {
            Assert.fail("При тестировании удаления таблицы произошло исключение\n" + e);
        }
    }

    @Test
    public void createUsersTable() {
        try {
            userDao.dropUsersTable();
            userDao.createUsersTable();
        } catch (Exception e) {
            Assert.fail("При тестировании создания таблицы пользователей произошло исключение\n" + e.getMessage());
        }
    }

    @Test
    public void saveUser() {
        try {
            userDao.dropUsersTable();
            userDao.createUsersTable();
            userDao.saveUser(testName, testLastName, testAge);

            User user = userDao.getAllUsers().get(0);

            if (!testName.equals(user.getName())
                    || !testLastName.equals(user.getLastName())
                    || testAge != user.getAge()
            ) {
                Assert.fail("User был некорректно добавлен в базу данных");
            }

        } catch (Exception e) {
            Assert.fail("Во время тестирования сохранения пользователя произошло исключение\n" + e);
        }
    }

    @Test
    public void removeUserById() {
        try {
            userDao.dropUsersTable();
            userDao.createUsersTable();
            userDao.saveUser(testName, testLastName, testAge);
            userDao.removeUserById(1L);
        } catch (Exception e) {
            Assert.fail("При тестировании удаления пользователя по id произошло исключение\n" + e);
        }
    }

    @Test
    public void getAllUsers() {
        try {
            userDao.dropUsersTable();
            userDao.createUsersTable();
            userDao.saveUser(testName, testLastName, testAge);
            List<User> userList = userDao.getAllUsers();

            if (userList.size() != 1) {
                Assert.fail("Проверьте корректность работы метода сохранения пользователя/удаления или создания таблицы");
            }
        } catch (Exception e) {
            Assert.fail("При попытке достать всех пользователей из базы данных произошло исключение\n" + e);
        }
    }

    @Test
    public void cleanUsersTable() {
        try {
            userDao.dropUsersTable();
            userDao.createUsersTable();
            userDao.saveUser(testName, testLastName, testAge);
            userDao.cleanUsersTable();

            if (userDao.getAllUsers().size() != 0) {
                Assert.fail("Метод очищения таблицы пользователей реализован не корректно");
            }
        } catch (Exception e) {
            Assert.fail("При тестировании очистки таблицы пользователей произошло исключение\n" + e);
        }
    }
}
