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

    @Step("Breeds[get]: Получить ID по названию породы животного")
    protected void getBreedID(String breedName) {
        API_CLIENT.getBREEDS_API().getBreedID(breedName);
    }

    @Step("Images[get]: Получить изображение по ID породы животного")
    protected void getPictureByBreedID() {
        API_CLIENT.getIMAGES_API().getPictureByBreedID();
    }

    @Step("Favourites[post]: Добавить в избранное полученное изображение")
    protected void addImageToFavourites() {
        API_CLIENT.getFAVOURITES_API().addImageToFavourites();
    }

    @Step("Favourites[get]: Получить данные из списка избранного")
    protected void getFavourites() {
        API_CLIENT.getFAVOURITES_API().getFavourites();
    }

    @Step("Favourites[delete]: Удалить изображение из списка избранного")
    protected void deleteImageFromFavourites() {
        API_CLIENT.getFAVOURITES_API().deleteImageFromFavourites();
    }

    @Step("Favourites[get]: Проверить, что изображение было удалено из списка избранного")
    protected void checkImageInFavouritesAfterDeletion() {
        API_CLIENT.getFAVOURITES_API().checkImageInFavouritesAfterDeletion();
    }
}
