package hello.bookstore;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class HelloController {

    @GetMapping("hello")
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok("hello");
    }

    @PostMapping("test")
    public ResponseEntity<OrderResponse> test(@RequestBody OrderRequest orderRequest) {
        log.info(orderRequest.toString());
        return ResponseEntity.ok(new OrderResponse(3_000L));
    }
}
