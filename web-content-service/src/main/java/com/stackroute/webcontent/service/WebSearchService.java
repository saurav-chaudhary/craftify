package com.stackroute.webcontent.service;

import com.stackroute.webcontent.entity.SearchData;
import com.stackroute.webcontent.exception.DataNotFoundException;
import com.stackroute.webcontent.repository.SearchingRepository;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class WebSearchService {


    private SearchingRepository searchingRepository;
    @Autowired
    public WebSearchService(SearchingRepository searchingRepository){
        this.searchingRepository=searchingRepository;
    }

    public List<SearchData> getDataFromSite(String searchTitle) {
        SearchData searchedData=new SearchData();
        searchingRepository.deleteAll();
        try{
            /*connecting to the website for getting data and checking the response status*/
            Connection connection = Jsoup.connect("https://en.wikibooks.org/wiki/Cookbook:"+searchTitle);
            Document document = connection.get();
            if (connection.response().statusCode() == 200) {
                /*getting the selecting tag of data from the document html */
                Elements body1=document.getElementsByClass("mw-parser-output");
                String resultedCategory = "";
                String resultedServing="";
                String resultedTime="";
                String resultedImage = "";
                String resultedTitle ="";
                ArrayList<String> resultedDescription=new ArrayList<>();
                ArrayList<String> ingredient=new ArrayList<>();
                ArrayList<String> procedure=new ArrayList<>();
                /*getting the data from document which has tag tr*/
                Elements rows = document.getElementsByTag("tr");
                /*storing the gathered data from tag tr to local variables if it is not empty*/
                if(!rows.isEmpty()) {
                    resultedTitle = rows.get(0).text();
                    resultedImage = rows.get(1).select("img").attr("src");
                    resultedCategory = rows.get(2).select("td").text();
                    resultedServing = rows.get(3).select("td").text();
                    resultedTime = rows.get(4).select("td").text();
                }

                /*selecting the data of which is in format h2 and ul */
                Elements elements = body1.select("h2,ul");
                String header=elements.select("#Ingredients").text();
                Elements ingredientLine = null;
                if(header.equals("Ingredients")) {
                    ingredientLine = elements.select("li");
                }
                Elements selection;
                /*selecting the data of which is in format h2 and dl */
                Elements elements2 = body1.select("h2,dl");
                Elements ingredientLine2=elements2.select("dd");

                if(ingredientLine2.isEmpty()){
                    selection=ingredientLine;
                }else {
                    selection=ingredientLine2;
                }


                for( Element element : selection )
                {
                    ingredient.add(element.text());
                }
                /*selecting the data of which is in format h2 and ol */
                Elements procedureLine=body1.select("h2,ol");
                Elements li=procedureLine.select("li");
                for (Element element2 : li){
                    procedure.add(element2.text());
                }
                Elements description=body1.select("p");
                description.remove(0);
                for (Element element3 : description){
                    resultedDescription.add(element3.text());
                }
                searchedData.setResultedTitle(resultedTitle);
                searchedData.setImage(resultedImage);
                searchedData.setCategory(resultedCategory);
                searchedData.setServings(resultedServing);
                searchedData.setTime(resultedTime);
                searchedData.setIngredients(ingredient);
                searchedData.setProcedure(procedure);
                searchedData.setDescriptions(resultedDescription);
                searchingRepository.save(searchedData);
            }
        }catch (IOException e){
          throw  new DataNotFoundException();
        }
    return searchingRepository.findAll();
    }

}
