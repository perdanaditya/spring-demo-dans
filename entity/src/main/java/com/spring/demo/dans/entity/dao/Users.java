package com.spring.demo.dans.entity.dao;

import com.spring.demo.dans.entity.dao.common.BaseEntity;
import lombok.Data;

/**
 * @author Rizky Perdana
 */
@Data
public class Users extends BaseEntity {

    private String username;
    private String password;

}