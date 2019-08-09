package com.manchester.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.manchester.entities.*;
@Repository
public interface SchoolRepo extends JpaRepository<School,Integer>{

}
