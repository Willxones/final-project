package com.project.server.author;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {
    private final AuthorRepository authorRepository;
    @Autowired
    public AuthorService(AuthorRepository authorRepository) {this.authorRepository = authorRepository;}
    public List<Author> findAllAuthors() {
        return authorRepository.findAll();
    }

    public Author findAuthorById(Long authorId) {
        Optional<Author> author = authorRepository.findById(authorId);
        if (author.isEmpty()) {
            throw new IllegalStateException("Author does not exist");
        }
        return author.get();
    }

    public void newAuthor(Author author) {
    }

    public void deleteAuthor(Long authorId) {
        if (!authorRepository.existsById(authorId)) {
            throw new IllegalStateException("League does not exist");
        }
        authorRepository.deleteById(authorId);
    }
    @Transactional
    public void updateAuthor(Author updatedAuthor) {
        Author originalAuthor = authorRepository.findById(updatedAuthor.getId()).orElseThrow(() -> new IllegalStateException(
                "Author with id " + updatedAuthor.getId() + " does not exist."
        ));
        originalAuthor.setName(updatedAuthor.getName());
        originalAuthor.setProfileImage(updatedAuthor.getProfileImage());
    }
}
