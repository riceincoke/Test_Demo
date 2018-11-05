package com.blog.admin.respository;

import java.util.List;

public interface JdbcTemp<T> {
     T get(Integer id);
     List<T> findByLike(String piece);
     int insert(T o);
     int update(T o);
     int delete(Integer id) ;
}
