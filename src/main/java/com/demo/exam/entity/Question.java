package com.demo.exam.entity;

import lombok.Data;

@Data
public class Question {

	long id, oid;
	private String type, description, options, answer, comment;

	@Override
	public String toString() {
		return "Question [id=" + id + "	type=" + type + "	description=" + description + "	options=" + options
				+ "	answer=" + answer + "	comment=" + comment + "]";
	}

}
