package hello.bookstore.fake;

import hello.bookstore.Order;
import hello.bookstore.OrderRepository;

import java.util.HashMap;
import java.util.Map;

public class FakeOrderRepository implements OrderRepository {
    private Map<Long, Order> orders = new HashMap<>();



}
