package it.epicode.w6d2task.controllers;

import it.epicode.w6d2task.models.Author;
import it.epicode.w6d2task.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping("/authors")
    public List<Author> getAuthorList() {
        return authorService.getAllAuthors();
    }

    @GetMapping("/authors/id")
    public Author getAuthorByIdQueryParams(@RequestParam int id) {
        return authorService.getAuthorById(id);
    }

    @GetMapping("/authors/{id}")
    public Author getAuthorByIdPathParam(@PathVariable int id) {
        return authorService.getAuthorById(id);
    }

    @PostMapping("/authors")
    public void createAuthor(@RequestBody Author author) {
        authorService.saveAuthor(author);
    }

    @PutMapping("/authors/{id}")
    public Author updateAuthor(@PathVariable int id, @RequestBody Author author) {
        return authorService.updateAuthor(id, author);
    }

    @DeleteMapping("/authors/{id}")
    public void deleteAuthor(@PathVariable int id) {
        authorService.deleteAuthor(id);
    }

}
