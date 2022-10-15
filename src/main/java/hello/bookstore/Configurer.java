package hello.bookstore;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Configurer {

    @Bean
    public BookService bookService() {
        return new BookService();
    }
}
