package Model.DTO;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ItemInfoDto {

    private String itemCode;
    private String description;
    private String packSize;
    private double unitPrice;
    private int qtyOnHand;

    public String getPackSizeNumber() {
        return packSize.replaceAll("[^0-9]", "");  // extract digits
    }

    public String getPackSizeUnit() {
        return packSize.replaceAll("[0-9]", "");   // extract letters
    }

}
