package com.simbirsoft.derevyankoA.ui.tests;

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
 * Description: Иногда на открытой странице(рандомной) может появляться капча, для ее обхода
 * была создана учетная запись, с подтвержденным вторым почтовым ящиком.
 * Но при большом количестве запросов с одного IP-адреса капча все таки появляется.
 */

@Log4j2
@Tag("marketYandex")
public class YandexMarketTests extends TestBaseUI {

    public static final String MIN_PRICE = "20000";
    public static final String[] MANUFACTURERS = {"Samsung", "LG"};

    /**
     * Основной тест написанный по ТЗ
     */
    @Test
    @Feature("UI tests")
    @Owner("Alexander Derevyanko")
    @Severity(SeverityLevel.NORMAL)
    @Link(name = "market.yandex.ru", url = "https://market.yandex.ru/")
    @DisplayName("Проверка выбранных фильтров в карточке PDP товара")
    void checkProductFilters() {
        AUTHORIZATION_PAGE.openAuthorizationPage();
        MAIN_PAGE.openYandexMarketPage();
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

    /**
     * Дополнительный тест, с применением простой параметризации @ValueSource
     */
    @ValueSource(strings = {
            "danone",
            "playstation",
            "солнцезащитные очки"
    })
    @ParameterizedTest(name = ": {0}")
    @Feature("UI tests")
    @Owner("Alexander Derevyanko")
    @Severity(SeverityLevel.NORMAL)
    @Link(name = "market.yandex.ru", url = "https://market.yandex.ru/")
    @DisplayName("Поиск товара")
    void searchProducts(String product) {
        AUTHORIZATION_PAGE.openAuthorizationPage();
        MAIN_PAGE
                .openYandexMarketPage()
                .searchProduct(product);
    }
}
