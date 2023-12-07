package com.project.server.article;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.server.league.League;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDate;

@Entity
@Table
public class Article {
    @Id
    @SequenceGenerator(
            name = "article_sequence",
            sequenceName = "article_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "article_sequence"
    )
    private Long id;
    private String title;
    private String headerImage;
    private String content;
    private String author;
    private LocalDate date;

    public Article(String title, String headerImage, String content, String author) {
        this.title = title;
        this.headerImage = headerImage;
        this.content = content;
        this.author = author;
        this.date = LocalDate.now();
    }

    public Article() {
        this.date = LocalDate.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getHeaderImage() {
        return headerImage;
    }

    public void setHeaderImage(String headerImage) {
        this.headerImage = headerImage;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", headerImage='" + headerImage + '\'' +
                ", content='" + content + '\'' +
                ", author='" + author + '\'' +
                ", date='" + date +
                '}';
    }
}
