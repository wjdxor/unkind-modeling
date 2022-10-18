package hello.bookstore.fake;

import hello.bookstore.Book;
import hello.bookstore.BookResponse;
import hello.bookstore.BookService;
import hello.bookstore.Discount;
import hello.bookstore.OrderRequest;
import hello.bookstore.OrderResponse;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.*;


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
        Book book = new Book(123L, "책이름", "책내용", LocalDateTime.now());
        bookRepository.save(book);
        //then
        assertThat(bookService.findBook(123L).getTitle()).isEqualTo("책이름");
    }

    @Test
    void findBooksTest() {
        //given
        bookRepository.save(new Book(1L, "책이름", "책내용", LocalDateTime.now()));
        bookRepository.save(new Book(2L, "책이름", "책내용", LocalDateTime.now()));
        bookRepository.save(new Book(3L, "책이름", "책내용", LocalDateTime.now()));
        //then
        assertThat(bookService.findBooks().getBookResponses().size()).isEqualTo(3);
    }

    @Test
    void orderBookTest() {
        //given
        bookRepository.save(new Book(1L, "책이름", "책내용", LocalDateTime.now()));
        OrderRequest request = new OrderRequest(1L, 1L, 1L, List.of(Discount.TEN_PERCENT));
        //when
        OrderResponse response = bookService.order(request);
        //then
        assertThat(response.getPrice()).isEqualTo(90L);
    }
}
