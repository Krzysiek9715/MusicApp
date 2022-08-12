package com.example.musicapppsql.service;

import com.example.musicapppsql.model.Albums;
import com.example.musicapppsql.model.Songs;
import com.example.musicapppsql.repository.AlbumsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Service
public class AlbumsService {

    @Autowired
    AlbumsRepository albumsRepository;

    public LocalTime totalLenghtAlbum(Long id){
        Optional<Albums> albums = albumsRepository.findById(id);
        LocalTime sum = LocalTime.of(0,0,0);
        List<Songs> songsList = albums.get().getSongsList();
        for (Songs songs:songsList){
            LocalTime lenght = songs.getLenght();
            sum = sum.plusHours(lenght.getHour())
                    .plusMinutes(lenght.getMinute())
                    .plusSeconds(lenght.getSecond());
        }
        return sum;
    }
}
