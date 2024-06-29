package shop.shoppingmall.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Entity
@Getter @Setter
public class Member {

    @Id @GeneratedValue // id 값이 항상 생성되어 있음을 보장
    @Column(name = "member_id") // name 안주면 아래 id 그대로 된다.
    private Long id;

    private String name;

    @Embedded
    private Address address;

    @OneToMany(mappedBy = "member") // 1대다 하나의 회원이 여러개 상품 주문가능 // 연관관계의 거울 // order table에 있는 member 필드에 의해 맵핑됐다
    private List<Order> orders = new ArrayList<>();
}
