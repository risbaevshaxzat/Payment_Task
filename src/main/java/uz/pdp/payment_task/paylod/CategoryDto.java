package uz.pdp.payment_task.paylod;

import lombok.Data;

@Data
public class CategoryDto {

    private String name;
    private Integer parentCategoryId;
}
