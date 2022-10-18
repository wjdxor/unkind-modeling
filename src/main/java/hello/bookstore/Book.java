package hello.bookstore;

import java.time.LocalDateTime;

public class Book {
    private final Long isbn;
    private final String title;
    private final String content;
    private final LocalDateTime localDateTime;


    public Book(Long isbn, String title, String content, LocalDateTime localDateTime) {
        this.isbn = isbn;
        this.title = title;
        this.content = content;
        this.localDateTime = localDateTime;
    }

    public Long getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }
}
