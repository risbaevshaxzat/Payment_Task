package uz.pdp.payment_task.paylod;

import lombok.Data;

@Data
public class PurchaseDetailDto {

    private Integer productId;

    private Integer productAmount;
}
