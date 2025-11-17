package Controller.Item;

import Model.DTO.ItemInfoDto;
import javafx.collections.ObservableList;

public interface ItemService {

        void addItemInfo(String itemCode,String description,String packSize,double unitPrice,int qtyOnHand);

        void updateItemInfo(String itemCode,String description,String packSize,double unitPrice,int qtyOnHand);

        void deleteItemInfo(String itemCode);

        ObservableList<ItemInfoDto> loadItemTable();


}
