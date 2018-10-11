package com.demo.exam.entity;

import java.util.List;

import lombok.Data;

@Data
public class Paper {

	private long id;
	private List<Question> questions;
	private List<String> answers;
	private int score = -1;

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	public void setAnswers(List<String> answers) {
		this.answers = answers;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		for (Question q : this.questions) {
			sb.append(q.toString());
		}
		
		sb.append("\n");
		for (String a : this.answers)
			sb.append(a);
		return "Paper [id=" + id + ", score=" + score + "]" + "\n" + sb +"\n";
	}

}
