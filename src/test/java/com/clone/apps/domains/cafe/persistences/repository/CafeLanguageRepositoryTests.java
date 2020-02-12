package com.clone.apps.domains.cafe.persistences.repository;

import com.clone.apps.domains.cafe.persistences.entity.CafeLanguage;
import com.clone.apps.testenv.persistences.BaseJpaTests;
import org.hamcrest.core.Is;
import org.hamcrest.core.IsNull;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by kh.jin on 2020. 1. 19.
 */

public class CafeLanguageRepositoryTests extends BaseJpaTests {

    @Autowired
    private CafeLanguageRepository repository;



    @Test
    public void test_cafe_lang_저장() {
        // Given
        CafeLanguage language = CafeLanguage
                .builder()
                .pk(new CafeLanguage.PK(1L, "ko"))
                .cafeName("한글카페")
                .description("한글카페")
                .build()
                ;

        // When
        repository.save(language);

        // Them
        assertThat(language.getCreatedAt(), Is.is(IsNull.notNullValue()));
    }


}