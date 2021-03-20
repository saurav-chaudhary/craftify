package com.stackroute.webcontent.repository;

import com.stackroute.webcontent.entity.SearchData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SearchingRepository extends JpaRepository<SearchData,String> {
}
