package mk.ukim.finki.emt_181150.service;

import mk.ukim.finki.emt_181150.model.Author;
import org.springframework.stereotype.Service;

import java.util.List;

public interface AuthorService {

    List<Author> listAuthors();

}
