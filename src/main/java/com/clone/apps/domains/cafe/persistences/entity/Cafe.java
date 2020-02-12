package com.clone.apps.domains.cafe.persistences.entity;

import com.clone.apps.commons.code.BanwordCode;
import com.clone.apps.commons.code.CafeStatusCode;
import com.clone.apps.commons.code.DisplayCode;
import com.clone.apps.commons.entity.Auditable;
import lombok.*;

import javax.persistence.*;


/**
 * Created by kh.jin on 2020. 1. 11.
 */
@Entity
@Table(name = "tb_cafe", uniqueConstraints = {@UniqueConstraint(columnNames = "cafe_key")})
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = false)
public class Cafe extends Auditable<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cafe_no")
    @Getter private Long no;

    @Column(name = "cafe_key")
    @Getter private String key;

    @Column(name = "status_cd")
    @Getter private CafeStatusCode statusCode;

    @Column(name = "display_cd")
    @Getter private DisplayCode displayCode;

    @Column(name = "abuse_cnt")
    @Setter
    @Getter private Integer abuseCount;

    @Column(name = "abuse_time")
    @Setter
    @Getter private Integer abuseTime;

    @Column(name = "banword_cd")
    @Setter
    @Getter private BanwordCode banwordCode;

    public Cafe(String cafeKey) {
        this.key = cafeKey;
        statusCode = CafeStatusCode.CLOSED;
        displayCode = DisplayCode.OFF;
    }

    public void offDisplay() {
        this.displayCode = DisplayCode.OFF;
    }

    public void onDisplay() {
        this.displayCode = DisplayCode.ON;
    }

    public void closedCafe() {
        this.statusCode = CafeStatusCode.CLOSED;
    }

    public void openCafe() {
        this.statusCode = CafeStatusCode.OPEN;
    }
}