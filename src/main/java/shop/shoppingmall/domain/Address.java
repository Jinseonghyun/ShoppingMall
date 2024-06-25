package shop.shoppingmall.domain;

import jakarta.persistence.Embeddable;
import lombok.Getter;

@Embeddable
@Getter
public class Address { // adress 는 jpa의 내장타입 // 값 타입(변경이 되면 안된다.)

    private String city;
    private String street;
    private String zipcode;

    // new 생성 방지 (값 타입 특징)
    protected Address() {
    }

    // 생성할 때만 값 생성 변경 불가
    public Address(String city, String street, String zipcode) {
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }
}
