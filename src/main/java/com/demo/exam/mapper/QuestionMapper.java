package com.demo.exam.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.demo.exam.entity.Question;

@Mapper
public interface QuestionMapper {
	
	public void saveAll(List<Question> list);

}
