package com.blog.admin.controller;

import com.blog.admin.entity.Admin;
import com.blog.admin.service.AdminService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {
    @Resource
    private AdminService adminService;
    /**
    *查询所有
    */
    @GetMapping
    public ModelAndView list(ModelAndView mv){
        List<Admin> adminList = adminService.listAdmins();
        mv.addObject("adminList", adminList);
        mv.addObject("title", "User Manage");
        mv.setViewName("/admin/adminList");
        return mv;
    }

    /**
     *查询 ID
     */
    @GetMapping(value = "/{id}")
    public ModelAndView findById(@PathVariable(value = "id") Integer id, ModelAndView mv){
        Admin admin = adminService.getAdminById(id);
        mv.addObject("admin", admin);
        mv.addObject("title", "User Info");
        mv.setViewName("/admin/adminDetail");
        return mv;
    }
    /**
     *修改 ID
     */
    @GetMapping(value = "/notify/{id}")
    public ModelAndView notify(@PathVariable(value = "id")Integer id , ModelAndView mv){
        Admin admin = adminService.getAdminById(id);
        mv.addObject("admin", admin);
        mv.addObject("title", "Notify Info");
        mv.setViewName("/admin/adminPage");
        return mv;
    }
    /**
     *add页面
     */
    @GetMapping(value = "/add")
    public ModelAndView addpage(ModelAndView mv){
        mv.addObject("title", "Create User");
        mv.setViewName("/admin/adminAdd");
        return mv;
    }
    /**
     *新增，修改
     */
    @PostMapping(value = "/save")
    public String save(Admin admin, ModelAndView mv){
        boolean flag = adminService.saveOrUpdate(admin);
        if (flag){
            mv.addObject("msg", "添加成功");
        }else {
            mv.addObject("msg", "失败成功");
        }
        return "redirect:/admin";
    }
    /**
     *删除
     */
    @GetMapping(value = "/del/{id}")
    public ModelAndView del(@PathVariable(value = "id") Integer id, ModelAndView mv){
        boolean flag = adminService.deleteAdmin(id);
        if (flag){
            mv.addObject("msg", "删除成功");
        }else {
            mv.addObject("msg", "删除成功");
        }
        mv.addObject("title", "User List");
        mv.setViewName("redirect:/admin");
        return mv;
    }
}
