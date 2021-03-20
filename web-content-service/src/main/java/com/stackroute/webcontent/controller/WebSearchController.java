package com.stackroute.webcontent.controller;

import com.stackroute.webcontent.entity.SearchData;
import com.stackroute.webcontent.service.WebSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins="*",allowedHeaders="*")
public class WebSearchController {

    private WebSearchService webSearchService;

    @Autowired
    public WebSearchController(WebSearchService webSearchService){
        this.webSearchService=webSearchService;
    }
    /*this method gets the title from front end and send it to webSearchService getDataFromSite method*/
    @GetMapping("/search/{title}")
    public ResponseEntity<List<SearchData>> getAllData(@PathVariable(value = "title") String title){
        return new ResponseEntity<List<SearchData>>((List<SearchData>) webSearchService.getDataFromSite(title),HttpStatus.OK);
    }

}
