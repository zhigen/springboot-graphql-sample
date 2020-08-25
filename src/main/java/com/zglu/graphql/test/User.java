package com.zglu.graphql.test;

import lombok.Builder;
import lombok.Data;

/**
 * @author zglu
 */
@Data
@Builder
public class User {
    private Long id;
    private String name;
}
