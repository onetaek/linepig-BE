package com.shop.linepig.domain.product.entity;

import com.shop.linepig.domain.common.embeddable.UploadFile;
import com.shop.linepig.domain.common.mappedsuperclass.BaseEntity;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@AllArgsConstructor
@Getter
@Entity
@SQLDelete(sql = "UPDATE PRODCT_DETAIL_IMAGE SET deleted = 1, deleted_on = CURRENT_TIMESTAMP WHERE id = ?")
@Where(clause = "deleted = false")
public class ProductDetailImage extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private UploadFile uploadFile;

    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;

    public static List<ProductDetailImage> createEntities(List<UploadFile> uploadFiles, Product savedProduct) {
        return uploadFiles
                .stream()
                .map(uploadfile -> ProductDetailImage.builder()
                        .uploadFile(uploadfile)
                        .product(savedProduct)
                        .build()
                ).collect(Collectors.toList());
    }
}
