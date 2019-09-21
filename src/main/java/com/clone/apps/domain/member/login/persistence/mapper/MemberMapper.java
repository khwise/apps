package com.clone.apps.domain.member.login.persistence.mapper;

import com.clone.apps.entity.member.MemberAuthentication;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by kh.jin on 2019. 6. 28.
 */
@Mapper
public interface MemberMapper {

    List<MemberAuthentication> selectMembers();
}
