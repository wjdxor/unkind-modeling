package hello.bookstore.fake;

import hello.bookstore.Book;
import hello.bookstore.BookRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class FakeBookRepository implements BookRepository {
    private final Map<Long, Book> books = new HashMap<>();

    @Override
    public Book save(Book book) {
        books.put(book.getIsbn(), book);
        return book;
    }

    @Override
    public List<Book> findAll() {
        return new ArrayList<>(books.values());
    }

    @Override
    public Optional<Book> findOne(Long isbn) {
        return Optional.of(books.get(isbn));
    }
}
