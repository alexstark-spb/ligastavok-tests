package com.simbirsoft.derevyankoA.api.specs;

import com.simbirsoft.derevyankoA.api.helpers.AllureRestAssuredFilter;
import io.restassured.specification.RequestSpecification;

import static com.simbirsoft.derevyankoA.api.client.ApiClient.BASE_URL;
import static io.restassured.RestAssured.with;

public class SpecsApi {

    public static RequestSpecification requestSpec() {
        return with()
                .filter(AllureRestAssuredFilter.withCustomTemplates())
                .log().all()
                .contentType("application/json; charset=utf-8")
                .header("x-api-key", System.getProperty("apiKey",
                        "live_xZHJvMkAPINyGZRr26V3ZCoD37OAb9FePRDKvaTRLD2dfqC0FSvR0h1Bim9oY1zp"))
                .baseUri(BASE_URL);
    }
}
