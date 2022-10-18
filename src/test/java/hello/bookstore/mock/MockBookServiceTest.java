package hello.bookstore.mock;

import hello.bookstore.Book;
import hello.bookstore.BookRepository;
import hello.bookstore.BookResponse;
import hello.bookstore.BookService;
import hello.bookstore.OrderRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

public class MockBookServiceTest {
    @Mock
    BookRepository bookRepository;
    @Mock
    OrderRepository orderRepository;

    @InjectMocks
    BookService bookService;

    @Test
    @DisplayName("책을 조회한다.")
    void findBookTest() {
        Mockito.when(bookService.findBook(123L)).thenReturn(new BookResponse(123L, "책이름", "책내용", LocalDateTime.now()));

        assertThat(bookService.findBook(123L).getTitle()).isEqualTo("책이름");
    }
}
