package CompanyManagementHelper.Utils;

import CompanyManagementHelper.Entity.UserEntity;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class HibernateUtils {
  private static final SessionFactory ourSessionFactory;

  static {
    try {
      Configuration configuration = new Configuration();
      configuration.configure("hibernate.cfg.xml");

      ourSessionFactory = configuration.buildSessionFactory();
    } catch (Throwable ex) {
      throw new ExceptionInInitializerError(ex);
    }
  }

  public static Session getSession() throws HibernateException {
    return ourSessionFactory.openSession();
  }

  public static void insert(Object o) {
    Session session = HibernateUtils.getSession();
    session.beginTransaction();
    session.save(o);
    session.getTransaction().commit();
  }

  public static void delete(Object o) {
    Session session = getSession();
    session.beginTransaction();
    session.delete(o);
    session.getTransaction().commit();
  }

  public static void update(Object o) {
    Session session = HibernateUtils.getSession();
    session.beginTransaction();
    session.update(o);
    session.getTransaction().commit();
  }

  public static <T> List<T> findAll(String className) {
    Session session = getSession();
    session.beginTransaction();
    List<T> list = session.createQuery("FROM " + className).list();
    session.getTransaction().commit();
    return list;
  }

  public static UserEntity findUserByEmail(String email) {
    Session session = getSession();
    session.beginTransaction();
    Query query = session.createQuery("FROM UserEntity WHERE email='" + email + "'");
    UserEntity userEntity = (UserEntity) query.getSingleResult();
    session.getTransaction().commit();
    return userEntity;
  }
}
