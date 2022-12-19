package com.simbirsoft.derevyankoA.ui.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.SneakyThrows;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.simbirsoft.derevyankoA.ui.helpers.AllureAttachmentsUI.screenshotAs;
import static com.simbirsoft.derevyankoA.ui.tests.YandexMarketTests.MANUFACTURERS;
import static com.simbirsoft.derevyankoA.ui.tests.YandexMarketTests.MIN_PRICE;

public class CatalogPage {

    private static final SelenideElement
            TYPE_CATALOG = $("#catalogPopupButton").$(byText("Каталог")),
            TYPE_ELECTRONICS = $("#catalogPopup").$("[role='tablist']").$(byText("Электроника")),
            TYPE_TV_AND_ACC = $("[href='https://market.yandex.ru/catalog--televizory-i-aksessuary/26960170']"),
            TYPE_TELEVISION = $("[data-apiary-widget-name='@MarketNode/NavigationTree']").$(byText("Телевизоры")),
            SET_MIN_PRICE = $("[data-auto='filter-range-min'] input"),
            SET_CHECKBOXES = $("#search-filters"),
            SELECT_FIRST_TV = $("[data-auto='SerpPage']").$("[data-index='1'] img");

    @Step("Нажать на вкладку 'Каталог'")
    public CatalogPage typeCatalogTab() {
        TYPE_CATALOG.shouldBe(visible).click();
        screenshotAs("Скриншот страницы каталога");
        return this;
    }

    @Step("Нажать на подвкладку 'Электроника'")
    public CatalogPage typeElectronicsTab() {
        TYPE_ELECTRONICS.click();
        screenshotAs("Скриншот страницы с категорией 'Электроника'");
        return this;
    }

    @Step("На странице выбрать категорию 'Телевизоры и аксессуары -> Телевизоры'")
    public CatalogPage typeTvCategory() {
        TYPE_TV_AND_ACC.scrollIntoView(true).click();
        TYPE_TELEVISION.click();
        screenshotAs("Скриншот страницы с разделом 'Телевизоры'");
        return this;
    }

    @Step("Установить фильтр цены от")
    public CatalogPage setFilterMinPrice() {
        SET_MIN_PRICE.scrollTo().setValue(MIN_PRICE);
        screenshotAs("Скриншот минимальной цены товара");
        return this;
    }

    @Step("Установить чекбоксы производителей Samsung и LG")
    public CatalogPage setCheckboxes() {
        for (String checkbox : MANUFACTURERS) {
            SET_CHECKBOXES.$(byText(checkbox)).click();
        }
        screenshotAs("Скриншот выбранных чекбоксов производителя");
        return this;
    }

    @Step("Выбрать первый телевизор в списке")
    public CatalogPage selectTV() {
        SELECT_FIRST_TV.shouldBe(visible).scrollIntoView(true).click();
        screenshotAs("Скриншот выбора первого товара в списке");
        return this;
    }

    @SneakyThrows
    @Step("Перейти во вкладку браузера с выбранным товаром")
    public void switchToNewTabBrowser() {
        Selenide.switchTo().window(1);
        screenshotAs("Скриншот PDP страницы");
    }
}

