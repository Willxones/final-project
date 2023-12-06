package com.project.server.article;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
    Optional<Article> findArticleByTitle(String title);
    List<Article> findByLeagueId(Long postId);

    @Transactional
    void deleteByLeagueId(long leagueId);
}
