package bo.custom.Impl;

import bo.custom.CustomerBO;
import dao.DAOFactory;
import dao.custom.CustomerDAO;
import dto.CustomerDTO;
import entity.custom.Customer;

import java.util.ArrayList;
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
    public boolean deleteCustomer(CustomerDTO customerDTO) throws Exception {
        return customerDAO.delete(
                new Customer(
                        customerDTO.getId(),
                        customerDTO.getName(),
                        customerDTO.getAddress(),
                        customerDTO.getSalary()
                )
        );
    }
    @Override
    public CustomerDTO searchCustomer(CustomerDTO customerDTO) throws Exception {
        return getCustomerDTO(customerDAO.search(getCustomer(customerDTO)));

    }
    @Override
    public List<CustomerDTO> getAllCustomer() throws Exception {
        List<CustomerDTO> customerDTO = new ArrayList<>();
        List<Customer> customerList = customerDAO.getAll();
        for (Customer customer : customerList){
            customerDTO.add(getCustomerDTO(customer));
        }
        return customerDTO;
    }
    private CustomerDTO getCustomerDTO(Customer customer){
        return new CustomerDTO(
                customer.getId(),
                customer.getName(),
                customer.getAddress(),
                customer.getSalary()
        );
    }
    private Customer getCustomer(CustomerDTO customerDTO){
        return new Customer(
                customerDTO.getId(),
                customerDTO.getName(),
                customerDTO.getAddress(),
                customerDTO.getSalary()
        );
    }
}
