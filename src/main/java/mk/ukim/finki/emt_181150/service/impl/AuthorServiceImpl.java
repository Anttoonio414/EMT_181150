package mk.ukim.finki.emt_181150.service.impl;

import mk.ukim.finki.emt_181150.model.Author;
import mk.ukim.finki.emt_181150.repository.AuthorRepository;
import mk.ukim.finki.emt_181150.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {


    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }


    @Override
    public List<Author> listAuthors() {
        return this.authorRepository.findAll();
    }


}
