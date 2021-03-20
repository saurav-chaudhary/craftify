package com.stackroute.controller;

import com.stackroute.dto.ProjectDto;
import com.stackroute.dto.ReviewDto;
import com.stackroute.exception.ProjectNotExistException;
import com.stackroute.service.ProjectService;
import com.stackroute.service.RabbitMqSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
//@RequestMapping("project/api/v2")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProjectController {


    @Autowired
    private RabbitMqSender rabbitMqSender;

    private ProjectService projectService;

    @Autowired
    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @PostMapping("/project")
    public ResponseEntity<ProjectDto> save(@RequestBody ProjectDto projectDto) {
        rabbitMqSender.send(projectDto);
        return new ResponseEntity<>(projectService.addProject(projectDto), HttpStatus.CREATED);
    }

    @DeleteMapping("/project/{id}")
    public ResponseEntity<Void> deleteProject(@PathVariable int id)throws ProjectNotExistException {
        projectService.deleteProject(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/projects")
    public ResponseEntity<List<ProjectDto>> getAllUsers() {
        return new ResponseEntity<>((List<ProjectDto>) projectService.getProjectList(), HttpStatus.OK);
    }

    @GetMapping("/project/{id}")
    public ResponseEntity<ProjectDto> getAllUsers(@PathVariable int id)throws ProjectNotExistException {
        return new ResponseEntity<>(projectService.findById(id), HttpStatus.FOUND);
    }

    @PutMapping("project/review/{id}")
    public ResponseEntity<ProjectDto> addReview(@PathVariable int id, @RequestBody ReviewDto rdto)throws ProjectNotExistException {
        return new ResponseEntity<>(projectService.giveReview(rdto, id), HttpStatus.CREATED);
    }

    @PutMapping("project/update/{id}")
    public ResponseEntity<ProjectDto> update(@PathVariable int id, @RequestBody ProjectDto projectDto)throws ProjectNotExistException {
        return new ResponseEntity<>(projectService.update(id, projectDto), HttpStatus.OK);
    }

    @PutMapping("/upload/{id}")
    public ResponseEntity<String> uploadProjectImage(@PathVariable("id") int id, @RequestParam("image") MultipartFile image, Model model) throws IOException, ProjectNotExistException {
        String s = projectService.addPhotoForProject(id, image);
        return new ResponseEntity<>(s, HttpStatus.OK);
    }
}
