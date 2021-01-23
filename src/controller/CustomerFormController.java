package controller;

import bo.BOFactory;
import bo.custom.CustomerBO;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import dto.CustomerDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import tm.CustomerTM;

import java.util.List;

public class CustomerFormController {
    public JFXTextField txtId;
    public JFXTextField txtName;
    public JFXTextField txtAddress;
    public JFXTextField txtSalary;
    public TableView<CustomerDTO> tblCustomer;
    public TableColumn<CustomerTM,String>colId, colName, colAddress, colSalary;
    public JFXButton btnSave;
    public JFXButton btnUpdate;
    public JFXButton btnDelete;

    CustomerBO customerBO = (CustomerBO) BOFactory.getBoFactory().getSuperBO(BOFactory.BOType.CUSTOMER);
    ObservableList<CustomerDTO> customerTMObservableList = FXCollections.observableArrayList();
    List<CustomerDTO> customerDTOS = null;

    public void initialize() {
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colSalary.setCellValueFactory(new PropertyValueFactory<>("salary"));

        tblCustomer.setItems(customerTMObservableList);
        lordAllCustomer();

        System.out.println("customerTMObservableList = " + customerTMObservableList);
    }


    private void lordAllCustomer() {


        System.out.println("1111");

        try{
            List<CustomerDTO> customerDTOS = customerBO.getAllCustomer();
            System.out.println("customerDTOS 1  = " + customerDTOS);
            this.customerDTOS=customerDTOS;
            System.out.println("customerDTOS 2 = " + customerDTOS);
        }catch (Exception e){

        }

        System.out.println("2222");

    }

    public void btnDeleteOnAction(ActionEvent actionEvent) {
        try{
            CustomerDTO customerDTO = customers();
            boolean delete = customerBO.deleteCustomer(customerDTO);
            if (!delete){
                System.out.println("Deleted");
            }else {
                System.out.println("No");
            }
        }catch (Exception e){

        }

    }

    public void btnUpdateOnAction(ActionEvent actionEvent) {
        try{
            CustomerDTO customerDTO = customers();
            boolean update = customerBO.updateCustomer(customerDTO);
            if (update){
                System.out.println("yes");
            }else {
                System.out.println("no");
            }
        }catch (Exception e){

        }
    }

    public void btnSaveOnAction(ActionEvent actionEvent) {
        try {
            CustomerDTO customerDTO = customers();
            boolean save = customerBO.addCustomer(customerDTO);
            if (save) {
                System.out.println("save = " + save);
                clearText();
            }
        } catch (Exception e) {
        }
    }
    public void txtIdOnAction(ActionEvent actionEvent) {
    }

    private CustomerDTO customers() {
        return new CustomerDTO(
                txtId.getText(),
                txtName.getText(),
                txtAddress.getText(),
                Double.parseDouble(txtSalary.getText())
        );
    }

    private void clearText() {
        txtId.setText(null);
        txtName.setText(null);
        txtAddress.setText(null);
        txtSalary.setText(null);
    }
}
