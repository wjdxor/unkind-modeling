package hello.bookstore.mock;

import hello.bookstore.BookResponse;
import hello.bookstore.BookService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

public class MockBookServiceTest {
    @Mock
    BookService bookService;

    @BeforeEach
    void setUp() {
        bookService = mock(BookService.class);
    }

    @Test
    @DisplayName("책을 조회한다.")
    void findBookTest() {
        Mockito.when(bookService.findBook(123L)).thenReturn(new BookResponse(123L, "책이름", "책내용", LocalDateTime.now()));

        assertThat(bookService.findBook(123L).getTitle()).isEqualTo("책이름");
    }
}
