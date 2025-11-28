package Controller.OrderDetail;

import Model.DTO.OrderDetailInfoDto;
import javafx.collections.ObservableList;

public interface OrderDetailService {

    void addOrderDetailInfo(String orderId, String itemCode, int orderQty, double discount);

    void updateOrderDetailInfo(String orderId, String itemCode, int orderQty, double discount);

    void deleteOrderDetailInfo(String orderId, String itemCode);

    ObservableList<OrderDetailInfoDto> loadOrderDetailTable();

}
