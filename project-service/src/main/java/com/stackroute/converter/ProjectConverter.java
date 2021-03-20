package com.stackroute.converter;

import com.stackroute.dto.ProjectDto;
import com.stackroute.dto.ReviewDto;
import com.stackroute.entity.Project;
import com.stackroute.entity.Review;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProjectConverter {
    public ProjectDto entityToDto(Project project) {

        ModelMapper mapper =new ModelMapper();
        ProjectDto map = mapper.map(project, ProjectDto.class);
        return map;

    }
    public List<ProjectDto> entityToDto(List<Project> project) {

        return	project.stream().map(x -> entityToDto(x)).collect(Collectors.toList());

    }

    public ReviewDto entityToDto(Review review) {
        ModelMapper mapper=new ModelMapper();
        ReviewDto map= mapper.map(review, ReviewDto.class);
        return map;
    }
    public List<ReviewDto> entityToDtoList(List<Review> review) {

        return	review.stream().map(x -> entityToDto(x)).collect(Collectors.toList());

    }

    public Review dtoToEntity(ReviewDto dto)
    {
        ModelMapper mapper = new ModelMapper();
        Review map = mapper.map(dto, Review.class);
        return map;
    }
    public List<Review> dtoToEntityList(List<ReviewDto> dto)
    {

        return dto.stream().map(x -> dtoToEntity(x)).collect(Collectors.toList());
    }

    public Project dtoToEntity(ProjectDto dto)
    {

        ModelMapper mapper = new ModelMapper();
        Project map = mapper.map(dto, Project.class);
        return map;
    }

    public List<Project> dtoToEntity(List<ProjectDto> dto)
    {

        return dto.stream().map(x -> dtoToEntity(x)).collect(Collectors.toList());
    }
}
