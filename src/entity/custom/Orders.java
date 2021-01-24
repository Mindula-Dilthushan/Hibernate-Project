package entity.custom;

import entity.SuperEntity;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Date;
import java.util.List;

@Entity
public class Orders implements SuperEntity {
    @Id
    private String orderId;
    private String id;
    private Date date;
//    @ManyToMany
//    private Customer customer;
//    @ManyToMany
//    private List<Item> itemList;

    public Orders() {
    }

    public Orders(String orderId, String id, Date date) {
        this.orderId = orderId;
        this.id = id;
        this.date = date;
    }

//    public Order(String orderId, String id, Date date, Customer customer) {
//        this.orderId = orderId;
//        this.id = id;
//        this.date = date;
//        this.customer = customer;
//    }
//
//    public Order(String orderId, String id, Date date, Customer customer, List<Item> itemList) {
//        this.orderId = orderId;
//        this.id = id;
//        this.date = date;
//        this.customer = customer;
//        this.itemList = itemList;
//    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

//    public Customer getCustomer() {
//        return customer;
//    }
//
//    public void setCustomer(Customer customer) {
//        this.customer = customer;
//    }
//
//    public List<Item> getItemList() {
//        return itemList;
//    }
//
//    public void setItemList(List<Item> itemList) {
//        this.itemList = itemList;
//    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", id='" + id + '\'' +
                ", date=" + date +
//                ", customer=" + customer +
//                ", itemList=" + itemList +
                '}';
    }
}



