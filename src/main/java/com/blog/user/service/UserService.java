package com.blog.user.service;

import com.blog.user.entity.User;
import com.blog.user.mappers.UserDao;
import org.omg.PortableInterceptor.Interceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Vector;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;
    /**
     * desc:查询单个
     * @Return:User
     **/
    @Transactional
    public User getOne(Integer id){
      return userDao.selectById(id);
    }
    /**
     * desc:添加单体
     * @Return:int
     **/
    @Transactional
    public int insertUser(User user){
        return userDao.insert(user);
    }

    /**
     * desc: 转账事务控制
     * @Return: void
     **/
    @Transactional
    public void change(){
        userDao.change(500);
        int i = 1/0;
        System.out.println(i);
        userDao.change(-400);
    }
}
