package Controller.Orders;

import Model.DTO.OrderInfoDto;
import javafx.collections.ObservableList;

public interface OrderService {

    void addOrderInfo(String orderId, String orderDate, String custId);

    void updateOrderInfo(String orderId, String orderDate, String custId);

    void deleteOrderInfo(String orderId);

    ObservableList<OrderInfoDto> loadOrderTable();
}
