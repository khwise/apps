package com.clone.apps.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
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
@Data
@EqualsAndHashCode(callSuper = false)
public abstract class Auditable<U> {

    @Column(name = "created_at")
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @Column(name = "creator")
    @CreatedBy
    private U creator;

    @Column(name = "updater")
    @LastModifiedBy
    private U updater;
}
