package Controller.Orders;

import Controller.OrderDetail.OrderDetailService;
import DB.DBConnection;
import Model.DTO.OrderDetailInfoDto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderDetailController implements OrderDetailService {

    @Override
    public void addOrderDetailInfo(String orderId, String itemCode, int orderQty, double discount) {
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement ps = connection.prepareStatement(
                    "INSERT INTO orderdetail VALUES (?, ?, ?, ?)"
            );
            ps.setObject(1, orderId);
            ps.setObject(2, itemCode);
            ps.setObject(3, orderQty);
            ps.setObject(4, discount);
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateOrderDetailInfo(String orderId, String itemCode, int orderQty, double discount) {
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement ps = connection.prepareStatement(
                    "UPDATE orderdetail SET OrderQTY=?, Discount=? WHERE OrderID=? AND ItemCode=?"
            );
            ps.setObject(1, orderQty);
            ps.setObject(2, discount);
            ps.setObject(3, orderId);
            ps.setObject(4, itemCode);
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteOrderDetailInfo(String orderId, String itemCode) {
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement ps = connection.prepareStatement(
                    "DELETE FROM orderdetail WHERE OrderID=? AND ItemCode=?"
            );
            ps.setObject(1, orderId);
            ps.setObject(2, itemCode);
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ObservableList<OrderDetailInfoDto> loadOrderDetailTable() {
        ObservableList<OrderDetailInfoDto> detailsArray = FXCollections.observableArrayList();

        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM orderdetail");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                detailsArray.add(new OrderDetailInfoDto(
                        rs.getString("OrderID"),
                        rs.getString("ItemCode"),
                        rs.getInt("OrderQTY"),
                        rs.getInt("Discount")
                ));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return detailsArray;
    }
}
