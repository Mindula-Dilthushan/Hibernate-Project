package dao.custom.Impl;

import dao.custom.ItemDAO;
import entity.custom.Item;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;
import java.util.List;

public class ItemDAOImpl implements ItemDAO {

    @Override
    public boolean add(Item entity) throws Exception {
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        session.save(entity);
        transaction.commit();
        session.close();
        return true;
    }
    @Override
    public boolean update(Item entity) throws Exception {
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
        Item item = session.get(Item.class,s);
        session.delete(item);
        transaction.commit();
        return false;
    }
    @Override
    public Item search(String s) throws Exception {
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        Item item = session.get(Item.class,s);
        transaction.commit();
        session.close();
        return item;
    }
    @Override
    public List<Item> getAll() throws Exception {
        return null;
    }
}
