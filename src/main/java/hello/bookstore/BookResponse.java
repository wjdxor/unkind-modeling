package hello.bookstore;

import java.time.LocalDateTime;

public class BookResponse {
    private Long isbn;
    private String title;
    private String content;
    private LocalDateTime localDateTime;

    public BookResponse(Long isbn, String title, String content, LocalDateTime localDateTime) {
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
