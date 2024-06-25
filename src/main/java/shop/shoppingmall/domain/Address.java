package shop.shoppingmall.domain;

import jakarta.persistence.Embeddable;
import lombok.Getter;

@Embeddable
@Getter
public class Address { // adress 는 jpa의 내장타입

    private String city;
    private String street;
    private String zipcode;
}
