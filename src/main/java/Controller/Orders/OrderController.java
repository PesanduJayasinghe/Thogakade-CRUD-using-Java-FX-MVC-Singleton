package Controller.Orders;

import DB.DBConnection;
import Model.DTO.OrderInfoDto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderController implements OrderService{

    @Override
    public void addOrderInfo(String orderId, String orderDate, String custId) {
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement ps = connection.prepareStatement(
                    "INSERT INTO orders VALUES (?, ?, ?)"
            );
            ps.setObject(1, orderId);
            ps.setObject(2, orderDate);
            ps.setObject(3, custId);
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateOrderInfo(String orderId, String orderDate, String custId) {
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement ps = connection.prepareStatement(
                    "UPDATE orders SET OrderDate=?, CustID=? WHERE OrderID=?"
            );
            ps.setObject(1, orderDate);
            ps.setObject(2, custId);
            ps.setObject(3, orderId);
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteOrderInfo(String orderId) {
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement ps = connection.prepareStatement(
                    "DELETE FROM orders WHERE OrderID=?"
            );
            ps.setObject(1, orderId);
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ObservableList<OrderInfoDto> loadOrderTable() {
        ObservableList<OrderInfoDto> orderInfoArray = FXCollections.observableArrayList();

        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM orders");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                orderInfoArray.add(new OrderInfoDto(
                        rs.getString("OrderID"),
                        rs.getString("OrderDate"),
                        rs.getString("CustID")
                ));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return orderInfoArray;
    }
}
