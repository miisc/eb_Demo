package com.demo.exam.repo;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.demo.exam.entity.Question;

@Mapper
public interface QuestionRepo {

	@Select("select * from question where id = #{id}")
	public Question findById(@Param("id") int id);

	@Select("select * from question where type = #{type}")
	public List<Question> findAllByType(@Param("type") String type);

	@Select("select answer from question where id = #{id}")
	public String findAnswerById(@Param("id") long id);

	@Select("select count(1) from question where type= #{type}")
	public int countByType(@Param("type") String type);

	@Select("select count(1) from question")
	public int count();

	public void saveAll(List<Question> list);
}
