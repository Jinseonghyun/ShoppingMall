package shop.shoppingmall.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.amqp.RabbitConnectionDetails;
import org.springframework.core.annotation.Order;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.boot.autoconfigure.amqp.RabbitConnectionDetails.*;

@Entity
@Getter @Setter
public class Member {

    @Id @GeneratedValue // 시퀀스 값을 사용하기 위함
    @Column(name = "member_id") // Fk(외래키)가 MEMBER_ID
    private Long id;

    private String name;

    @Embedded // 내장 타입을 포함했다.
    private Address address;

    @OneToMany(mappedBy = "member")
    private List<Order> orders = new ArrayList<>();