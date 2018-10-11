package com.demo.exam.repo;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.demo.exam.entity.Question;

@Repository
public class QuestionRepo {

	public String findAnswerById(long id) {
		return null;
	}

	public long countByType(String type) {
		return 0;
	}

	public List<Question> findAllByType(String type) {
		return null;
	}

	public void saveAll(List<Question> list) {
		// TODO Auto-generated method stub

	}

	public int count() {
		// TODO Auto-generated method stub
		return 0;
	}

	public Question findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}


}
