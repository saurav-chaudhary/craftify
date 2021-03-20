package com.stackroute.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "projects")
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id",scope = Project.class)
public class Project {

    @Transient
    public static final String SEQUENCE_NAME="user_sequence";

    @Id
    private int id;
    private String emailId;
    private String userName;
    private Date createdDate = new Date();
    private String projectName;
    private String projectDomain;
    private Binary image;
    private String projectDescription;
    private int duration;
    private double rating;
    private int like;
    private int dislike;
    private ArrayList<Ingredient> ingredient=new ArrayList<>();
    private ArrayList<Instruction> instruction=new ArrayList<>();
    private ArrayList<Review> review=new ArrayList<>();

}
