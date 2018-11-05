package com.blog.admin.service;

import com.blog.admin.entity.Admin;
import com.blog.admin.respository.AdminJdbcTemplate;
import com.blog.admin.respository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImp implements AdminService {
    @Autowired
    private AdminRepository repository;
    @Autowired
    private AdminJdbcTemplate adminJdbcTemplate;
    @Override
    public boolean saveOrUpdate(Admin admin) {
        Admin o = repository.save(admin);
        return (o == null?false:true);
    }

    @Override
    public boolean deleteAdmin(Integer id) {
        repository.deleteById(id);
        return true;
    }

    @Override
    public Admin getAdminById(Integer id) {
        //Admin admin = repository.getOne(id);
        Admin admin = adminJdbcTemplate.get(id);

        return admin;
    }

    @Override
    public List<Admin> listAdmins() {
        List<Admin> list= repository.findAll();
        return list;
    }
}
