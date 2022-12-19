package com.simbirsoft.derevyankoA.ui.pages;

import com.codeborne.selenide.SelenideElement;
import com.simbirsoft.derevyankoA.ui.config.AuthorizationConfig;
import io.qameta.allure.Step;
import org.aeonbits.owner.ConfigFactory;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.simbirsoft.derevyankoA.ui.helpers.AllureAttachmentsUI.screenshotAs;

public class AuthorizationPage {

    protected static AuthorizationConfig authorization = ConfigFactory.create(AuthorizationConfig.class);

    protected static final String LOGIN = authorization.login();
    protected static final String PASSWORD = authorization.password();

    private static final SelenideElement
            SET_LOGIN = $("#passp-field-login"),
            SET_PASSWORD = $("#passp-field-passwd"),
            SELECT_MAIL = $(".AuthLoginInputToggle-type button"),
            CHECK_PAGE_TITLE = $(".id-Text a");

    @Step("Открыть страницу авторизации passport.yandex.ru/auth/welcome")
    public void openAuthorizationPage() {
        open("/");
        SELECT_MAIL.click();
        SET_LOGIN.setValue(LOGIN).pressEnter();
        SET_PASSWORD.setValue(PASSWORD).pressEnter();
        CHECK_PAGE_TITLE.shouldHave(text("Данные"));
        screenshotAs("Скриншот авторизованной страницы ЛК");
    }
}
