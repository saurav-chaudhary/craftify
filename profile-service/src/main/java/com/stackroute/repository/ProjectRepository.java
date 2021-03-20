package com.stackroute.repository;

import com.stackroute.model.ProjectDto;
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.MongoRepository;

@Repository
public interface ProjectRepository extends MongoRepository<ProjectDto, Integer> {

    ProjectDto findByEmailId(String emailId);
}
