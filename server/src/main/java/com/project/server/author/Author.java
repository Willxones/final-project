package com.project.server.author;

import jakarta.persistence.*;


@Entity
@Table
public class Author {
    @Id
    @SequenceGenerator(
            name = "league_sequence",
            sequenceName = "league_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "league_sequence"
    )
    private long id;
    private String name;
    private String profileImage;
    private String user;

}
