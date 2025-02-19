package com.shop.linepig.domain.board.entity;

import com.shop.linepig.domain.board.entity.enumeration.BoardCategory;
import com.shop.linepig.domain.board.entity.enumeration.BoardStatus;
import com.shop.linepig.domain.board.entity.enumeration.BoardType;
import com.shop.linepig.domain.common.embeddable.UploadFile;
import com.shop.linepig.domain.common.mappedsuperclass.BaseEntity;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import javax.persistence.*;
import java.time.LocalDateTime;

//https://hot-10.com/board/product/list.html
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@AllArgsConstructor
@Getter
@EnableJpaAuditing
@Entity
@SQLDelete(sql = "UPDATE BOARD SET deleted = 1, deleted_on = CURRENT_TIMESTAMP WHERE id = ?")
@Where(clause = "deleted = false")
public class Board extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titleKo;//제목
    private String titleEn;//제목

    private String subTitleKo;//부제목
    private String subTitleEn;//부제목

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "sequence", column = @Column(name = "image_sequence")),
            @AttributeOverride(name = "uploadFileLink", column = @Column(name = "upload_file_link")),
            @AttributeOverride(name = "originFileName", column = @Column(name = "origin_file_name"))
    })
    private UploadFile image;

    @Lob
    private String contentKo;//글내용
    @Lob
    private String contentEn;//글내용

    private Long adminId;
    private Long memberId;

    private String writer;//작성자

    private LocalDateTime writtenOn;//게시글 작성일

    private Boolean isTop;//상단에 위치할 게시글인지 아닌지

    private Boolean isHidden;//비밀글 여부

    private int viewCount;//조회수

    private Integer sequence;//순서

    private String password;//게시글 비밀번호

    @Enumerated(EnumType.STRING)
    private BoardCategory category;//카테고리

    @Enumerated(EnumType.STRING)
    private BoardStatus status;//상태

    @Enumerated(EnumType.STRING)
    private BoardType type;//상태

    public void updateByAdmin(String titleKo, String titleEn, String contentKo, String contentEn, Boolean isTop, BoardCategory category, BoardStatus status) {
        this.titleKo = titleKo;
        this.titleEn = titleEn;
        this.contentKo = contentKo;
        this.contentEn = contentEn;
        this.isTop = isTop;
        this.category = category;
        this.status = status;
    }

    public void updateByUser(String content) {
        this.contentKo = content;
        this.contentEn = content;
    }
}
