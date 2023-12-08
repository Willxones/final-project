package com.project.server.author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController {
    private final AuthorService authorService;
    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }
    @GetMapping
    public List<Author> getAuthors() {
        return authorService.findAllAuthors();
    }
    @GetMapping(path = "{authorId}")
    public Author getAuthor(@PathVariable("authorId") Long authorId) {
        return authorService.findAuthorById(authorId);
    }
    @PostMapping
    public void newAuthor(@RequestBody Author author) {
        authorService.newAuthor(author);
    }
    @DeleteMapping(path = "{authorId}")
    public void deleteAuthor(@PathVariable("authorId") Long authorId) {
        authorService.deleteAuthor(authorId);
    }
    @PutMapping
    public void updateAuthor(@RequestBody Author updatedAuthor) {
        authorService.updateAuthor(updatedAuthor);
    }
}
