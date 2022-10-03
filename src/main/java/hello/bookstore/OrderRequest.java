package hello.bookstore;

import java.util.List;

public class OrderRequest {
    private Long isbn;
    private Long userId;
    private Long count;
    private List<Discount> couponId;

    private OrderRequest() {/*no-op*/}

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
}
