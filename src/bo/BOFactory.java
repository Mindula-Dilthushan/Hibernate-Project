package bo;

import bo.custom.Impl.CustomerBOImpl;

public class BOFactory {
    public enum BOType{
        CUSTOMER
    }
    private static BOFactory boFactory;
    private BOFactory(){
    }
    public static BOFactory getBoFactory(){
        return (boFactory !=null) ?
                boFactory : (boFactory = new BOFactory());
    }
    public SuperBO getSuperBO(BOType boType){
        switch (boType){
            case CUSTOMER:
                return new CustomerBOImpl();
            default:
                return null;
        }
    }
}
