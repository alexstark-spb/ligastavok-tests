package com.simbirsoft.derevyankoA.ui.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.simbirsoft.derevyankoA.ui.pages.AuthorizationPage;
import com.simbirsoft.derevyankoA.ui.pages.CatalogPage;
import com.simbirsoft.derevyankoA.ui.pages.ChecksPage;
import com.simbirsoft.derevyankoA.ui.pages.MainPage;
import io.qameta.allure.junit5.AllureJunit5;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;

import static com.simbirsoft.derevyankoA.ui.helpers.AllureAttachmentsUI.*;
import static io.qameta.allure.Allure.step;

@ExtendWith({AllureJunit5.class})
public class TestBaseUI {

    protected static final AuthorizationPage AUTHORIZATION_PAGE = new AuthorizationPage();
    protected static final MainPage MAIN_PAGE = new MainPage();
    protected static final CatalogPage CATALOG_PAGE = new CatalogPage();
    protected static final ChecksPage CHECKS_PAGE = new ChecksPage();

    @BeforeAll
    static void setupBeforeAll() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        Configuration.timeout = 6000;
        Configuration.browser = System.getProperty("browser", "chrome");
        Configuration.browserSize = System.getProperty("browserSize", "1600x900");
        Configuration.baseUrl = "https://passport.yandex.ru/auth/welcome";
        attachAsText("BrowserRun", System.getProperty("browser", "chrome"));
    }

    @AfterEach
    public void setupAfterEach() {
        screenshotAs("Last screenshot");
        pageSource();
        browserConsoleLogs();
        step("Закрытие браузера", Selenide::closeWebDriver);
    }
}
