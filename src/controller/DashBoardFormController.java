package controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import java.io.IOException;

public class DashBoardFormController {

    public JFXButton btnCust;
    public JFXButton btnItem;
    public JFXButton btnOrder;
    public JFXButton btnOrderDetail;
    public AnchorPane mainAnchor;
    public JFXButton btnPlaceOrder;

    public void btnOrderDetailOnAction(ActionEvent actionEvent) {
    }

    public void btnOrderOnAction(ActionEvent actionEvent) {
    }

    public void btnItemOnAction(ActionEvent actionEvent) {
        lordAnchor("ItemForm.fxml");
    }

    public void btnCustOnAction(ActionEvent actionEvent) {
        lordAnchor("CustomerForm.fxml");
    }

    public void btnPlaceOrderOnAction(ActionEvent actionEvent) {
    }
    private void lordAnchor(String location) {
        try {
            mainAnchor.getChildren().clear();
            AnchorPane load = FXMLLoader.load(this.getClass().getResource("/view/"+location));
            mainAnchor.getChildren().addAll(load.getChildren());
        } catch (IOException e) {
        }
    }
}
