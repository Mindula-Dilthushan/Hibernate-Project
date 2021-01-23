package tm;

public class CustomerTM {
    private String customerID;
    private String customerName;
    private String customerAddress;
    private Double customerSalary;

    public CustomerTM() {
    }

    public CustomerTM(String customerID, String customerName, String customerAddress, Double customerSalary) {
        this.customerID = customerID;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.customerSalary = customerSalary;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public Double getCustomerSalary() {
        return customerSalary;
    }

    public void setCustomerSalary(Double customerSalary) {
        this.customerSalary = customerSalary;
    }

    @Override
    public String toString() {
        return "CustomerTM{" +
                "customerID='" + customerID + '\'' +
                ", customerName='" + customerName + '\'' +
                ", customerAddress='" + customerAddress + '\'' +
                ", customerSalary=" + customerSalary +
                '}';
    }
}
