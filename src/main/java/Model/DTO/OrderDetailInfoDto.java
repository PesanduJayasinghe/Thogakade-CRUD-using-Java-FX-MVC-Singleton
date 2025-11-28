package Model.DTO;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class OrderDetailInfoDto {

    private String orderId;
    private String itemCode;
    private int orderQty;
    private double discount;

}
