package com.zglu.graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.zglu.graphql.test.UserInfo;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

/**
 * 定义UserInfo提供的查询方法，root.graphqls配置前端可用的查询方法
 *
 * @author zglu
 */
@Log4j2
@Component
public class UserInfoQueryResolver implements GraphQLQueryResolver {
    private static List<UserInfo> userList = LongStream.range(1, 6).mapToObj(m -> UserInfo.builder().id(m).userId(m).phone(m + "p").build()).collect(Collectors.toList());

    public List<UserInfo> findUserInfos() {
        return userList;
    }

    public UserInfo findUserInfo(Long id) {
        return userList.stream().filter(m -> id.equals(m.getId())).findFirst().orElse(null);
    }

    public UserInfo findUserInfoByUserId(Long id) {
        return userList.stream().filter(m -> id.equals(m.getUserId())).findFirst().orElse(null);
    }
}
