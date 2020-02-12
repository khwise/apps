package com.clone.apps.commons.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

/**
 * Created by kh.jin on 2019. 6. 26.
 */

@MappedSuperclass
@EntityListeners({AuditingEntityListener.class})
@EqualsAndHashCode(callSuper = false)
public abstract class Auditable<U> {

    @Column(name = "created_at")
    @CreationTimestamp
    @Getter
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    @UpdateTimestamp
    @Getter
    private LocalDateTime updatedAt;

    @Column(name = "created_by")
    @CreatedBy
    @Getter
    private U createdBy;

    @Column(name = "updated_by")
    @LastModifiedBy
    @Getter
    private U updatedBy;
}
