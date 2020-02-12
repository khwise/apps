package com.clone.apps.domains.cafe.persistences.repository;

import com.clone.apps.domains.cafe.persistences.entity.CafeLanguage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by kh.jin on 2020. 1. 19.
 */
@Repository
public interface CafeLanguageRepository extends JpaRepository<CafeLanguage, CafeLanguage.PK> {
}
