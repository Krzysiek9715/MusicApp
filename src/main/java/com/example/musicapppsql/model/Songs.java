package com.example.musicapppsql.model;


import lombok.Data;

import javax.persistence.*;
import java.time.LocalTime;

@Entity
@Table(name = "songs")
@Data
public class Songs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column
    private String title;

    @Column
    private LocalTime lenght;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
