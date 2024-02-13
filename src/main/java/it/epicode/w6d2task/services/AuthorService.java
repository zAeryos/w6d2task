package it.epicode.w6d2task.services;

import it.epicode.w6d2task.models.Author;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class AuthorService {

    private List<Author> authors = new ArrayList<>();

    public List<Author> getAllAuthors() {
        return authors;
    }

    public Author getAuthorById (int id) throws NoSuchElementException{
        Optional<Author> a = authors.stream().filter(author -> author.getId() == id).findAny();

        if (a.isPresent()) {
            return a.get();
        } else {
            throw new NoSuchElementException("Author not found");
        }
    }

    public void saveAuthor (Author author) {
        authors.add(author);
    }

    public Author updateAuthor (int id, Author author) throws NoSuchElementException{
        Author a = getAuthorById(id);

        a.setName(author.getName());
        a.setSurname(author.getSurname());
        a.setEmail(author.getEmail());
        a.setBirthday(author.getBirthday());
        a.setAvatar(author.getAvatar());

        return a;
    }

    public void deleteAuthor (int id) {
        Author author = getAuthorById(id);

        authors.remove(author);
    }
}
