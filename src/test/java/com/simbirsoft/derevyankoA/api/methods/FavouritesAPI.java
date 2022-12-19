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
import static org.assertj.core.api.Fail.fail;

@Data
@Log4j2
public class FavouritesAPI {

    private static Integer favouritesID;
    private static String favouritesMessage;
    private static String favouritesImageID;

    @Step("Добавление изображения в избранное")
    public void addImageToFavourites() {
        Map<String, Object> body = new HashMap<>();
        body.put("image_id", imageID);

        FavouritesResponse response =
                given()
                        .spec(requestSpec())
                        .body(body)
                        .when()
                        .post(ApiEndpoints.FAVOURITES.getEndpoint())
                        .then().statusCode(HttpStatus.SC_OK)
                        .log().all()
                        .extract().as(FavouritesResponse.class);

        favouritesID = response.getIdFavourites();
        favouritesMessage = response.getMessageFavourites();

        assertThat(favouritesMessage).isEqualTo("SUCCESS");
    }

    @Step("Получение списка избранного")
    public void getFavourites() {
        FavouritesResponse[] favouritesList =
                given()
                        .spec(requestSpec())
                        .when()
                        .get(ApiEndpoints.FAVOURITES.getEndpoint())
                        .then().statusCode(HttpStatus.SC_OK)
                        .log().all()
                        .extract().as(FavouritesResponse[].class);

        boolean isFound = false;
        for (FavouritesResponse favourites : favouritesList) {
            favouritesImageID = favourites.getImageIdFavourites();
            if (favourites.getIdFavourites().equals(favouritesID)) {
                isFound = true;
                assertThat(favouritesImageID).isEqualTo(imageID);
                break;
            }
        }  if (!isFound) {
            fail(String.format("Изображение с ID: '%s' не найдено в избранном!", favouritesID));
        }
    }

    @Step("Удаление изображения из избранного")
    public void deleteImageFromFavourites() {
        FavouritesResponse response =
                given()
                        .spec(requestSpec())
                        .pathParam("favouritesID", favouritesID)
                        .when()
                        .delete(ApiEndpoints.DELETE_FROM_FAVOURITES.getEndpoint())
                        .then().statusCode(HttpStatus.SC_OK)
                        .log().all()
                        .extract().as(FavouritesResponse.class);

        favouritesMessage = response.getMessageFavourites();

        assertThat(favouritesMessage).isEqualTo("SUCCESS");
    }

    @Step("Проверка удаленного изображения из избранного")
    public void checkImageInFavouritesAfterDeletion() {
        FavouritesResponse[] favouritesList =
                given()
                        .spec(requestSpec())
                        .when()
                        .get(ApiEndpoints.FAVOURITES.getEndpoint())
                        .then().statusCode(HttpStatus.SC_OK)
                        .log().all()
                        .extract().as(FavouritesResponse[].class);

        boolean isFound = false;
        for (FavouritesResponse favourites : favouritesList) {
            if (favourites.getIdFavourites().equals(favouritesID)) {
                isFound = true;
                break;
            }
        }  if (isFound) {
            fail(String.format("Изображение с ID: '%s' не было удалено из списка избранного!", favouritesID));
        } else {
            System.out.printf("Изображение с ID: '%s' удалено и отсутствует в списке избранного!%n", favouritesID);
        }
    }
}