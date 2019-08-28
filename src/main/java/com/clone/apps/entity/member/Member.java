package com.clone.apps.entity.member;

import com.clone.apps.entity.Auditable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

/**
 * Created by kh.jin on 2019. 7. 15.
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
    @Column(name = "member_id")
    private Long id;

    @Column(name = "email")
    @Email
    private String email;

    @Column(name = "member_nm")
    @NotEmpty
    private String name;

    @Column(name = "use_lunar_calendar")
    private String useLunarCalendar;

    @Column(name = "birthday")
    private String birthday;

    @Column(name = "telecom_company_cd")
    private String telecomCompanyCode;

    @Column(name = "mobile_number")
    private String mobileNumber;

    @Column(name = "profile_image_url")
    private String profileImageUrl;

    @Transient
    private MemberAuthentication memberAuthentication;
}
