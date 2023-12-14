package com.project.server.article;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
    List<Article> findAllByLeague_Id(Long leagueId);
    List<Article> findAllByAuthor_Id(Long authorId);
}
