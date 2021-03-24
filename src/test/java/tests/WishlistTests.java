package tests;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.URLENC;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;

class WishlistTests extends TestBase {

    @Test
    void ICanAddItemToWishlistTest() {

        String list = given()
                .contentType(URLENC)
                .body("product_attribute_5_7_1=1&addtocart_5.EnteredQuantity=1")
                .when()
                .post("/addproducttocart/details/5/2")
                .then()
                .statusCode(200)
                .body("success", is(true))
                .extract().response()
                .body()
                .jsonPath()
                .get("updatetopwishlistsectionhtml");

        assertEquals("(1)", list);
    }
}
