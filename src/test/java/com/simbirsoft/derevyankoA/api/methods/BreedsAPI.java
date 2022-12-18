package com.simbirsoft.derevyankoA.api.methods;

import com.simbirsoft.derevyankoA.api.endpoints.ApiEndpoints;
import com.simbirsoft.derevyankoA.api.jackson_entity.response.BreedsResponse;
import io.qameta.allure.Step;
import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.apache.http.HttpStatus;

import static com.simbirsoft.derevyankoA.api.specs.SpecsApi.requestSpec;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.fail;

@Data
@Log4j2
public class BreedsAPI {

    public static final String BREED_NAME = "Scottish Fold";
    public static String breedID;

    @Step()
    public void getBreedID() {
        BreedsResponse[] breedsList =
                given()
                        .spec(requestSpec())
                        .when()
                        .get(ApiEndpoints.GET_BREEDS.getEndpoint())
                        .then().statusCode(HttpStatus.SC_OK)
                        .log().all()
                        .extract().as(BreedsResponse[].class);

        boolean isFound = false;
        for (BreedsResponse breed : breedsList) {
            if (breed.getNameBreed().equals(BREED_NAME)) {
                breedID = breed.getIdBreed();
                isFound = true;
                break;
            }
        }
        if (!isFound) {
            fail(String.format("Порода с ID: '%s' не найдена!", BREED_NAME));
        }
    }
}