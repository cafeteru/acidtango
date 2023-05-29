package io.github.acidtango.products.e2e;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import io.github.acidtango.products.domain.model.ProductDto;
import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;
import io.restassured.response.Response;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class ProductControllerE2ETest {
    private final String URL = "/products";

    @BeforeEach
    void setUp() {
        RestAssured.baseURI = "http://localhost:8081";
    }

    @Test
    void testWithoutSorts() {
        Response response = RestAssured.given()
            .get(URL)
            .then()
            .statusCode(HttpStatus.OK.value())
            .extract()
            .response();
        List<ProductDto> products = response.getBody().as(new TypeRef<>() {
        });
        assertFalse(products.isEmpty());
        assertEquals("V-NECH BASIC SHIRT", products.get(0).getName());
    }

    @ParameterizedTest
    @CsvSource({
        "totalUnits, desc, PLEATED T-SHIRT 3",
        "salesUnit, asc, SLOGAN T-SHIRT",
    })
    void testWithSorts(String sort, String direction, String firstName) {
        Response response = RestAssured.given()
            .queryParams("sort", sort + "," + direction)
            .get(URL)
            .then()
            .statusCode(HttpStatus.OK.value())
            .extract()
            .response();
        List<ProductDto> products = response.getBody().as(new TypeRef<>() {
        });
        assertFalse(products.isEmpty());
        assertEquals(firstName, products.get(0).getName());
    }
}
