package com.clone.apps.domains.cafe.persistences.entity.converters;

import com.clone.apps.commons.code.CafeStatusCode;
import com.clone.apps.commons.errors.BusinessException;

import javax.persistence.AttributeConverter;
import java.util.Optional;

/**
 * Created by kh.jin on 2020. 2. 8.
 */
public class CafeStatusConverter implements AttributeConverter<CafeStatusCode, Integer> {
    @Override
    public Integer convertToDatabaseColumn(CafeStatusCode cafeStatusCode) {
        return cafeStatusCode.getCode();
    }

    @Override
    public CafeStatusCode convertToEntityAttribute(Integer code) {
        return Optional.ofNullable(CafeStatusCode.from(code)).orElseThrow(() -> new BusinessException());
    }
}
