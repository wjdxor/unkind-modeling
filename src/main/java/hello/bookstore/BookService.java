package hello.bookstore;

import java.util.List;
import java.util.stream.Collectors;

public class BookService {
    private final BookRepository bookRepository;
    private final OrderRepository orderRepository;

    public BookService(BookRepository bookRepository, OrderRepository orderRepository) {
        this.bookRepository = bookRepository;
        this.orderRepository = orderRepository;
    }

    public BookResponses findBooks() {
        // TODO : 로직을 완성하세요
        // 1. 책들의 리스트를 반환한다.
        List<Book> bookList = bookRepository.findAll();
        return new BookResponses(
            bookList.stream()
                .map(book -> new BookResponse(book.getIsbn(), book.getTitle(), book.getContent(), book.getLocalDateTime()))
                .collect(Collectors.toList()));
    }

    public BookResponse findBook(Long isbn) {
        // TODO : 로직을 완성하세요
        // 1. 책을 찾는다.
        Book book = bookRepository.findOne(isbn).orElseThrow();
        return new BookResponse(book.getIsbn(), book.getTitle(), book.getTitle(), book.getLocalDateTime());
    }

    public OrderResponse order(OrderRequest orderRequest) {
        // TODO : 로직을 완성하세요
        // 1. 책이 존재하는지 확인한다.
        if (bookRepository.findOne(orderRequest.getIsbn()).isEmpty()) {
            throw new IllegalArgumentException("책이 존재하지 않습니다.");
        }
        // 2. 할인이 있는지 확인한다.
        if (!orderRequest.getCouponId().isEmpty()) {
            // 할인 쿠폰에 대한 로직
        }
        // 3. 책과 주문 수량과 할인을 가지고 총 금액을 반환한다.
        Long price = orderRequest.getCount() * 100L - 10L;
        return new OrderResponse(price);
    }
}
