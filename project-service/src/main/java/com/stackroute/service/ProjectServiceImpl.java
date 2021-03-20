package com.stackroute.service;

import com.stackroute.converter.ProjectConverter;
import com.stackroute.dto.ProjectDto;
import com.stackroute.dto.ReviewDto;
import com.stackroute.entity.Project;
import com.stackroute.entity.Review;
import com.stackroute.exception.ProjectNotExistException;
import com.stackroute.repository.ProjectRepository;
import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.stackroute.entity.Project.SEQUENCE_NAME;

@Service
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    private ProjectConverter projectConverter;
    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private SequenceGeneratorService service;

    public ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }


    public ProjectDto addProject(ProjectDto dto){
        Project project = projectConverter.dtoToEntity(dto);
        project.setId(service.getSequenceNumber(SEQUENCE_NAME));
        project = projectRepository.save(project);
        return projectConverter.entityToDto(project);
    }

    @Override
    public void deleteProject(int id)throws ProjectNotExistException {
        if (projectRepository.findById(id).isPresent())
            projectRepository.deleteById(id);
        else
            throw new ProjectNotExistException();
    }

    @Override
    public List<ProjectDto> getProjectList() {

        List<Project> projectList = (List<Project>) projectRepository.findAll();

        return projectConverter.entityToDto(projectList);
    }

    @Override
    public ProjectDto findById(int id)throws  ProjectNotExistException {

        if(!(projectRepository.findById(id).isPresent()))
            throw new ProjectNotExistException();
        Project project=projectRepository.findById(id).get();
        ProjectDto projectDto=projectConverter.entityToDto(project);
        return projectDto;
    }

    @Override
    public ProjectDto giveReview(ReviewDto rdto, int id)throws ProjectNotExistException {
        if(!(projectRepository.findById(id).isPresent()))
            throw new ProjectNotExistException();
        Project project=projectRepository.findById(id).get();
        ArrayList<Review> reviewList=project.getReview();
        Review review = projectConverter.dtoToEntity(rdto);
        reviewList.add(review);
        int i=0;
        double r=0.0;
        while (i<reviewList.size()){
            r=r+reviewList.get(i).getRating();
            i++;
        }
        r=r/(i);
        project.setRating(r);
        project=projectRepository.save(project);
        return projectConverter.entityToDto(project);
    }

    @Override
    public ProjectDto update(int id, ProjectDto projectDto)throws ProjectNotExistException {
        if(projectRepository.findById(id).isPresent()) {
            Project project=projectRepository.findById(id).get();
            project.setProjectName(projectDto.getProjectName());
            projectRepository.save(project);
            return  projectConverter.entityToDto(project);
        }
        else
            throw new ProjectNotExistException();
    }

    @Override
    public String addPhotoForProject(int id, MultipartFile file)throws IOException, ProjectNotExistException {
        if(!(projectRepository.findById(id).isPresent()))
            throw new ProjectNotExistException();
        Project project=projectRepository.findById(id).get();
        project.setImage(new Binary(BsonBinarySubType.BINARY, file.getBytes()));
        projectRepository.save(project);
        return "Added";
    }
}
