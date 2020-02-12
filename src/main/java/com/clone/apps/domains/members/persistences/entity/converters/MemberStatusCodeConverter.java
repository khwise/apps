package com.clone.apps.domains.members.persistences.entity.converters;

import com.clone.apps.commons.code.MemberStatusCode;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * Created by kh.jin on 2019. 6. 26.
 */
@Converter
public class MemberStatusCodeConverter implements AttributeConverter<MemberStatusCode, Integer> {

    @Override
    public Integer convertToDatabaseColumn(MemberStatusCode memberStatusCode) {
        return Integer.valueOf(memberStatusCode.getCode());
    }

    @Override
    public MemberStatusCode convertToEntityAttribute(Integer code) {
        return MemberStatusCode.from(code);
    }
}