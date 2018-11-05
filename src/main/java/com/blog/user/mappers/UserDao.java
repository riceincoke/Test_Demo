package com.blog.user.mappers;

import com.blog.user.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * desc:通过 mybatis 操作 user表
 * @Return:
 **/
@Mapper
@Repository
public interface UserDao {
    User selectById(Integer id);
    int insert(User user);
    int change(Integer num);
}