package com.spring.demo.dans.entity.dao;

import com.spring.demo.dans.entity.dao.common.BaseEntity;
import java.util.Date;
import java.util.UUID;
import lombok.Data;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

/**
 * @author Rizky Perdana
 */
@Data
@Table(value = "user_access_token")
public class UserAccessToken extends BaseEntity {
    @Column("user_id")
    private UUID userId;
    @Column("token")
    private String token;
    @Column("expire_at")
    private Date expireAt;
}
