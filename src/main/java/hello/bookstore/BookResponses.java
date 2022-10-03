package hello.bookstore;

import java.util.List;

public class BookResponses {
    private List<BookResponse> bookResponses;

    public BookResponses(List<BookResponse> bookResponses) {
        this.bookResponses = bookResponses;
    }

    public List<BookResponse> getBookResponses() {
        return bookResponses;
    }
}
