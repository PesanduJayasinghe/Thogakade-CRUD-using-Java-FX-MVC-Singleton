package Model.DTO;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class OrderInfoDto {

    private String orderId;
    private String orderDate;
    private String custId;

}
