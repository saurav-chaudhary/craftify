package com.stackroute.webcontent.repository;

import com.stackroute.webcontent.entity.SearchData;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(SpringExtension.class)
@DataJpaTest
public class SearchingRepositoryTest {

    @Autowired
    private SearchingRepository searchingRepository;
    private ArrayList<String> ingredient=new ArrayList<>();
    private ArrayList<String> procedure=new ArrayList<>();

    @Test
    public void givenSearchDataToSaveShouldSaveTheData(){
        SearchData searchData=new SearchData();
        searchData.setResultedTitle("card");
        searchData.setImage("http://image.png");
        searchData.setCategory("category cooking");
        searchData.setServings("serving 3");
        searchData.setTime("2.30");
        ingredient.add("water");
        procedure.add("boil the water");
        searchingRepository.save(searchData);
        List<SearchData> finalData=searchingRepository.findAll();
        assertNotNull(finalData);
        assertEquals(finalData.get(0).getImage(),searchData.getImage());
    }

    @Test
    public void givenDataShouldGetAllData(){
        SearchData searchData=new SearchData();
        searchData.setResultedTitle("card");
        searchData.setImage("http://image.png");
        searchData.setCategory("category cooking");
        searchData.setServings("serving 3");
        searchData.setTime("2.30");
        ingredient.add("water");
        procedure.add("boil the water");
        SearchData data1=new SearchData();
        data1.setResultedTitle("card");
        data1.setImage("http://image.png");
        data1.setCategory("category cooking");
        data1.setServings("serving 3");
        data1.setTime("2.30");
        ingredient.add("veggies");
        procedure.add("boil the veggies");
        searchingRepository.save(searchData);
        searchingRepository.save(data1);
        List<SearchData> finalData= (List<SearchData>) searchingRepository.findAll();
        assertEquals("http://image.png",finalData.get(0).getImage());
    }

    @Test
    public void givenUserShouldReturnDeleteTheUser(){
        SearchData searchData=new SearchData();
        searchData.setResultedTitle("card");
        searchData.setImage("http://image.png");
        searchData.setCategory("category cooking");
        searchData.setServings("serving 3");
        searchData.setTime("2.30");
        ingredient.add("water");
        procedure.add("boil the water");
        SearchData data1=new SearchData();
        data1.setResultedTitle("card");
        data1.setImage("http://image.png");
        data1.setCategory("category cooking");
        data1.setServings("serving 3");
        data1.setTime("2.30");
        ingredient.add("veggies");
        procedure.add("boil the veggies");
        searchingRepository.save(searchData);
        searchingRepository.save(data1);
        searchingRepository.deleteAll();
    }




}