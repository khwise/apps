package com.clone.apps.domains.cafe.persistences.repository;

import com.clone.apps.domains.cafe.persistences.entity.Cafe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by kh.jin on 2020. 1. 17.
 */
@Repository
public interface CafeRepository extends JpaRepository<Cafe, Long> {
}
