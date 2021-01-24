package dao;

import dao.custom.Impl.CustomerDAOImpl;
import dao.custom.Impl.ItemDAOImpl;
import dao.custom.Impl.OrderDAOImpl;

public class DAOFactory {
    public enum DAOType{
        CUSTOMER,
        ITEM,
        ORDER
    }
    private static DAOFactory daoFactory;
    private DAOFactory(){
    }
    public static DAOFactory getDaoFactory(){
        return (daoFactory !=null) ?
                daoFactory : (daoFactory = new DAOFactory());
    }
    public SuperDAO getSuperDAO(DAOType daoType){
        switch (daoType){
            case CUSTOMER:
                return new CustomerDAOImpl();
            case ITEM:
                return new ItemDAOImpl();
            case ORDER:
                return new OrderDAOImpl();
            default:
                return null;
        }
    }

}
