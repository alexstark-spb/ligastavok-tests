package com.simbirsoft.derevyankoA.api.tests;

import io.qameta.allure.*;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

/**
 * Author: Derevyanko A.S (Company: SimbirSoft)
 * Date create: 18.12.2022
 */

@Log4j2
@Tag("theCatAPI")
public class TheCatAPITests extends TestBaseAPI {

    public static final String BREED_NAME = "Scottish Fold";

    @Test
    @Feature("API tests")
    @Owner("Alexander Derevyanko")
    @Severity(SeverityLevel.NORMAL)
    @Link(name = "www.thecatapi.com", url = "https://thecatapi.com/")
    @DisplayName("Добавление/удаление изображения в Избранное")
    void checkTheCatApiMethods() {
        getBreedID(BREED_NAME);
        getPictureByBreedID();
        addImageToFavourites();
        getFavourites();
        deleteImageFromFavourites();
        checkImageInFavouritesAfterDeletion();
    }
}
