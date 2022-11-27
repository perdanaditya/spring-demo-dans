package com.spring.demo.dans.entity.dao;

import com.spring.demo.dans.entity.dao.common.BaseEntity;
import java.util.Date;
import lombok.Data;

/**
 * @author Rizky Perdana
 */
@Data
public class UserAccessToken extends BaseEntity {

    private User user;
    private String token;
    private Date expireAt;
}
