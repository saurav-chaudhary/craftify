package com.stackroute.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "projects")
public class StepsDto {
    private int stepNo;
    private String stepDescription;
}
