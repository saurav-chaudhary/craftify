package com.stackroute.service;

import com.stackroute.dto.ProjectDto;
import com.stackroute.dto.ReviewDto;
import com.stackroute.exception.ProjectNotExistException;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ProjectService {
    ProjectDto addProject(ProjectDto dto);
    void deleteProject(int id)throws ProjectNotExistException;
    List<ProjectDto> getProjectList();
    ProjectDto findById(int id)throws ProjectNotExistException;
    ProjectDto giveReview(ReviewDto rdto, int id)throws ProjectNotExistException;
    ProjectDto update(int id, ProjectDto projectDto)throws ProjectNotExistException;
    String addPhotoForProject(int id, MultipartFile file) throws IOException,ProjectNotExistException;
}
