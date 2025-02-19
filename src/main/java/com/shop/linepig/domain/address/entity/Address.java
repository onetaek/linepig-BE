package com.shop.linepig.domain.address.entity;

import com.shop.linepig.domain.common.mappedsuperclass.BaseEntity;
import com.shop.linepig.domain.member.entity.Member;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@AllArgsConstructor
@Getter
@Entity
@SQLDelete(sql = "UPDATE ADDRESS SET deleted = 1, deleted_on = CURRENT_TIMESTAMP WHERE id = ?")
@Where(clause = "deleted = false")
public class Address extends BaseEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
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
