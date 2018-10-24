package com.demo.exam.repo;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.demo.exam.entity.User;

@Mapper
public interface UserRepo {

	@Select("select * from user where username = #{username} and password = #{password}")
	public User verifyUser(@Param("username") String username, @Param("password") String password);

	@Select("select * from user where username = #{username}")
	public User getUserByUsername(@Param("username") String username);
}
