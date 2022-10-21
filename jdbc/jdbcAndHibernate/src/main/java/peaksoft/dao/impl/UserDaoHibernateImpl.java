package peaksoft.dao.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import peaksoft.dao.UserDao;
import peaksoft.model.User;
import peaksoft.util.HibernateUtil;

import java.util.List;

public class UserDaoHibernateImpl implements UserDao {

    public UserDaoHibernateImpl() {
    }
    private final SessionFactory sessionFactory = HibernateUtil.createSessionFactory();
    private final EntityManagerFactory entityManagerFactory = HibernateUtil.createEntityManagerFactory();
    @Override
    public void createUsersTable() {
        String query = "create table if not exists users(" +
                "id serial primary key, " +
                "name varchar(50) not null," +
                "lastName varchar(50) not null," +
                "age smallint not null);";
        Session session = HibernateUtil.createSessionFactory().openSession();
        session.beginTransaction();
        session.createNativeQuery(query).executeUpdate();
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void dropUsersTable() {
        String query = "drop table if exists users;";
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.createNativeQuery(query).executeUpdate();
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        User user = new User(name, lastName, age);
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(user);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void removeUserById(long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public List<User> getAllUsers() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        List<User> users = entityManager.createQuery("select u from User u").getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();


        return users;
    }

    @Override
    public void cleanUsersTable() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.createNativeQuery("truncate users").executeUpdate();
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
