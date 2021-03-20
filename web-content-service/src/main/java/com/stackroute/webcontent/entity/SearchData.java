package com.stackroute.webcontent.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class SearchData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String title;
    private String image;
    private String category;
    private String resultedTitle;
    private String servings;
    private String time;
    @Column(length = 10485760)
    private ArrayList<String> descriptions = new ArrayList<>();

    @Column(length = 10485760)
    private ArrayList<String> ingredients = new ArrayList<>();

    @Column(length = 10485760)
    private ArrayList<String> procedure = new ArrayList<>();



}
