package com.stackroute.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "projects")
public class Steps {
    private int stepNo;
    private String stepDescription;
}
