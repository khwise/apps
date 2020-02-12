package com.clone.apps.domains.cafe.persistences.entity;

import com.clone.apps.commons.code.CafeStatusCode;
import com.clone.apps.commons.code.DisplayCode;
import org.hamcrest.MatcherAssert;
import org.hamcrest.core.Is;
import org.hamcrest.core.IsNull;
import org.junit.Test;



/**
 * Created by kh.jin on 2020. 1. 17.
 */
public class CafeTests {

    @Test
    public void test_NoArgsConstructor() {
        Cafe cafe = new Cafe();
        // null 이 아님
        MatcherAssert.assertThat(cafe, Is.is(IsNull.notNullValue()));

        // null 이어야 함
        MatcherAssert.assertThat(cafe.getNo(), Is.is(IsNull.nullValue()));
        MatcherAssert.assertThat(cafe.getKey(), Is.is(IsNull.nullValue()));
        MatcherAssert.assertThat(cafe.getDisplayCode(), Is.is(IsNull.nullValue()));
        MatcherAssert.assertThat(cafe.getStatusCode(), Is.is(IsNull.nullValue()));
    }

    @Test
    public void test_카페키생성자() {
        Cafe cafe = new Cafe("cafe");

        // null 이 아님
        MatcherAssert.assertThat(cafe, Is.is(IsNull.notNullValue()));
        MatcherAssert.assertThat(cafe.getKey(), Is.is(IsNull.notNullValue()));
        MatcherAssert.assertThat(cafe.getDisplayCode(), Is.is(IsNull.notNullValue()));
        MatcherAssert.assertThat(cafe.getStatusCode(), Is.is(IsNull.notNullValue()));

        MatcherAssert.assertThat(cafe.getStatusCode(), Is.is(CafeStatusCode.CLOSED));
        MatcherAssert.assertThat(cafe.getDisplayCode(), Is.is(DisplayCode.OFF));

        // null 이어야 함
        MatcherAssert.assertThat(cafe.getNo(), Is.is(IsNull.nullValue()));
    }
}