package com.saurabh.repository;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;

import com.saurabh.entity.Story;

public interface StoryRepository extends CrudRepository<Story, Serializable> {

}
