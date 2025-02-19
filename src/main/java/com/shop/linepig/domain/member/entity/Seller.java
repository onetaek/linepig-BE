package com.shop.linepig.domain.member.entity;

import com.shop.linepig.domain.common.mappedsuperclass.BaseEntity;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@AllArgsConstructor
@Getter
@Entity
@SQLDelete(sql = "UPDATE SELLER SET deleted = 1, deleted_on = CURRENT_TIMESTAMP WHERE id = ?")
@Where(clause = "deleted = false")
public class Seller extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "seller", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SellerExtend> sellerExtends = new ArrayList<>();

    @OneToOne
    private Member member;

    public Seller update(List<SellerExtend> sellerExtends) {
        this.sellerExtends = sellerExtends;
        return this;
    }

    public Seller setSellerExtends(List<SellerExtend> sellerExtends) {
        this.sellerExtends = sellerExtends;
        return this;
    }
    @Override
    public String toString() {
        return "Seller{" +
                "id=" + id +
                ", sellerExtends=" + (sellerExtends != null ? sellerExtends.toString() : "null") +
                ", member=" + (member != null ? member.toString() : "null") +
                '}';
    }
}
