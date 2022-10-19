package hello.bookstore.mock;

import hello.bookstore.Book;
import hello.bookstore.BookResponse;
import hello.bookstore.BookResponses;
import hello.bookstore.BookService;
import hello.bookstore.Discount;
import hello.bookstore.OrderRequest;
import hello.bookstore.OrderResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

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

    @Test
    @DisplayName("책을 찾는다.")
    void findBooksTest() {
        //give
        Mockito.when(bookService.findBooks()).thenReturn(new BookResponses(Arrays.asList(new BookResponse(1L, "책이름1", "책내용1", LocalDateTime.now()), new BookResponse(2L, "책이름2", "책내용2", LocalDateTime.now()))));

        //then
        assertThat(bookService.findBooks().getBookResponses().size()).isEqualTo(2);
    }

    @Test
    @DisplayName("주문 테스트")
    void orderBookTest() {
        //given
        OrderRequest request = new OrderRequest(1L, 1L, 1L, List.of(Discount.TEN_PERCENT));
        //when
        Mockito.when(bookService.order(request)).thenReturn(new OrderResponse(90L));
        //then
        assertThat(bookService.order(request).getPrice()).isEqualTo(90L);
    }
}
