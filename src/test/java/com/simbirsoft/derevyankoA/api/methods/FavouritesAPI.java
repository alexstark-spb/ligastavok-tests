package com.simbirsoft.derevyankoA.api.methods;

import com.simbirsoft.derevyankoA.api.endpoints.ApiEndpoints;
import com.simbirsoft.derevyankoA.api.jackson_entity.response.FavouritesResponse;
import io.qameta.allure.Step;
import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.apache.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

import static com.simbirsoft.derevyankoA.api.methods.ImagesAPI.imageID;
import static com.simbirsoft.derevyankoA.api.specs.SpecsApi.requestSpec;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

@Data
@Log4j2
public class FavouritesAPI {

    public static Integer favouritesID;
    public static String favouritesMessage;

    @Step()
    public void addImageToFavourites() {
        Map<String, Object> body = new HashMap<>();
        body.put("image_id", imageID);

        FavouritesResponse response =
                given()
                        .spec(requestSpec())
                        .body(body)
                        .when()
                        .post(ApiEndpoints.ADD_TO_FAVOURITES.getEndpoint())
                        .then().statusCode(HttpStatus.SC_OK)
                        .log().all()
                        .extract().as(FavouritesResponse.class);

        favouritesID = response.getIdFavourites();
        favouritesMessage = response.getMessageFavourites();

        assertThat(favouritesMessage).isEqualTo("SUCCESS");
    }
}