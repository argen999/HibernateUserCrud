package peaksoft;


import peaksoft.dao.impl.UserDaoHibernateImpl;
import peaksoft.model.User;


public class Main {
    public static void main(String[] args) {
        // реализуйте алгоритм здесь
//        UserServiceJdbcImpl userServiceJdbc = new UserServiceJdbcImpl();
//        userServiceJdbc.createUsersTable();
//        userServiceJdbc.saveUser("Kerez", "Abulov", (byte)45);
//       UserServiceHibernateImpl userServiceHibernate = new UserServiceHibernateImpl();
//       userServiceHibernate.createUsersTable();
//       userServiceHibernate.dropUsersTable();
//       userServiceHibernate.saveUser("Argen", "Abdymomunov", (byte) 19);
//       userServiceHibernate.saveUser("Nurislam", "Nurkanov", (byte) 19);
//       userServiceHibernate.cleanUsersTable();
        UserDaoHibernateImpl userDao = new UserDaoHibernateImpl();
        userDao.dropUsersTable();
        userDao.createUsersTable();
        userDao.saveUser("testName", "testLastName", (byte) 13);

        User user = userDao.getAllUsers().get(0);
        System.out.println(userDao.getAllUsers().size());
    }
}
