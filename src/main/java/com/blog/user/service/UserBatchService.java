package com.blog.user.service;

import com.blog.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Vector;
/**
 * desc:批量操作服务
 * @Return:
 **/
@Service
public class UserBatchService {
    @Autowired
    private UserService  userService;
    /**
     * desc: 批量操作 事务控制
     * @Return:
     **/
    @Transactional(propagation = Propagation.NESTED)
    public List<Integer> insertUserList(List<User> users){
        List<Integer> resultFlag = new Vector<>();
        for (User user:users) {
            //调用userserive的添加单个用户的方法
            int index  = userService.insertUser(user);
            resultFlag.add(index);
        }
        for (Integer i:resultFlag) {
            System.out.println(i);
        }
        return resultFlag;
    }
}
