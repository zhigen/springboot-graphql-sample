package com.zglu.graphql.test;

import lombok.Builder;
import lombok.Data;

/**
 * @author zglu
 */
@Data
@Builder
public class UserInfo {
    private Long id;
    private Long userId;
    private String phone;
}
