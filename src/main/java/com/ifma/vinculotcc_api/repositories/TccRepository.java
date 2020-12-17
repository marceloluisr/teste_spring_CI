package com.ifma.vinculotcc_api.repositories;


import com.ifma.vinculotcc_api.models.Tcc;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
//https://docs.spring.io/spring-data/jpa/docs/1.5.0.RELEASE/reference/html/jpa.repositories.html
@Repository
public interface TccRepository extends JpaRepository<Tcc, Long> {
    Iterable<Tcc> findByTema(String tema);
    Iterable<Tcc> findByArea(String area);
  
    
}
