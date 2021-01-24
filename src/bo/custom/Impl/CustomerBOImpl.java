package bo.custom.Impl;

import bo.custom.CustomerBO;
import dao.DAOFactory;
import dao.custom.CustomerDAO;
import dto.CustomerDTO;
import entity.custom.Customer;
import java.util.List;

public class CustomerBOImpl implements CustomerBO {

    private CustomerDAO customerDAO = (CustomerDAO) DAOFactory.getDaoFactory().getSuperDAO(DAOFactory.DAOType.CUSTOMER);

    @Override
    public boolean addCustomer(CustomerDTO customerDTO) throws Exception {
        return customerDAO.add(
                new Customer(
                        customerDTO.getId(),
                        customerDTO.getName(),
                        customerDTO.getAddress(),
                        customerDTO.getSalary()
                )
        );
    }
    @Override
    public boolean updateCustomer(CustomerDTO customerDTO) throws Exception {
        return customerDAO.update(
                new Customer(
                        customerDTO.getId(),
                        customerDTO.getName(),
                        customerDTO.getAddress(),
                        customerDTO.getSalary()
                )
        );
    }
    @Override
    public boolean deleteCustomer(String id) throws Exception {
        return customerDAO.delete(id);
    }
    @Override
    public CustomerDTO searchCustomer(String id) throws Exception {
       Customer customer=customerDAO.search(id);
       return new CustomerDTO(
               customer.getId(),
               customer.getName(),
               customer.getAddress(),
               customer.getSalary()
       );
    }
    @Override
    public List<CustomerDTO> getAllCustomer() throws Exception {
        return null;
    }
}
