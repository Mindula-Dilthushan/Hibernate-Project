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
            session.close();
        return true;
    }
    @Override
    public boolean update(Customer entity) throws Exception {
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        session.update(entity);
        transaction.commit();
        session.close();
        return false;
    }
    @Override
    public boolean delete(String s) throws Exception {
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        Customer customer = session.get(Customer.class,s);
        session.delete(customer);
        transaction.commit();
        return false;
    }
    @Override
    public Customer search(String s) throws Exception {
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        Customer customer = session.get(Customer.class,s);
        transaction.commit();
        session.close();
        return customer;
    }
    @Override
    public List<Customer> getAll() throws Exception {
        return null;
    }
}
