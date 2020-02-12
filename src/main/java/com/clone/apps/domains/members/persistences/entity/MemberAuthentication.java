package com.clone.apps.domains.members.persistences.entity;

import com.clone.apps.domains.members.persistences.entity.converters.MemberStatusCodeConverter;
import com.clone.apps.commons.code.MemberStatusCode;
import com.clone.commons.utils.encypt.SHA256Helper;
import com.clone.commons.utils.encypt.SaltGenerator;
import com.clone.apps.commons.errors.AppsException;
import com.clone.apps.commons.entity.Auditable;
import lombok.*;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;


/**
 * Created by kh.jin on 2019. 6. 26.
 */

@Entity
@Table(name = "tb_member_authentication")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
@EqualsAndHashCode(callSuper = false)
public class MemberAuthentication extends Auditable<Long> {
    @Transient
    private final Logger log = LoggerFactory.getLogger(MemberAuthentication.class);

    @Id
    @Column(name = "member_id")
    @Getter
    private Long id;

    @Column(name = "password")
    @NotBlank
    private String password;

    @Column(name = "salt")
    @NotBlank
    private String salt = SaltGenerator.generate();

    @Convert(converter = MemberStatusCodeConverter.class)
    @Column(name = "status_cd")
    @NotNull
    @Getter
    private MemberStatusCode statusCode = MemberStatusCode.LOCKED;

    @Column(name = "login_failed_cnt")
    @NotNull
    @Getter
    private Integer loginFailedCount;

    @Column(name = "last_pwd_changed_date")
    @Getter
    private LocalDate lastPasswordChangedDate = LocalDate.now();

    @Builder
    public MemberAuthentication(Long id, String pwd) {
        super();
        try {
            this.id = id;
            this.password = SHA256Helper.getInstance().encypt(pwd, salt);
        } catch (NoSuchAlgorithmException e) {
            throw new AppsException();
        }
    }

    public boolean authenticate(String pwd) throws NoSuchAlgorithmException {
        if (StringUtils.isBlank(pwd)) {

        }
        log.debug("password compared.");
        return password.equals(SHA256Helper.getInstance().encypt(pwd, salt));
    }

    public void blocked() {
        this.statusCode = MemberStatusCode.BLOCKED;
    }

    public void initLoginFailedCount() {
        loginFailedCount = 0;
    }

    public void incrementLoginFailedCount() {
        loginFailedCount = loginFailedCount + 1;
    }
}
