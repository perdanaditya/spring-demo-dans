package com.spring.demo.dans.entity.dto;

import java.util.Date;
import java.util.UUID;
import lombok.Data;

/**
 * @author Rizky Perdana
 */
@Data
public class UserAccessTokenDto {

    private UUID id;
    private String token;
    private Date expireAt;
}
