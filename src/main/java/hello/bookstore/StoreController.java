package hello.bookstore;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("store/book")
public class StoreController {

    private BookService bookService;

    @PostMapping(
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Void> orderBook(@RequestBody OrderRequest orderRequest) {
        bookService.order(orderRequest);
        return ResponseEntity.ok().build();
    }

    @GetMapping(
        value = "{isbn}",
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<BookResponse> findBook(@PathVariable Long isbn) {
        BookResponse response = bookService.findBook(isbn);
        return ResponseEntity.ok(response);
    }

    @GetMapping(
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<BookResponses> findBooks() {
        BookResponses responses = bookService.findBooks();
        return ResponseEntity.ok(responses);
    }
}
