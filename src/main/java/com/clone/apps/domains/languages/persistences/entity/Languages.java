package com.clone.apps.domains.languages.persistences.entity;

import com.clone.apps.commons.entity.Auditable;
import lombok.*;

import javax.persistence.*;

/**
 * Created by kh.jin on 2020. 2. 8.
 */
@Entity
@Table(name = "tb_languages")
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = false)
public class Languages extends Auditable<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "no")
    @Getter
    private Long no;

    @Column(name = "cafe_no")
    private Long cafeNo;

    @Column(name = "lang")
    private String lang;

    @Column(name = "default_lang")
    private boolean defaultLang;
}


// TODO cafe_no + lang Unique,