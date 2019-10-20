package com.clone.apps.domain.member.persistence.mapper;

import com.clone.apps.domain.member.persistence.entity.MemberAuthentication;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by kh.jin on 2019. 6. 28.
 */
@Mapper
public interface MemberMapper {

    List<MemberAuthentication> selectMembers();
}
