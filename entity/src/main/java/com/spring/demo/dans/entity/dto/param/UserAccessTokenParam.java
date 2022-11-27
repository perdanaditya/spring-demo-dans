package com.spring.demo.dans.entity.dto.param;

import java.util.Date;
import java.util.UUID;
import lombok.Builder;
import lombok.Data;

/**
 * @author Rizky Perdana
 */
@Data
@Builder
public class UserAccessTokenParam {

    private UUID userId;
    private String token;
    private Date expireAt;
}
