package hello.bookstore;

public class OrderResponse {
    private Long price;

    public OrderResponse(Long price) {
        this.price = price;
    }

    public Long getPrice() {
        return price;
    }
}
