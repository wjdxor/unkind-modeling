package hello.bookstore;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Configurer {
    public BookRepository bookRepository;
    public OrderRepository orderRepository;

    @Bean
    public BookService bookService() {
        return new BookService(bookRepository, orderRepository);
    }
}
