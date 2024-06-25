package shop.shoppingmall.domain.item;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import shop.shoppingmall.domain.Item;

@Entity
@DiscriminatorValue("C")
@Getter @Setter
public class Movie extends Item {

    private String director;
    private String actor;
}
