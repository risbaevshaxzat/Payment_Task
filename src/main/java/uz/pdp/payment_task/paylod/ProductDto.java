package uz.pdp.payment_task.paylod;

import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
public class ProductDto {

    private String name;

    @OneToOne
    private Integer photoId;

    private Double price;

    private Integer categoryId;
}
