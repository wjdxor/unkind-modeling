package hello.bookstore;

import java.util.List;

public class OrderRequest {
    private Long isbn;
    private Long userId;
    private Long count;
    private List<Long> couponId;

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

    public List<Long> getCouponId() {
        return couponId;
    }
}
