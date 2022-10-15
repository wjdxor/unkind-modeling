package hello.bookstore;

import java.util.List;

public class OrderRequest {
    private Long isbn;
    private Long userId;
    private Long count;
    private List<Discount> couponId;

    public OrderRequest() {/*no-op*/}

    public OrderRequest(Long isbn, Long userId, Long count, List<Discount> couponId) {
        this.isbn = isbn;
        this.userId = userId;
        this.count = count;
        this.couponId = couponId;
    }

    public Long getIsbn() {
        return isbn;
    }

    public Long getUserId() {
        return userId;
    }

    public Long getCount() {
        return count;
    }

    public List<Discount> getCouponId() {
        return couponId;
    }

    @Override
    public String toString() {
        return "OrderRequest{" +
            "isbn=" + isbn +
            ", userId=" + userId +
            ", count=" + count +
            ", couponId=" + couponId +
            '}';
    }
}
