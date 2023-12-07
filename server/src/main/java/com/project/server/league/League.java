package com.project.server.league;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.server.article.Article;
import jakarta.persistence.*;

import java.util.List;


@Entity
@Table
public class League {
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
    private String imageRef;
    @OneToMany(mappedBy = "league", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JsonIgnore
    private List<Article> articles;

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    public League(String name, String imageRef) {
        this.name = name;
        this.imageRef = imageRef;
    }

    public League() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageRef() {
        return imageRef;
    }

    public void setImageRef(String imageRef) {
        this.imageRef = imageRef;
    }

}
