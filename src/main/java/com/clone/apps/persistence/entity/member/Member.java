package com.clone.apps.persistence.entity.member;

import com.clone.apps.global.models.codes.MemberStatusCode;
import com.clone.apps.persistence.convert.MemberStatusCodeConverter;
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
    @Column(name = "member_no")
    private Long memberNo;

    @Column(name = "member_id")
    @NotBlank
    private String memberId;

    @Column(name = "password")
    @NotBlank
    private String password;

    @Column(name = "salt")
    @NotBlank
    private String salt;

    @Convert(converter = MemberStatusCodeConverter.class)
    @Column(name = "status")
    @NotNull
    private MemberStatusCode status;

    @Column(name = "login_failed_cnt")
    @NotNull
    private Integer loginFailedCount;

    @Column(name = "last_pwd_changed_date")
    private LocalDate lastPasswordChangedDate;
}
