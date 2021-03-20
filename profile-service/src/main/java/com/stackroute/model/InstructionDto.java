package com.stackroute.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InstructionDto {
    private int stageNo;
    private String stageName;
    private int stageDuration;
    private ArrayList<StepsDto> steps=new ArrayList<>();
}
