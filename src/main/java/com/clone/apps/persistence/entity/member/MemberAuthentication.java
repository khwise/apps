package com.clone.apps.persistence.entity.member;

import com.clone.apps.global.codes.MemberStatusCode;
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
@Table(name = "tb_member_authentication")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberAuthentication extends Auditable<Long> {

    @Id
    @Column(name = "member_id")
    private Long id;

    @Column(name = "password")
    @NotBlank
    private String password;

    @Column(name = "salt")
    @NotBlank
    private String salt;

    @Convert(converter = MemberStatusCodeConverter.class)
    @Column(name = "status_cd")
    @NotNull
    private MemberStatusCode statusCode;

    @Column(name = "login_failed_cnt")
    @NotNull
    private Integer loginFailedCount;

    @Column(name = "last_pwd_changed_date")
    private LocalDate lastPasswordChangedDate;
}
