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

    @Test
    @Feature("API tests: www.thecatapi.com")
    @Owner("Alexander Derevyanko")
    @Severity(SeverityLevel.NORMAL)
    @Link(name = "thecatapi.com/", url = "https://thecatapi.com/")
    @DisplayName("Добавление/удаление изображения в Favourites")
    void checkTheCatApiMethods() {
        getBreedID();
        getPictureByBreedID();
        addImageToFavourites();
    }
}
