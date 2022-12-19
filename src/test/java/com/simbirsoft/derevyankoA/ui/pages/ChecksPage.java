package com.simbirsoft.derevyankoA.ui.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.simbirsoft.derevyankoA.ui.helpers.AllureAttachmentsUI.screenshotAs;
import static com.simbirsoft.derevyankoA.ui.tests.YandexMarketTests.MANUFACTURERS;
import static com.simbirsoft.derevyankoA.ui.tests.YandexMarketTests.MIN_PRICE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

public class ChecksPage {

    private static final SelenideElement
            CHECK_PRICE = $("[data-auto='main']").$("[data-auto='mainPrice']"),
            CHECK_MANUFACTURER = $("[data-zone-name='productCardTitle'] img");

    @Step("Проверка стоимости товара")
    public ChecksPage checkPriceOfProduct() {
        int actualResult = Integer.parseInt(CHECK_PRICE.shouldBe(visible).text().replaceAll("[^0-9]", ""));
        assertThat(actualResult)
                .as("Цена товара меньше чем " + MIN_PRICE + " руб")
                .isGreaterThan(Integer.parseInt(MIN_PRICE));
        screenshotAs("Скриншот цены товара");
        return this;
    }

    @Step("Проверка производителя в заголовке товара")
    public void checkTitleOfProduct() {
        String actualResult = StringUtils.substringBetween(
                CHECK_MANUFACTURER.toString(), "alt=\"", "\" class");
        boolean isInclude = false;
        for (String manufacturer : MANUFACTURERS) {
            if (actualResult.contains(manufacturer)) {
                isInclude = true;
                break;
            }
        }
        if (!isInclude) {
            fail("В заголовке товара отсутствуют производители: " + Arrays.toString(MANUFACTURERS));
        }
        screenshotAs("Скриншот заголовка товара с производителем");
    }
}
