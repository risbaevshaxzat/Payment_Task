package uz.pdp.payment_task.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product extends AbsEntity {

    @OneToOne
    private Attachment photo;

    private Double price;

    @ManyToOne(optional = false)
    private Category category;

}
