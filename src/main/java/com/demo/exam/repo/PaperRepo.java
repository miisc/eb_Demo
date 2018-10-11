package com.demo.exam.repo;

import org.springframework.data.repository.CrudRepository;

import com.demo.exam.entity.Paper;

public interface PaperRepo extends CrudRepository<Paper, Long> {
}
