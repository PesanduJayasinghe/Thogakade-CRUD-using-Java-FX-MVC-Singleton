package Controller.Orders;

import Model.DTO.OrderInfoDto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class OrderInfoControl implements Initializable {

    ObservableList<OrderInfoDto> orderInfoArray= FXCollections.observableArrayList();
    OrderController orderController=new OrderController();

    @FXML
    private TableColumn<?, ?> col_cust_id;

    @FXML
    private TableColumn<?, ?> col_order_date;

    @FXML
    private TableColumn<?, ?> col_order_id;

    @FXML
    private TableView<OrderInfoDto> tblOrder;

    @FXML
    private TextField txtCustId;

    @FXML
    private TextField txtOrderId;

    @FXML
    private TextField txtorderDate;

    @FXML
    void btnAdd(ActionEvent event) {
        String custId=txtCustId.getText();
        String orderId=txtOrderId.getText();
        String orderDate=txtorderDate.getText();

        orderController.addOrderInfo(orderId,orderDate,custId);

        loadOrderDetails();
        clearFields();
    }

    @FXML
    void btnCustomer(ActionEvent event) {

    }

    @FXML
    void btnDelete(ActionEvent event) {
        orderController.deleteOrderInfo(txtOrderId.getText());

        loadOrderDetails();
        clearFields();
    }

    @FXML
    void btnItem(ActionEvent event) {

    }

    @FXML
    void btnMenu(ActionEvent event) {

    }

    @FXML
    void btnOrderDetail(ActionEvent event) {

    }

    @FXML
    void btnUpdate(ActionEvent event) {
        String custId=txtCustId.getText();
        String orderId=txtOrderId.getText();
        String orderDate=txtorderDate.getText();

        orderController.updateOrderInfo(orderId,orderDate,custId);

        loadOrderDetails();
        clearFields();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        col_cust_id.setCellValueFactory(new PropertyValueFactory<>("custId"));
        col_order_date.setCellValueFactory(new PropertyValueFactory<>("orderDate"));
        col_order_id.setCellValueFactory(new PropertyValueFactory<>("orderId"));

        loadOrderDetails();

        tblOrder.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue!=null){
                txtOrderId.setText(newValue.getOrderId());
                txtorderDate.setText(newValue.getOrderDate());
                txtCustId.setText(newValue.getCustId());
            }

        });

    }

    private void loadOrderDetails(){
        orderInfoArray.clear();
        tblOrder.setItems(orderController.loadOrderTable());
    }

    private void clearFields(){
        txtCustId.clear();
        txtorderDate.clear();
        txtOrderId.clear();
    }
}
