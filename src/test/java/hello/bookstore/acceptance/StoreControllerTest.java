package hello.bookstore.acceptance;

import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class StoreControllerTest {
    @LocalServerPort
    private int RANDOM_PORT;

    @BeforeEach
    void setUp() {
        RestAssured.port = RANDOM_PORT;
    }

    @Test
    @DisplayName("책을 주문한다")
    void orderBookTest() {
        Map<String, String> params = new HashMap<>();
        params.put("isbn", "1234");
        params.put("userId", "2");
        params.put("count", "2");

        ExtractableResponse<Response> response = RestAssured.given().log().all()
            .contentType(MediaType.APPLICATION_JSON_VALUE)
            .body(params)
            .when().post("/store/book")
            .then().log().all()
            .statusCode(HttpStatus.OK.value())
            .extract();

        Assertions.assertThat(response.statusCode()).isEqualTo(HttpStatus.OK.value());
    }

    @Test
    @DisplayName("책을 조회한다.")
    void findBook() {
        ExtractableResponse<Response> response = RestAssured.given().log().all()
            .when().get("/store/book/{isbn}","1234")
            .then().log().all()
            .extract();

        assertThat(response.statusCode()).isEqualTo(HttpStatus.OK.value());

    }

    @Test
    @DisplayName("책들을 조회한다.")
    void findBooks() {
        ExtractableResponse<Response> response = RestAssured.given().log().all()
            .when().get("/store/book")
            .then().log().all()
            .extract();

        assertThat(response.statusCode()).isEqualTo(HttpStatus.OK.value());

    }
}
