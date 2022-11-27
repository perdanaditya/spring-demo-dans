package com.spring.demo.dans.entity.dao.common;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;
import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;

/**
 * @author Rizky Perdana
 */
@Data
public class BaseEntity implements Serializable {

    @Id
    private UUID id;
    @CreatedBy
    private String createdBy;
    @CreatedDate
    private Date createdAt;
    private String updatedBy;
    private Date updatedAt;
    private Boolean isDeleted;
}
