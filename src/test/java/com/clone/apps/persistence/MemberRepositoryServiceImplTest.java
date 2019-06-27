package com.clone.apps.persistence;

import com.clone.apps.global.codes.MemberStatusCode;
import com.clone.apps.persistence.entity.member.Member;
import com.clone.apps.persistence.repository.MemberRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * Created by kh.jin on 2019. 6. 27.
 */

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
public class MemberRepositoryServiceImplTest {

    @Autowired
    private TestEntityManager em;

    @Autowired
    private MemberRepository repository;

    private Member member;

    @Before
    public void setup() {
        member = Member
                .builder()
                .id("test-account1")
                .password("1234")
                .status(MemberStatusCode.ACTIVATED)
                .lastPasswordChangedDate(LocalDate.now())
                .loginFailedCount(0)
                .build();
    }

    @Test
    public void test_save() {
        Member saveMember = em.persist(member);
        Member findMember = em.find(Member.class, saveMember.getId());

        assertThat(saveMember.getId()).isEqualTo(findMember.getId());
    }
}