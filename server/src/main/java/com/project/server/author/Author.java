package com.project.server.author;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.server.article.Article;
import com.project.server.user.UserController;
import jakarta.persistence.*;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

import java.util.List;


@Entity
@Table
public class Author {
    @Id
    @SequenceGenerator(
            name = "author_sequence",
            sequenceName = "author_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "author_sequence"
    )
    private long id;
    private String name;
    private String profileImage;
    private String user;
    @OneToMany(mappedBy = "author", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JsonIgnore
    private List<Article> articles;

    public Author(String name, String profileImage) {
        this.name = name;
        this.profileImage = profileImage;
        this.user = getCurrentUser().getUsername();
    }

    public Author() {
    }

    public User getCurrentUser() {
        return ((User) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal());
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", profileImage='" + profileImage + '\'' +
                ", user='" + user + '\'' +
                '}';
    }
}
