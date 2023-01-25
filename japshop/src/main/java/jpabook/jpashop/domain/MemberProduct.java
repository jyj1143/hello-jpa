package jpabook.jpashop.domain;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class MemberProduct {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn("MEMBER_ID")
    private Member member;

    @ManyToOne
    @JoinColumn("PRODUCT_ID")
    private Product product;


    private int count;
    private int price;
    private LocalDateTime orderDateTime;

}
