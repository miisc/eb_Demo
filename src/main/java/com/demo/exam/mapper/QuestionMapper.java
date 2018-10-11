package com.demo.exam.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.demo.exam.entity.Question;

@Mapper
public interface QuestionMapper {
	@Select("select * from question where state = #{state}")
	Question findById(@Param("id") Long id);
}
