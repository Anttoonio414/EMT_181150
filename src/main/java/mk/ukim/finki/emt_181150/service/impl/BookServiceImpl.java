package mk.ukim.finki.emt_181150.service.impl;

import mk.ukim.finki.emt_181150.model.Author;
import mk.ukim.finki.emt_181150.model.Book;
import mk.ukim.finki.emt_181150.model.dto.BookDto;
import mk.ukim.finki.emt_181150.model.exceptions.AuthorNotFoundException;
import mk.ukim.finki.emt_181150.model.exceptions.BookNotFoundException;
import mk.ukim.finki.emt_181150.repository.AuthorRepository;
import mk.ukim.finki.emt_181150.repository.BookRepository;
import mk.ukim.finki.emt_181150.service.BookService;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Book> listBooks() {
        return this.bookRepository.findAll();
    }

    @Override
    public Page<Book> listBooksPaginated(SpringDataWebProperties.Pageable pageable) {
        return this.bookRepository.findAll((org.springframework.data.domain.Pageable) pageable);
    }

    @Override
    public Optional<Book> findById(Long id) {
        return this.bookRepository.findById(id);
    }

    @Override
    public Optional<Book> create(BookDto bookDto) {
        Author author = this.authorRepository.findById(bookDto.getAuthor()).orElseThrow(AuthorNotFoundException::new);
        return Optional.of(this.bookRepository.save(new Book(bookDto.getName(), bookDto.getCategory(), author, bookDto.getAvaliableCopies())));
    }

    @Override
    public Optional<Book> update(Long id, BookDto bookDto) {
        Book book = this.bookRepository.findById(id).orElseThrow(BookNotFoundException::new);

        Author author = this.authorRepository.findById(bookDto.getAuthor()).orElseThrow(AuthorNotFoundException::new);

        book.setName(bookDto.getName());

        book.setCategory(bookDto.getCategory());

        book.setAuthor(author);

        book.setAvaliableCopies(bookDto.getAvaliableCopies());

        return Optional.of(bookRepository.save(book));
    }

    @Override
    public void deleteById(Long id) {
      this.bookRepository.deleteById(id);
    }

    @Override
    public Optional<Book> take(Long id) {
        Book book = this.bookRepository.findById(id).orElseThrow(BookNotFoundException::new);
        int copies;
        if (book.getAvaliableCopies() > 0){
            copies = book.getAvaliableCopies() - 1;
        } else {
            copies = book.getAvaliableCopies();
        }
        book.setAvaliableCopies(copies);
        this.bookRepository.save(book);
        return Optional.of(book);
    }
}
