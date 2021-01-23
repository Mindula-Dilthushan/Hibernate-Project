package bo.custom;

import bo.SuperBO;
import dto.CustomerDTO;
import java.util.List;

public interface CustomerBO extends SuperBO {
    boolean addCustomer(CustomerDTO customerDTO)throws Exception;
    boolean updateCustomer(CustomerDTO customerDTO)throws Exception;
    boolean deleteCustomer(CustomerDTO customerDTO)throws Exception;
    CustomerDTO searchCustomer(CustomerDTO customerDTO)throws Exception;
    List<CustomerDTO> getAllCustomer()throws Exception;
}
