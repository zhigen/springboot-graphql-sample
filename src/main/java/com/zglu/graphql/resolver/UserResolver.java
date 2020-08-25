package com.zglu.graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.zglu.graphql.test.User;
import com.zglu.graphql.test.UserInfo;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

/**
 * schema.graphqls配置的User的引用属性的查询方法
 *
 * @author zglu
 */
@Log4j2
@Component
@AllArgsConstructor
public class UserResolver implements GraphQLResolver<User> {
    private final UserInfoQueryResolver resolver;

    public UserInfo userInfo(User user) {
        log.info("查UserInfo");
        return resolver.findUserInfoByUserId(user.getId());
    }
}
