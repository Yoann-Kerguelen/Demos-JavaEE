package com.m2i.demo.dao.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.m2i.demo.bo.Job;

@Repository
public interface JobRepository extends CrudRepository<Job, Integer>{

}
