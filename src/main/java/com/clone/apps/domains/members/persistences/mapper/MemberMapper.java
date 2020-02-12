package com.clone.apps.domains.members.persistences.mapper;

import com.clone.apps.domains.members.persistences.entity.MemberAuthentication;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by kh.jin on 2019. 6. 28.
 */
@Mapper
public interface MemberMapper {

    List<MemberAuthentication> selectMembers();
}
