package bo.custom;

import bo.SuperBO;
import dto.CustomerDTO;
import java.util.List;

public interface CustomerBO extends SuperBO {
    boolean addCustomer(CustomerDTO customerDTO)throws Exception;
    boolean updateCustomer(CustomerDTO customerDTO)throws Exception;
    boolean deleteCustomer(String id)throws Exception;
    CustomerDTO searchCustomer(String id)throws Exception;
    List<CustomerDTO> getAllCustomer()throws Exception;
}
