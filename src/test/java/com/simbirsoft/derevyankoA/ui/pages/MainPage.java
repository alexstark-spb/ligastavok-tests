package com.simbirsoft.derevyankoA.ui.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.simbirsoft.derevyankoA.ui.helpers.AllureAttachmentsUI.screenshotAs;

public class MainPage {

    private static final SelenideElement
            CHECK_PAGE_TITLE = $("[data-baobab-name='header']"),
            ENTER_IN_SEARCHBAR = $("#header-search"),
            CHECK_SEARCH_RESULT = $("[data-grabber='SearchBreadcrumbs']");

    @Step("Открыть страницу market.yandex.ru")
    public MainPage openYandexMarketPage() {
        open("https://market.yandex.ru/");
        CHECK_PAGE_TITLE.shouldHave(text("Маркет"));
        screenshotAs("Скриншот главной страницы ЯндексМаркет");
        return this;
    }

    @Step("Ввести название товара в поисковую строку")
    public void searchProduct(String product) {
        ENTER_IN_SEARCHBAR.setValue(product).pressEnter();
        CHECK_SEARCH_RESULT.shouldHave(text(product));
        screenshotAs("Скриншот главной страницы ЯндексМаркет");
    }
}
