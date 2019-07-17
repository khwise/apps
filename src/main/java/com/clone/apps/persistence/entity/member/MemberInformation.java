package com.clone.apps.persistence.entity.member;

import com.clone.apps.persistence.entity.Auditable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by kh.jin on 2019. 7. 15.
 */
@Entity
@Table(name = "tb_member_information")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberInformation extends Auditable<Long> {

    @Id
    @Column(name = "member_id")
    private String id;

    @Column(name = "member_name")
    private String name;

    @Column(name = "use_lunar_calendar")
    private String useLunarCalendar;

    @Column(name = "birthday")
    private String birthday;

    @Column(name = "telecom_company_code")
    private String telecomCompanyCode;

    @Column(name = "mobile_number")
    private String mobileNumber;

    @Column(name = "profile_image_url")
    private String profileImageUrl;
}
