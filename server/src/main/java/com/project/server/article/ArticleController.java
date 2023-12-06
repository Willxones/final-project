package com.project.server.article;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/article")
public class ArticleController {
    private final ArticleService articleService;
    @Autowired
    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }
    @PostMapping
    public void createArticle(@RequestBody Article article) {
        articleService.createArticle(article);
    }
    @GetMapping(value = "{articleId}")
    public Article getFullArticle(@PathVariable("articleId") Long id) {
        return articleService.retrieveFullArticle(id);
    }
    @DeleteMapping(value = "{articleId}")
    public void deleteArticle(@PathVariable("articleId") Long id) {
        articleService.deleteArticle(id);
    }
    @PutMapping
    public void updateArticle(@RequestBody Article updatedArticle) {
        articleService.updateArticle(updatedArticle);
    }
}
