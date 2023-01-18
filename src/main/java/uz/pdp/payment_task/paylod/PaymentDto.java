package uz.pdp.payment_task.paylod;

import lombok.Data;

import java.util.List;

@Data
public class PaymentDto {

    private String customerName;

    private String phoneNumber;

    private String email;

    private String address;

    private List<PurchaseDetailDto> purchaseDetails;

    private Integer currencyId;
}
