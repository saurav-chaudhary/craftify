package com.stackroute.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document(collection = "projects")
public class Review {

    private String reviewedBy;
    private Date reviewedOn=new Date();
    private double rating;
    private String review;
}
