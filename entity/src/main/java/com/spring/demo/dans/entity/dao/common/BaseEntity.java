package com.spring.demo.dans.entity.dao.common;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;
import lombok.Data;

/**
 * @author Rizky Perdana
 */
@Data
public class BaseEntity implements Serializable {

    private UUID id;
    private String createdBy;
    private Date createdAt;
    private String updatedBy;
    private Date updatedAt;
    private Boolean isDeleted;
}
