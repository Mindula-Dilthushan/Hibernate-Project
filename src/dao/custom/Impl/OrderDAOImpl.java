package dao.custom.Impl;

import dao.custom.OrderDAO;
import entity.custom.Orders;
import java.util.List;

public class OrderDAOImpl implements OrderDAO {
    @Override
    public boolean add(Orders entity) throws Exception {
        return false;
    }

    @Override
    public boolean update(Orders entity) throws Exception {
        return false;
    }

    @Override
    public boolean delete(String s) throws Exception {
        return false;
    }

    @Override
    public Orders search(String s) throws Exception {
        return null;
    }

    @Override
    public List<Orders> getAll() throws Exception {
        return null;
    }
}
