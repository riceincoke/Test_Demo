package com.blog.admin.respository;

import com.blog.admin.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * desc:  通过jpa操作 admin表
 * @Return:
 **/
@Repository
public interface AdminRepository extends JpaRepository<Admin,Integer> {
}
