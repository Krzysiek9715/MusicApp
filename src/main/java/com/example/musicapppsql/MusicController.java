package com.example.musicapppsql;


import com.example.musicapppsql.model.Albums;
import com.example.musicapppsql.model.Songs;
import com.example.musicapppsql.repository.AlbumsRepository;
import com.example.musicapppsql.repository.SongsRepository;
import com.example.musicapppsql.service.AlbumsService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api")
public class MusicController {

    @Autowired
    AlbumsRepository albumsRepository;

    @Autowired
    SongsRepository songsRepository;

    @Autowired
    AlbumsService albumsService;


    @GetMapping("/album")
    @ApiOperation(value = "List of all albums")
    public List<Albums> getAlbums(){
        List<Albums> albums = albumsRepository.findAll();
        for (Albums album:albums){
            album.setTotalLenght(albumsService.totalLenghtAlbum(album.getId()));
        }
        return albums;
    }

    @GetMapping("albums/{id}")
    @ApiOperation(value = "List of song from choosen album")
    public List<Songs> songsList(@PathVariable Long id){
        List<Songs> songsList = albumsRepository.findById(id).get().getSongsList();
        return songsList;
    }



}
