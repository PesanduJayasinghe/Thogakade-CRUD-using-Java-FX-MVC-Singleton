package Controller.Item;

import Model.DTO.ItemInfoDto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class ItemInfoControl implements Initializable {

    ObservableList<ItemInfoDto> itemInfoArray = FXCollections.observableArrayList();
    ItemController itemController=new ItemController();

    @FXML
    private TableView<ItemInfoDto> tblItem;

    @FXML
    private TableColumn<?, ?> col_item_code;

    @FXML
    private TableColumn<?, ?> col_description;

    @FXML
    private TableColumn<?, ?> col_packsize;

    @FXML
    private TableColumn<?, ?> col_qty_on_hand;

    @FXML
    private TableColumn<?, ?> col_unit_price;

    @FXML
    private TextField txtItemCode;

    @FXML
    private TextField txtDescription;

    @FXML
    private TextField txtPackSize;

    @FXML
    private TextField txtQtyOnHand;

    @FXML
    private TextField txtUnitPrice;


    // ---------- BUTTON HANDLERS ----------

    @FXML
    void btnAdd(ActionEvent event) {
        String itemCode = txtItemCode.getText();
        String description = txtDescription.getText();
        String packSize = txtPackSize.getText() + txtMeasurement.getValue();
        int qtyOnHand = Integer.parseInt(txtQtyOnHand.getText());
        double unitPrice = Double.parseDouble(txtUnitPrice.getText());

        itemController.addItemInfo(itemCode,description,packSize,unitPrice,qtyOnHand);

        loadItemDetails();
        clearFields();
    }

    @FXML
    void btnUpdate(ActionEvent event) {

        String itemCode = txtItemCode.getText();
        String description = txtDescription.getText();
        String packSize = txtPackSize.getText() + txtMeasurement.getValue();
        int qtyOnHand = Integer.parseInt(txtQtyOnHand.getText());
        double unitPrice = Double.parseDouble(txtUnitPrice.getText());

        itemController.updateItemInfo(itemCode,description,packSize,unitPrice,qtyOnHand);

        loadItemDetails();
        clearFields();
    }

    @FXML
    void btnDelete(ActionEvent event) {

        itemController.deleteItemInfo( txtItemCode.getText() );

        loadItemDetails();
        clearFields();
    }

    @FXML
    void btnCustomerManage(ActionEvent event) {}

    @FXML
    void btnSupplierManage(ActionEvent event) {}

    @FXML
    void btnEmployeeManage(ActionEvent event) {}


    @FXML
    private ComboBox<String> txtMeasurement;

    // ---------- INITIALIZATION ----------

    @Override @FXML
    public void initialize(URL url, ResourceBundle resourceBundle) {
        col_item_code.setCellValueFactory(new PropertyValueFactory<>("itemCode"));
        col_description.setCellValueFactory(new PropertyValueFactory<>("description"));
        col_packsize.setCellValueFactory(new PropertyValueFactory<>("packSize"));
        col_qty_on_hand.setCellValueFactory(new PropertyValueFactory<>("qtyOnHand"));
        col_unit_price.setCellValueFactory(new PropertyValueFactory<>("unitPrice"));

        loadItemDetails();

        tblItem.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                txtItemCode.setText(newValue.getItemCode());
                txtDescription.setText(newValue.getDescription());
                txtPackSize.setText(newValue.getPackSizeNumber());
                txtMeasurement.setValue(newValue.getPackSizeUnit());
                txtQtyOnHand.setText(String.valueOf(newValue.getQtyOnHand()));
                txtUnitPrice.setText(String.valueOf(newValue.getUnitPrice()));
            }
        });

        txtMeasurement.getItems().addAll(
          "kg",
          "g",
          "L",
          "ml"
        );

        txtMeasurement.setValue("kg");
    }


    // ---------- HELPER METHODS ----------

    private void loadItemDetails() {
        itemInfoArray.clear();
        tblItem.setItems(itemController.loadItemTable());
    }

    private void clearFields() {
        txtItemCode.clear();
        txtDescription.clear();
        txtPackSize.clear();
        txtQtyOnHand.clear();
        txtUnitPrice.clear();
        txtMeasurement.setValue(null);
    }
}
