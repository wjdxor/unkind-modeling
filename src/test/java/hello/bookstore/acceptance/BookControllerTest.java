package hello.bookstore.acceptance;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BookControllerTest {
    @LocalServerPort
    private int RANDOM_PORT;

    @BeforeEach
    void setUp() {
        RestAssured.port = RANDOM_PORT;
    }

    @Test
    void hello() {
        ExtractableResponse<Response> response = RestAssured
            .given().log().all()
            .when().get("/hello")
            .then().log().all()
            .extract();

        assertThat(response.statusCode()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.body().asString()).isEqualTo("hello");
    }

    @Test
    void test() {
        Map<String, String> params = new HashMap<>();
        params.put("isbn", "1234");
        params.put("userId", "2");
        params.put("count", "2");
//        params.put("couponId", "FIVE_PERCENT");

        ExtractableResponse<Response> response = RestAssured.given().log().all()
            .contentType(MediaType.APPLICATION_JSON_VALUE)
            .body(params)
            .when().post("/test")
            .then().log().all()
            .statusCode(HttpStatus.OK.value())
            .extract();
    }
}
