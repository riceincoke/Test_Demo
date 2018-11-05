package com.blog.admin.respository;

import com.blog.admin.entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * desc:通过jdbcTemplate 操作admin 表
 * @Return:
 **/
@Repository
public class AdminJdbcTemplate implements JdbcTemp<Admin> {
    @Autowired
    private JdbcTemplate jdbcTemplate = null;

    /**
     * desc:配置映射关系
     * @Return: RowMapper
     **/
    public RowMapper<Admin> getRowMapper(){
        RowMapper<Admin> rowMapper = (resultSet, i) -> {
            Admin admin = new Admin();
            admin.setAid(resultSet.getInt(1));
            admin.setAdName(resultSet.getString(2));
            admin.setAdPassword(resultSet.getString(3));
            return admin;
        };
        return rowMapper;
    }
    @Override
    public Admin get(Integer id) {
        String sql = "SELECT * FROM admin WHERE a_id = ?";
        Object[] param = new Object[]{id};
        Admin admin = jdbcTemplate.queryForObject(sql,param, getRowMapper());
        System.out.println("调用 方法 ");
        return admin;
    }

    @Override
    public List<Admin> findByLike(String piece) {
        return null;
    }

    @Override
    public int insert(Admin o) {
        return 0;
    }

    @Override
    public int update(Admin o) {
        return 0;
    }

    @Override
    public int delete(Integer id) {
        return 0;
    }
}
