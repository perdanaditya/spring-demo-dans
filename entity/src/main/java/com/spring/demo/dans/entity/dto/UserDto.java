package com.spring.demo.dans.entity.dto;

import java.util.UUID;
import lombok.Data;

/**
 * @author Rizky Perdana
 */
@Data
public class UserDto {

    private UUID id;
    private String username;
    private String password;
}
