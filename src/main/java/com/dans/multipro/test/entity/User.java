package com.dans.multipro.test.entity;

import com.dans.multipro.test.constants.UserFields;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author Rizky Perdana
 */

@Entity(name = UserFields.tableNameUser)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = UserFields.userId)
    private Long userId;

    @Column(name = UserFields.userName)
    private String username;

    @Column(name = UserFields.password)
    private String password;

    @Column(name = UserFields.name)
    private String name;
}
