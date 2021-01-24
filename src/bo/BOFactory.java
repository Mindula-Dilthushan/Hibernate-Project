package bo;

import bo.custom.Impl.CustomerBOImpl;
import bo.custom.Impl.ItemBOImpl;
import bo.custom.Impl.OrderBOImpl;

public class BOFactory {
    public enum BOType{
        CUSTOMER,
        ITEM,
        ORDER
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
            case ITEM:
                return new ItemBOImpl();
            case ORDER:
                return new OrderBOImpl();
            default:
                return null;
        }
    }
}
