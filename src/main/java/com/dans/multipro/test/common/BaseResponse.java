package com.dans.multipro.test.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * @author Rizky Perdana
 */

@SuperBuilder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseResponse<T> {

    private String code;
    private String message;
    private T data;
}
