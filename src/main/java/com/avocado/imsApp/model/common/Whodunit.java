package com.avocado.imsApp.model.common;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.Instant;


@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
public abstract class Whodunit {


    @CreatedDate
    protected Instant createdDate;

    @LastModifiedDate
    protected Instant updatedDate;

    @LastModifiedBy
    protected String updatedBy;

    @CreatedBy
    protected String createdBy;
}
