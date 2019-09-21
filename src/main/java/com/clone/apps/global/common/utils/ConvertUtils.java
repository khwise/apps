package com.clone.apps.global.common.utils;

import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;

import java.util.Arrays;
import java.util.List;

/**
 * Created by kh.jin on 2019. 8. 2.
 */
public class ConvertUtils {

    public static List<String> toList(String src, String delimiter) {
        if (StringUtils.isBlank(src) || StringUtils.isBlank(delimiter)) {
            throw new IllegalArgumentException();
        }

        return Arrays.asList(src.split(delimiter));
    }

    public String fromList(List<String> src, String delimiter) {
        if (CollectionUtils.isEmpty(src)) {
            //
        }

        return String.join(delimiter, src);
    }
}