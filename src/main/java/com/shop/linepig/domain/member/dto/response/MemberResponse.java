package com.shop.linepig.domain.member.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.shop.linepig.domain.member.entity.Member;
import lombok.Builder;
import lombok.Getter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
@Getter
public class MemberResponse {

    private Long id;
    private String loginId;
    private String phoneCode;
    private String phoneNumber;
    private String email;
    private String memberStatus;
    private String name;
    private String gender;
    private SellerResponse seller;

    public static MemberResponse fromEntity(Member member) {
        if(member == null)
            return null;
        return MemberResponse.builder()
                .id(member.getId())
                .loginId(member.getLoginId())
                .phoneCode(member.getPhoneCode())
                .phoneNumber(member.getPhoneNumber())
                .email(member.getEmail())
                .memberStatus(member.getMemberStatus())
                .name(member.getName())
                .gender(member.getGender())
                .seller(SellerResponse.fromEntity(member.getSeller()))
                .build();
    }
}
