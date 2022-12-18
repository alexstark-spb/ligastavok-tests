package com.simbirsoft.derevyankoA.api.tests;

import com.simbirsoft.derevyankoA.api.client.ApiClient;
import io.qameta.allure.Step;
import io.qameta.allure.junit5.AllureJunit5;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.extension.ExtendWith;

import java.io.IOException;

import static com.simbirsoft.derevyankoA.api.helpers.AllureAttachmentsAPI.attachAsTextFile;

@ExtendWith({AllureJunit5.class})
public class TestBaseAPI {

    protected final ApiClient API_CLIENT = new ApiClient();

    @AfterEach
    public void attachment() throws IOException {
        attachAsTextFile("Вложение: Информация о породе животного");
    }

    @Step("Breeds: Получить ID по названию породы животного")
    protected void getBreedID() {
        API_CLIENT.getBREEDS_API().getBreedID();
    }

    @Step("Images: Получить изображение по ID породы животного")
    protected void getPictureByBreedID() {
        API_CLIENT.getIMAGES_API().getPictureByBreedID();
    }

    @Step("Favourites: Добавить в избранное полученное изображение")
    protected void addImageToFavourites() {
        API_CLIENT.getFAVOURITES_API().addImageToFavourites();
    }
}
