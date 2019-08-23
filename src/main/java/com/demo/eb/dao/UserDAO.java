package com.demo.eb.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.demo.eb.entity.User;

@Mapper
public interface UserDAO {

	@Select("select username,password,enabled from users where username = #{username}")
	public User getUserByUsername(@Param("username") String username);
}
