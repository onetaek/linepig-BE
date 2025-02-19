package com.shop.linepig.domain.common.embeddable;

import lombok.*;

import javax.persistence.Embeddable;
@Builder
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class UploadFile {

    private Integer sequence;
    private String uploadFileLink;
    private String originFileName;
}
