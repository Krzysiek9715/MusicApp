package com.example.musicapppsql.repository;

import com.example.musicapppsql.model.Songs;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SongsRepository extends JpaRepository<Songs,Long> {

}
