package com.simbirsoft.derevyankoA.tests.ui;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.simbirsoft.derevyankoA.pages.ui.CatalogPage;
import com.simbirsoft.derevyankoA.pages.ui.ChecksPage;
import com.simbirsoft.derevyankoA.pages.ui.MainPage;
import io.qameta.allure.junit5.AllureJunit5;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;

import static com.simbirsoft.derevyankoA.helpers.AllureAttachments.*;
import static io.qameta.allure.Allure.step;

@ExtendWith({AllureJunit5.class})
public class TestBaseUI {

    public static final String MIN_PRICE = "20000";
    public static final String[] MANUFACTURERS = {"Samsung", "LG"};

    protected static final MainPage MAIN_PAGE = new MainPage();
    protected static final CatalogPage CATALOG_PAGE = new CatalogPage();
    protected static final ChecksPage CHECKS_PAGE = new ChecksPage();

    @BeforeAll
    static void setupBeforeAll() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        Configuration.browser = System.getProperty("browserName", "chrome");
        Configuration.browserSize = System.getProperty("browserSize", "1600x900");
        Configuration.baseUrl = "https://market.yandex.ru";
        attachAsText("BrowserRun", System.getProperty("browserName", "chrome"));
    }

    @AfterEach
    public void setupAfterEach() {
        screenshotAs("Last screenshot");
        pageSource();
        browserConsoleLogs();
        step("Закрытие браузера", Selenide::closeWebDriver);
    }
}
