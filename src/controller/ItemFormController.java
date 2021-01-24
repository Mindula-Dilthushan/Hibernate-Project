package controller;

import bo.BOFactory;
import bo.custom.ItemBO;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import dto.ItemDTO;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class ItemFormController {

    public JFXTextField txtCode;
    public JFXTextField txtDesc;
    public JFXTextField txtQty;
    public JFXTextField txtUnitPrice;
    public TableView tblItem;
    public TableColumn colCode;
    public TableColumn colDescription;
    public TableColumn colQty;
    public TableColumn colUnitPrice;
    public JFXButton btnSave;
    public JFXButton btnUpdate;
    public JFXButton btnDelete;

    ItemBO itemBO = (ItemBO) BOFactory.getBoFactory().getSuperBO(BOFactory.BOType.ITEM);

    public void initialize() {

    }
    public void btnDeleteOnAction(ActionEvent actionEvent) {
        try {
            ItemDTO itemDTO = items();
            if (!itemBO.deleteItem(itemDTO.getCode())){
                System.out.println("yes");
                new Alert(Alert.AlertType.INFORMATION, "Delete Item..!").show();
                clearText();
            }else {
                System.out.println("no");
                new Alert(Alert.AlertType.ERROR, "Error").show();
            }
        }catch (Exception e){
        }
    }
    public void btnUpdateOnAction(ActionEvent actionEvent) {
        try{
            ItemDTO itemDTO = items();
            boolean update = itemBO.updateItem(itemDTO);
            if (!update){
                System.out.println("updated");
                new Alert(Alert.AlertType.INFORMATION, "Update Item Success..!").show();
                clearText();
            }else {
                System.out.println("no update");
                new Alert(Alert.AlertType.ERROR, "Not Updated").show();
            }
        }catch (Exception e){
        }
    }
    public void btnSaveOnAction(ActionEvent actionEvent) {
        try {
            ItemDTO itemDTO = items();
            boolean save = itemBO.addItem(itemDTO);
            if (save) {
                System.out.println("save = " + save);
                new Alert(Alert.AlertType.INFORMATION, "Saved Item..!").show();
                clearText();
            }else {
                new Alert(Alert.AlertType.ERROR, "Not Save Item").show();
            }
        } catch (Exception e) {
        }
    }
    public void txtCodeOnAction(ActionEvent actionEvent) {
        try {
            ItemDTO itemDTO = itemBO.searchItem(txtCode.getText());
            if (itemDTO != null) {
                System.out.println(itemDTO);
                txtCode.setText(itemDTO.getCode());
                txtDesc.setText(itemDTO.getDescription());
                txtQty.setText(String.valueOf(itemDTO.getPrice()));
                txtUnitPrice.setText(String.valueOf(itemDTO.getQtyOnHand()));
            } else {
            }
        }catch (Exception e){
        }
    }
    private ItemDTO items() {
        return new ItemDTO(
                txtCode.getText(),
                txtDesc.getText(),
                Double.parseDouble(txtQty.getText()),
                Integer.valueOf(txtUnitPrice.getText())
        );
    }
    private void clearText() {
        txtCode.setText(null);
        txtDesc.setText(null);
        txtQty.setText(null);
        txtUnitPrice.setText(null);
    }
}
