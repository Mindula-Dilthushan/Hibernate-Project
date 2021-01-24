package controller;

import bo.BOFactory;
import bo.custom.CustomerBO;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import dto.CustomerDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
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
    public TableView<CustomerTM> tblCustomer;
    public TableColumn<CustomerTM,String>colId, colName, colAddress, colSalary;
    public JFXButton btnSave;
    public JFXButton btnUpdate;
    public JFXButton btnDelete;

    CustomerBO customerBO = (CustomerBO) BOFactory.getBoFactory().getSuperBO(BOFactory.BOType.CUSTOMER);

    public void initialize() {
        colId.setCellValueFactory(new PropertyValueFactory<>("customerID"));
        colName.setCellValueFactory(new PropertyValueFactory<>("customerName"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("customerAddress"));
        colSalary.setCellValueFactory(new PropertyValueFactory<>("customerSalary"));
        lordAllCustomer();
    }
    private void lordAllCustomer() {
        try {
            ObservableList<CustomerTM> customerTMObservableList = FXCollections.observableArrayList();
            List<CustomerDTO> customerDTOList = customerBO.getAllCustomer();
            for (CustomerDTO customerDTO: customerDTOList){
                CustomerTM customerTM = new CustomerTM(
                        customerDTO.getId(),
                        customerDTO.getName(),
                        customerDTO.getAddress(),
                        customerDTO.getSalary()
                );
                System.out.println("customerDTOList = " + customerDTOList);
                System.out.println("customerTMObservableList = " + customerTMObservableList);
                customerTMObservableList.add(customerTM);
                tblCustomer.setItems(customerTMObservableList);
            }
        }catch (Exception e){
        }
    }
    public void btnDeleteOnAction(ActionEvent actionEvent) {
        try {
            CustomerDTO customerDTO = customers();
                if (!customerBO.deleteCustomer(customerDTO.getId())){
                    System.out.println("Deleted Customer");
                    new Alert(Alert.AlertType.INFORMATION, "Delete Customer..!").show();
                    clearText();
                }else {
                    System.out.println("No Deleted");
                    new Alert(Alert.AlertType.ERROR, "Error").show();
                }
        }catch (Exception e){
        }
    }
    public void btnUpdateOnAction(ActionEvent actionEvent) {
        try{
            CustomerDTO customerDTO = customers();
            boolean update = customerBO.updateCustomer(customerDTO);
            if (!update){
                System.out.println("updated");
                new Alert(Alert.AlertType.INFORMATION, "Update Customer Success..!").show();
                clearText();
            }else {
                System.out.println("no update");
                new Alert(Alert.AlertType.ERROR, "Error").show();
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
                new Alert(Alert.AlertType.INFORMATION, "Saved Customer..!").show();
                clearText();
            }else {
                new Alert(Alert.AlertType.ERROR, "Not Save Customer").show();
            }
        } catch (Exception e) {
        }
    }
    public void txtIdOnAction(ActionEvent actionEvent) throws Exception {
        try {

            CustomerDTO customerDTO = customerBO.searchCustomer(txtId.getText());
            if (customerDTO != null) {
                System.out.println(customerDTO);
                txtId.setText(customerDTO.getId());
                txtName.setText(customerDTO.getName());
                txtAddress.setText(customerDTO.getAddress());
                txtSalary.setText(String.valueOf(customerDTO.getSalary()));
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }catch (Exception e){
        }
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
