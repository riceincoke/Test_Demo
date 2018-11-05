package com.blog.admin.service;

import com.blog.admin.entity.Admin;

import java.util.List;

public interface AdminService {
    boolean saveOrUpdate(Admin admin);//添加或者修改
    boolean deleteAdmin(Integer id);//根据id删除
    Admin getAdminById(Integer id);//根据id查询
    List<Admin> listAdmins();//查询列表
}
