package dao;

import dao.custom.Impl.CustomerDAOImpl;

public class DAOFactory {
    public enum DAOType{
        CUSTOMER
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
            default:
                return null;
        }
    }

}
