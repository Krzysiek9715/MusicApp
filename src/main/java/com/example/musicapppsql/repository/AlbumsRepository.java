package com.example.musicapppsql.repository;

import com.example.musicapppsql.model.Albums;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AlbumsRepository extends JpaRepository<Albums,Long> {


Optional<Albums> findById(Long id);

}
