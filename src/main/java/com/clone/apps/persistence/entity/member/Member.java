package com.clone.apps.persistence.entity.member;

import com.clone.apps.global.codes.MemberStatusCode;
import com.clone.apps.persistence.entity.Auditable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

/**
 * Created by kh.jin on 2019. 6. 26.
 */

@Entity
@Table(name = "tb_member")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Member extends Auditable<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberNo;

    @Column(name = "id")
    @NotBlank
    private String id;

    @Column(name = "password")
    @NotBlank
    private String password;

    @Convert(converter = MemberStatusCode.class)
    @Column(name = "status")
    @NotBlank
    private MemberStatusCode status;

    @Column(name = "login_failed_cnt")
    @NotNull
    private Integer loginFailedCount;

    @Column(name = "last_password_changed_date")
    private LocalDate lastPasswordChangedDate;
}
