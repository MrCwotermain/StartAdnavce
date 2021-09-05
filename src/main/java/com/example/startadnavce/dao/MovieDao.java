package com.example.startadnavce.dao;

import com.example.startadnavce.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieDao extends JpaRepository<Movie,Integer >
{


}
