package com.clone.apps.commons.utils;

import com.clone.apps.global.utils.ConvertUtils;
import org.junit.Test;

/**
 * Created by kh.jin on 2019. 8. 2.
 */
public class ConvertUtilsTest {

    @Test(expected = IllegalArgumentException.class)
    public void toList() {
        ConvertUtils.toList(null, null);
    }
}