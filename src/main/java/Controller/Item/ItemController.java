package Controller.Item;

import DB.DBConnection;
import Model.DTO.ItemInfoDto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ItemController implements ItemService{
    @Override
    public void addItemInfo(String itemCode, String description, String packSize, double unitPrice, int qtyOnHand) {
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement ps = connection.prepareStatement("INSERT INTO item VALUES (?, ?, ?, ?, ?)");
            ps.setObject(1, itemCode);
            ps.setObject(2, description);
            ps.setObject(3, packSize);
            ps.setObject(4, unitPrice);
            ps.setObject(5, qtyOnHand);
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateItemInfo(String itemCode, String description, String packSize, double unitPrice, int qtyOnHand) {
        try  {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement ps = connection.prepareStatement(
                    "UPDATE item SET description=?, packsize=?, unitPrice=?, qtyOnHand=? WHERE itemCode=?"
            );
            ps.setObject(1, description);
            ps.setObject(2, packSize);
            ps.setObject(3, unitPrice);
            ps.setObject(4, qtyOnHand);
            ps.setObject(5, itemCode);
            ps.executeUpdate();



        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteItemInfo(String itemCode) {
        try {
            Connection connection =DBConnection.getInstance().getConnection();
            PreparedStatement ps = connection.prepareStatement(
                    "DELETE FROM item WHERE itemCode=?"
            );
            ps.setObject(1, itemCode );
            ps.executeUpdate();



        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ObservableList<ItemInfoDto> loadItemTable() {
        ObservableList<ItemInfoDto> itemInfoArray = FXCollections.observableArrayList();

        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM item");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                itemInfoArray.add(new ItemInfoDto(
                        rs.getString("itemCode"),
                        rs.getString("description"),
                        rs.getString("PackSize"),
                        rs.getDouble("unitPrice"),
                        rs.getInt("qtyOnHand")
                ));
            }



        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return itemInfoArray;
    }
}
