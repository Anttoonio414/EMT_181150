package mk.ukim.finki.emt_181150.service;

import mk.ukim.finki.emt_181150.model.Book;


import java.util.List;
import java.util.Optional;
import mk.ukim.finki.emt_181150.model.dto.BookDto;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;


public interface BookService {

    List<Book> listBooks();

    Page<Book> listBooksPaginated(SpringDataWebProperties.Pageable pageable);

    Optional<Book> findById(Long id);

    Optional<Book> create(BookDto bookDto);

    Optional<Book> update(Long id, BookDto bookDto);

    void deleteById(Long id);

    Optional<Book> take(Long id);

}
