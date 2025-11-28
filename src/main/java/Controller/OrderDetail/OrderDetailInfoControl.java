package Controller.OrderDetail;

import Controller.Orders.OrderDetailController;
import Model.DTO.OrderDetailInfoDto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Button;


import java.net.URL;
import java.util.ResourceBundle;

public class OrderDetailInfoControl implements Initializable {

    ObservableList<OrderDetailInfoDto> orderDetailInfoArray= FXCollections.observableArrayList();
    OrderDetailController orderDetailController=new OrderDetailController();


    @FXML
    private TableColumn<?, ?> col_discount;

    @FXML
    private TableColumn<?, ?> col_item_code;

    @FXML
    private TableColumn<?, ?> col_order_id;

    @FXML
    private TableColumn<?, ?> col_order_qty;

    @FXML
    private TableView<OrderDetailInfoDto> tblOrder;

    @FXML
    private TextField txtDiscount;

    @FXML
    private TextField txtItemCode;

    @FXML
    private TextField txtOrderId;

    @FXML
    private TextField txtOrderQty;


    @FXML
    void btnCustomer(ActionEvent event) {

    }


    @FXML
    void btnItem(ActionEvent event) {

    }

    @FXML
    void btnMenu(ActionEvent event) {

    }

    @FXML
    void btnOrder(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        col_item_code.setCellValueFactory(new PropertyValueFactory<>("itemCode"));
        col_order_qty.setCellValueFactory(new PropertyValueFactory<>("orderQty"));
        col_order_id.setCellValueFactory(new PropertyValueFactory<>("orderId"));
        col_discount.setCellValueFactory(new PropertyValueFactory<>("discount"));

        loadOrderDetails();

        tblOrder.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue!=null){
                txtOrderId.setText(newValue.getOrderId());
                txtItemCode.setText(newValue.getItemCode());
                txtOrderQty.setText(String.valueOf(newValue.getOrderQty()));
                txtDiscount.setText(String.valueOf(newValue.getDiscount()));

            }

        });


    }

    private void loadOrderDetails(){
        orderDetailInfoArray.clear();
        tblOrder.setItems(orderDetailController.loadOrderDetailTable());
    }

    private void clearFields(){
        txtDiscount.clear();
        txtOrderQty.clear();
        txtOrderId.clear();
        txtItemCode.clear();
    }
}
