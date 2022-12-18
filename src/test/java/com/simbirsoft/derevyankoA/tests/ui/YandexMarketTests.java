package com.simbirsoft.derevyankoA.tests.ui;

import io.qameta.allure.*;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * Author: Derevyanko A.S (Company: SimbirSoft)
 * Date create: 17.12.2022
 */

@Log4j2
@Tag("marketYandex")
public class YandexMarketTests extends TestBaseUI {

    @Test
    @Feature("UI tests: market.yandex.ru")
    @Owner("Alexander Derevyanko")
    @Severity(SeverityLevel.NORMAL)
    @Link(name = "market.yandex.ru", url = "https://market.yandex.ru/")
    @DisplayName("Проверка выбранных фильтров в карточке PDP товара")
    void checkProductFilters() {
        MAIN_PAGE.openPage();
        CATALOG_PAGE
                .typeCatalogTab()
                .typeElectronicsTab()
                .typeTvCategory()
                .setFilterMinPrice()
                .setCheckboxes()
                .selectTV()
                .switchToNewTabBrowser();
        CHECKS_PAGE
                .checkPriceOfProduct()
                .checkTitleOfProduct();
    }

    @ValueSource(strings = {
            "danone",
            "playstation",
            "солнцезащитные очки"
    })
    @ParameterizedTest(name = ": {0}")
    @Feature("UI tests: market.yandex.ru")
    @Owner("Alexander Derevyanko")
    @Severity(SeverityLevel.NORMAL)
    @Link(name = "market.yandex.ru", url = "https://market.yandex.ru/")
    @DisplayName("Поиск товара")
    void searchProducts(String product) {
        MAIN_PAGE
                .openPage()
                .searchProduct(product);
    }
}
