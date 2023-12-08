package com.project.server.article;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "article")
public class ArticleController {
    private final ArticleService articleService;
    @Autowired
    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }
    @PostMapping(value = "{leagueId}")
    public void createArticle(@RequestBody Article article, @PathVariable("leagueId") Long leagueId) {
        articleService.createArticle(article, leagueId);
    }
    @GetMapping(value = "{articleId}")
    public Article getFullArticle(@PathVariable("articleId") Long id) {
        return articleService.retrieveFullArticle(id);
    }
    @GetMapping
    public List<Article> getAllArticles() {
        return articleService.findAllArticles();
    }
    @GetMapping(path = "league/{leagueId}")
    public List<Article> findArticlesByLeague(@PathVariable("leagueId") Long leagueId) {
        return articleService.findArticlesByLeague(leagueId);
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
