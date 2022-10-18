package hello.bookstore.fake;

import hello.bookstore.Book;
import hello.bookstore.BookService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;


public class FakeBookServiceTest {
    FakeBookRepository bookRepository = new FakeBookRepository();
    FakeOrderRepository orderBookRepository = new FakeOrderRepository();
    BookService bookService;

    @BeforeEach
    void setUp() {
        bookService = new BookService(bookRepository, orderBookRepository);
    }

    @Test
    @DisplayName("책을 조회한다.")
    void findBookTest() {
        //given
        Book book = new Book(123L,"책이름", "책내용", LocalDateTime.now());
        bookRepository.save(book);
        //then
        Assertions.assertThat(bookService.findBook(123L).getTitle()).isEqualTo("책이름");
    }

    @Test
    void findBooksTest() {
        //given
        bookRepository.save(new Book(1L,"책이름", "책내용", LocalDateTime.now()));
        bookRepository.save(new Book(2L,"책이름", "책내용", LocalDateTime.now()));
        bookRepository.save(new Book(3L,"책이름", "책내용", LocalDateTime.now()));
        //then
        Assertions.assertThat(bookService.findBooks().getBookResponses().size()).isEqualTo(3);
    }
    
}
