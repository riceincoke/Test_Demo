package com.blog;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.blog.admin.respository" )
@EntityScan(basePackages = {"com.blog.admin.entity","com.blog.user.entity"})
@MapperScan(basePackages = "com.blog.user.mappers",annotationClass = Mapper.class)
@EnableTransactionManagement
@EnableAspectJAutoProxy
public class BlogerApplication {
	public static void main(String[] args) {
		SpringApplication.run(BlogerApplication.class, args);
	}
}
