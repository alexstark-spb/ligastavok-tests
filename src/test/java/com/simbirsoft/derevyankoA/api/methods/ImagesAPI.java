package com.simbirsoft.derevyankoA.api.methods;

import com.simbirsoft.derevyankoA.api.endpoints.ApiEndpoints;
import com.simbirsoft.derevyankoA.api.jackson_entity.response.ImagesResponse;
import io.qameta.allure.Step;
import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.apache.http.HttpStatus;

import static com.simbirsoft.derevyankoA.api.methods.BreedsAPI.breedID;
import static com.simbirsoft.derevyankoA.api.specs.SpecsApi.requestSpec;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

@Data
@Log4j2
public class ImagesAPI {

    public static String imageID;
    public static String imageURL;

    @Step("Получение изображения")
    public void getPictureByBreedID() {
        ImagesResponse[] imagesList =
                given()
                        .spec(requestSpec())
                        .queryParam("breed_ids", breedID)
                        .when()
                        .get(ApiEndpoints.SEARCH_IMAGES.getEndpoint())
                        .then().statusCode(HttpStatus.SC_OK)
                        .log().all()
                        .extract().as(ImagesResponse[].class);

        imageID = imagesList[0].getIdImages();
        imageURL = imagesList[0].getUrlImages();

        assertThat(imagesList[0].getBreeds()[0].getIdBreed()).isEqualTo(breedID);
    }
}