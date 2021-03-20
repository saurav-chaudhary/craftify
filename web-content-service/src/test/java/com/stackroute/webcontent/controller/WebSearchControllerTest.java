package com.stackroute.webcontent.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.webcontent.entity.SearchData;
import com.stackroute.webcontent.service.WebSearchService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class WebSearchControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Mock
    private WebSearchService webSearchService;
    private SearchData searchData = new SearchData();
    private List<SearchData> searchDataListList;
    private ArrayList<String> ingredient=new ArrayList<>();
    private ArrayList<String> procedure=new ArrayList<>();


    @InjectMocks
    private WebSearchController webSearchController;

    @BeforeEach
    public void setUp(){
        searchData.setResultedTitle("card");
        searchData.setImage("http://image.png");
        searchData.setCategory("category cooking");
        searchData.setServings("serving 3");
        searchData.setTime("2.30");
        ingredient.add("data1");
        procedure.add("data2");
        searchData.setIngredients(ingredient);
        searchData.setProcedure(procedure);
        mockMvc= MockMvcBuilders.standaloneSetup(webSearchController).build();
    }

    @Test
    public void givenTitleToSearchShouldReturnListOfData() throws Exception {
        when(webSearchService.getDataFromSite(any())).thenReturn(searchDataListList);
        mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:8081/api/v1//search/card")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(searchData)))
                .andDo(MockMvcResultHandlers.print());
        verify(webSearchService,times(1)).getDataFromSite(any());
    }
    public static String asJsonString(final Object obj){
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}