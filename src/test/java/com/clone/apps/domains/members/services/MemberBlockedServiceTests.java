package com.clone.apps.domains.members.services;

import com.clone.apps.domains.members.persistences.entity.MemberAuthentication;
import org.hamcrest.MatcherAssert;
import org.hamcrest.core.Is;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by kh.jin on 2020. 1. 20.
 */
@RunWith(SpringRunner.class)
public class MemberBlockedServiceTests {

    @Autowired
    private MemberBlockedService service;


    @Test
    public void test_member_blocked() {
        // Given
        MemberAuthentication authentication = MemberAuthentication.builder().id(1L).pwd("password").build();
        authentication.incrementLoginFailedCount();
        int expect = authentication.getLoginFailedCount();

        // When
        service.blocked(authentication);

        // Then
        MatcherAssert.assertThat(expect, Is.is(1));
    }

}