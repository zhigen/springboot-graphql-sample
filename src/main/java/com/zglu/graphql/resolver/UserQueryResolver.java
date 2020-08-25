package com.zglu.graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.zglu.graphql.test.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

/**
 * 定义User提供的查询方法，root.graphqls配置前端可用的查询方法
 *
 * @author zglu
 */
@Component
public class UserQueryResolver implements GraphQLQueryResolver {
    private static List<User> userList = LongStream.range(1, 6).mapToObj(m -> User.builder().id(m).name(m + "n").build()).collect(Collectors.toList());

    public List<User> findUsers() {
        return userList;
    }

    public User findUser(Long id) {
        return userList.stream().filter(m -> id.equals(m.getId())).findFirst().orElse(null);
    }
}
