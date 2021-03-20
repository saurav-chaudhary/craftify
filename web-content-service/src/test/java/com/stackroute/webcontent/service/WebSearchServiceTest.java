package com.stackroute.webcontent.service;

import com.stackroute.webcontent.entity.SearchData;
import com.stackroute.webcontent.repository.SearchingRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class WebSearchServiceTest {
    @Mock
    private SearchingRepository searchingRepository;



    @InjectMocks
    private WebSearchService webSearchService;
    private SearchData searchData= new SearchData();
    private List<SearchData> searchDataList;
    private ArrayList<String> procedure =new ArrayList<>();
    private ArrayList<String> ingredient = new ArrayList<>();

    @BeforeEach
    public void setUp() {
        searchData.setTitle("Afghan_Bread");
        searchData.setResultedTitle("Afghan_Bread");
        searchData.setImage("http://image.png");
        searchData.setCategory("category cooking");
        searchData.setServings("serving 3");
        searchData.setTime("2.30");
        ingredient.add("water");
        procedure.add("boil the water");
        searchData.setProcedure(procedure);
        searchData.setIngredients(ingredient);
    }

    @AfterEach
    public void tearDown() {
        searchData = null;
    }
    @Test
    public void givenTitleToSearchShouldReturnListOfResults(){

        searchingRepository.save(searchData);
        when(searchingRepository.findAll()).thenReturn(searchDataList);
        List<SearchData> userList=webSearchService.getDataFromSite("Afghan_Bread");
        assertEquals(searchDataList,userList);
        verify(searchingRepository,times(1)).save(searchData);
        verify(searchingRepository,times(1)).findAll();

    }
}