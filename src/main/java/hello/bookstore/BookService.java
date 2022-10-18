package hello.bookstore;

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

        return null;
    }

    public BookResponse findBook(Long isbn) {
        // TODO : 로직을 완성하세요
        // 1. 책을 찾는다.
        return null;
    }

    public OrderResponse order(OrderRequest orderRequest) {
        // TODO : 로직을 완성하세요
        // 1. 책이 존재하는지 확인한다.
        // 2. 할인이 있는지 확인한다.
        // 3. 책과 주문 수량과 할인을 가지고 총 금액을 반환한다.
        return null;
    }
}
