package com.blog.user.controllers;

import com.blog.user.entity.User;
import com.blog.user.service.UserBatchService;
import com.blog.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired private UserBatchService userBatchService;
    @RequestMapping(value = "/getUser/{id}",method = RequestMethod.GET)
    public User getOne(@PathVariable(value = "id",required = true) Integer id){
        User user = userService.getOne(id);
        return user;
    }
    @GetMapping(value = "/insertList")
    public List<Integer> insertList(){
        List<User> users = userList();
        return userBatchService.insertUserList(users);
    }
    @GetMapping(value = "/change")
    public String change(){
        userService.change();
        return "yes";
    }

    public  List<User> userList(){
        User a = new User("张三1","1234",1,2);
        User b = new User("张三2","12345",2,3);
        User c = new User("张三3","12346",3,4);
        User d = new User("张三423","12347",4,5);
        User e = new User("张三5","12348",5,6);
        User f = new User("张三6444","12349",6,7);
        List<User> users = new ArrayList<>();
        users.add(a);
        users.add(b);
        users.add(c);
        users.add(d);
        users.add(e);
        users.add(f);
        return users;
    }
}
