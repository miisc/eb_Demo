package com.demo.exam.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.demo.exam.entity.Question;

public interface QuestionRepo extends CrudRepository<Question, Long> {

	public String findAnswerById(long id);

	public long countByType(String type);

	public List<Question> findAllByType(String type);

}
