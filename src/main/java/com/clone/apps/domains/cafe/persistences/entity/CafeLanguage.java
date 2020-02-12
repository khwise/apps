package com.clone.apps.domains.cafe.persistences.entity;

import com.clone.apps.commons.entity.Auditable;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by kh.jin on 2020. 1. 11.
 */
@Entity
@Table(name = "tb_cafe_language")
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = false)
public class CafeLanguage extends Auditable<Long> {
    @EmbeddedId
    protected PK pk;

    @Column(name = "cafe_nm")
    @Getter private String cafeName;

    @Column(name = "cafe_desc")
    @Getter private String description;

    @Getter private String introduction;

    @Getter private String slogan;

    @Getter private String mainIconUrl;

    @Getter private String mainBgColor;

    @Builder
    public CafeLanguage(String cafeName, String description, PK pk) {
        this.pk = pk;
        this.cafeName = cafeName;
        this.description = description;
    }

    @Embeddable
    @NoArgsConstructor
    @ToString
    @EqualsAndHashCode(callSuper = false)
    public static class PK implements Serializable {
        @Column(name = "cafe_no")
        private Long cafeNo;

        @Column(name = "lang")
        private String lang;

        public PK(Long cafeNo, String lang) {
            this.cafeNo = cafeNo;
            this.lang = lang;
        }
    }
}