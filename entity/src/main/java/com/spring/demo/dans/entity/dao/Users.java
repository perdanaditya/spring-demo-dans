package com.spring.demo.dans.entity.dao;

import com.spring.demo.dans.entity.dao.common.BaseEntity;
import lombok.Data;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

/**
 * @author Rizky Perdana
 */
@Data
@Table(value = "users")
public class Users extends BaseEntity {
    @Column("username")
    private String username;
    @Column("password")
    private String password;

}
