package com.spring.demo.dans.entity.dao;

import com.spring.demo.dans.entity.dao.common.BaseEntity;
import java.util.Date;
import java.util.UUID;
import lombok.Data;

/**
 * @author Rizky Perdana
 */
@Data
public class UserAccessToken extends BaseEntity {

    private UUID userId;
    private String token;
    private Date expireAt;
}
