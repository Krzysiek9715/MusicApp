package com.example.musicapppsql.model;


import com.example.musicapppsql.repository.AlbumsRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name = "albums")
@Data
public class Albums {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column
    private String performer;

    @Column
    private String title;

    @Column
    private LocalDate release_date;

    @ManyToMany
    private List<Songs> songsList;

    @Column
    private LocalTime totalLenght;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


}
