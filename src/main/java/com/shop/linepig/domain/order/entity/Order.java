package com.shop.linepig.domain.order.entity;


import com.shop.linepig.domain.common.mappedsuperclass.BaseEntity;
import com.shop.linepig.domain.member.entity.Member;
import com.shop.linepig.domain.order.entity.enumeration.OrderStatus;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.time.LocalDateTime;


@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@AllArgsConstructor
@Getter
@Table(name = "orders")
@Entity
@SQLDelete(sql = "UPDATE ORDERS SET deleted = 1, deleted_on = CURRENT_TIMESTAMP WHERE id = ?")
@Where(clause = "deleted = false")
public class Order extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int price;//가격

    private String card;//결제카드회사

    private LocalDateTime orderOn;//주문일

    @Enumerated(EnumType.STRING)
    private OrderStatus status;//주문 현황

    private String reason;//환불사요

    private String productName;//대표상품

    private String productImage;//대표 이미지

    private String country;//나라

    private String name;//이름

    private String streetAddress;//도로명주소

    private String city;//도시

    private String region;//지역

    private String zipCode;//우편번호

    private String customIdNumber;//개인 통관 고유번호

    private String phoneNumber;//받는 사람 연락처

    private String request;//요청사항

    @ManyToOne
    private Member member;//회원



}
