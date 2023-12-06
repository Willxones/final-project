package com.project.server.article;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ArticleService {
    private final ArticleRepository articleRepository;
    @Autowired
    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    public void createArticle(Article article) {

        articleRepository.save(article);
    }

    public Article retrieveFullArticle(Long id) {
        Optional<Article> retrievedArticle = articleRepository.findById(id);

        if (retrievedArticle.isPresent()) {
            // Article with the specified ID exists
            return retrievedArticle.get();
        } else {
            // Article with the specified ID does not exist
            throw new IllegalStateException("Article does not exist");
        }
    }

    public void deleteArticle(Long id) {
        if (!articleRepository.existsById(id)) {
            throw new IllegalStateException("Article does not exist");
        }
        articleRepository.deleteById(id);
    }
    @Transactional
    public void updateArticle(Article updatedArticle) {
        Article originalArticle = articleRepository.findById(updatedArticle.getId()).orElseThrow(() -> new IllegalStateException(
                "Article with id " + updatedArticle.getId() + " does not exist."
        ));
        originalArticle.setTitle(updatedArticle.getTitle());
        originalArticle.setAuthor(updatedArticle.getAuthor());
        originalArticle.setContent(updatedArticle.getContent());
        originalArticle.setHeaderImage(updatedArticle.getHeaderImage());
    }
}
