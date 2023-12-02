package com.mycompany.springboot.repository;

import com.mycompany.springboot.enitity.WikimediaData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WikimediaDataRepository extends JpaRepository<WikimediaData, Long> {
}
