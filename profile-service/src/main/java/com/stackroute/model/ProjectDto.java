package com.stackroute.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
@Document(collection="project")
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id",scope = ProjectDto.class)
public class ProjectDto {
    @Id
    private int id;
    private String emailId;
    private String userName;
    private String projectName;
    private String projectDomain;
    private Binary image;
    private String projectDescription;
    private int duration;
    private int rating;
    private int like;
    private int dislike;
    private ArrayList<IngredientDto> ingredient=new ArrayList<>();
    private ArrayList<InstructionDto> instruction=new ArrayList<>();
    private ArrayList<ReviewDto> review=new ArrayList<>();
}

