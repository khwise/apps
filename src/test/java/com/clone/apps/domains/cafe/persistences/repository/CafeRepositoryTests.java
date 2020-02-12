package com.clone.apps.domains.cafe.persistences.repository;

import com.clone.apps.commons.code.CafeStatusCode;
import com.clone.apps.domains.cafe.persistences.entity.Cafe;
import com.clone.apps.testenv.persistences.BaseJpaTests;
import org.hamcrest.core.Is;
import org.hamcrest.core.IsNull;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by kh.jin on 2020. 1. 17.
 */
public class CafeRepositoryTests extends BaseJpaTests {

    @Autowired
    private CafeRepository repository;

    @Test
    public void test_cafe_저장() {
        // Given
        Cafe cafe = new Cafe("temp_cafe");

        // When
        repository.save(cafe);

        // Then
        assertThat(cafe.getNo(), Is.is(IsNull.notNullValue()));
    }

    @Test(expected = RuntimeException.class)
    public void test_cafe_카페키_중복() {
        // Given
        Cafe cafe1 = new Cafe("temp_cafe");
        Cafe cafe2 = new Cafe("temp_cafe");

        // When
        repository.save(cafe1);
        repository.save(cafe2);

        // Then
        // Expected runtime exception.
    }

    @Test
    public void test_cafe_조회() {
        // Given
        repository.save(new Cafe("temp_cafe1"));
        repository.save(new Cafe("temp_cafe2"));
        int expect = 2;

        // When
        List<Cafe> cafes = repository.findAll();

        // Then
        assertThat(cafes.size(), Is.is(expect));
    }

    @Test
    public void test_cafe_조회_empty() {
        // Given
        int expect = 0;

        // When
        int actual = repository.findAll().size();

        // Then
        assertThat(actual, Is.is(expect));
    }

    @Test
    public void test_cafe_closed_and_open() {
        // Given
        Cafe cafe = new Cafe("cate_temp");
        repository.save(cafe);

        // When
        cafe.closedCafe();
        repository.save(cafe);

        // Then
        assertThat(CafeStatusCode.CLOSED, Is.is(cafe.getStatusCode()));

        // When
        cafe.openCafe();
        repository.save(cafe);

        // Then
        assertThat(CafeStatusCode.OPEN, Is.is(cafe.getStatusCode()));
    }
}