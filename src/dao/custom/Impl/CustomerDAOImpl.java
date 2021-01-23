package dao.custom.Impl;

import dao.custom.CustomerDAO;
import entity.custom.Customer;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;
import java.util.List;

public class CustomerDAOImpl implements CustomerDAO {



    @Override
    public boolean add(Customer entity) throws Exception {
        Session session = HibernateUtil.getSession();
            Transaction transaction = session.beginTransaction();
            session.save(entity);
            transaction.commit();
        return true;
    }
    @Override
    public boolean update(Customer entity) throws Exception {
        Session session = HibernateUtil.getSession();
            session.beginTransaction();
            session.update(entity);
            session.getTransaction().commit();
        return false;
    }
    @Override
    public boolean delete(Customer entity) throws Exception {
        Session session = HibernateUtil.getSession();
            session.beginTransaction();
            session.delete(entity);
            session.getTransaction().commit();
        return false;
    }
    @Override
    public Customer search(Customer entity) throws Exception {
        Session session = HibernateUtil.getSession();
            session.beginTransaction();
            Customer customer = session.find(Customer.class,entity.getId());
            session.getTransaction().commit();
        return customer;
    }
    @Override
    public List<Customer> getAll() throws Exception {
        Session session = HibernateUtil.getSession();
            session.beginTransaction();
            List<Customer> customerList = session.createNamedQuery("SELECT * FROM customer",Customer.class).list();
            session.getTransaction().commit();
        System.out.println("3333");
        return customerList;
    }
}
