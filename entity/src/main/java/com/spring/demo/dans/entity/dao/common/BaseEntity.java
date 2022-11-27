package com.spring.demo.dans.entity.dao.common;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;
import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

/**
 * @author Rizky Perdana
 */
@Data
public class BaseEntity implements Serializable {

    @Id
    @Column("id")
    private UUID id;
    @CreatedBy
    @Column("created_by")
    private String createdBy;
    @CreatedDate
    @Column("created_at")
    private Date createdAt;
    @Column("updated_by")
    private String updatedBy;
    @Column("updated_at")
    private Date updatedAt;
    @Column("is_deleted")
    private Boolean isDeleted;
}
