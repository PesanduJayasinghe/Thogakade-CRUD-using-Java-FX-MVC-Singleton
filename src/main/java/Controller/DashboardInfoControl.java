package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class DashboardInfoControl {

    Stage stage=new Stage();

    @FXML
    void btnCustomer(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view/Customer_form.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.setTitle("Customer");
        stage.show();
    }

    @FXML
    void btnItem(ActionEvent event) throws IOException {
        Parent root=FXMLLoader.load(getClass().getResource("/View/Item_form.fxml"));
        stage=(Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.setTitle("Item");
        stage.show();
    }

    @FXML
    void btnOrder(ActionEvent event) throws IOException {
        Parent root=FXMLLoader.load(getClass().getResource("/view/Order_form.fxml"));
        stage= (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.setTitle("Order");
        stage.show();

    }

    @FXML
    void btnOrderDetail(ActionEvent event) throws IOException {
        Parent root=FXMLLoader.load(getClass().getResource("/view/OrderDetail_form.fxml"));
        stage=(Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.setTitle("Order Detail");
        stage.show();

    }

}