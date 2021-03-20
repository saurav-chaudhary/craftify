package com.stackroute.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

@Data
@Document(collection = "projects")
public class Instruction {

    private int stageNo;
    private String stageName;
    private int stageDuration;
    private ArrayList<Steps> steps=new ArrayList<>();
}
