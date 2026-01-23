package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.qameta.allure.Step;

import java.time.Duration;

public class OnlinePayBlockPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    public OnlinePayBlockPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    @Step("Открыть главную страницу сайта")
    public OnlinePayBlockPage open() {
        driver.get("https://www.mts.by/");
        return this;
    }

    @Step("Закрыть окно куки")
    public OnlinePayBlockPage closeCookie() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//button[contains(text(),'Принять')]")
            )).click();
        } catch (Exception ignored) {
        }
        return this;
    }

    @Step("Пролистать страницу до блока 'Онлайн пополнение без комиссии'")
    public OnlinePayBlockPage scroll() {
        ((JavascriptExecutor) driver)
                .executeScript("window.scrollBy(0,1800)");
        return this;
    }
    @Step("Открыть выпадающий список")
    private void openDropdown() {
        wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector(".select__header")
        )).click();
    }

    @Step("Выбрать вкладку 'Услуги связи'")
    public OnlinePayBlockPage openServices() {
        openDropdown();
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//p[text()='Услуги связи']")
        )).click();
        return this;
    }

    @Step("Выбрать вкладку 'Домашний интернет'")
    public OnlinePayBlockPage openInternet() {
        openDropdown();
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//p[text()='Домашний интернет']")
        )).click();
        return this;
    }

    @Step("Выбрать вкладку 'Рассрочка'")
    public OnlinePayBlockPage openInstallment() {
        openDropdown();
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//p[text()='Рассрочка']")
        )).click();
        return this;
    }

    @Step("Выбрать вкладку 'Задолженность'")
    public OnlinePayBlockPage openDuty() {
        openDropdown();
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//p[text()='Задолженность']")
        )).click();
        return this;
    }

    @Step("Ввести номер телефона: {phone}")
    public WebElement servicesPhone() {return driver.findElement(By.id("connection-phone"));
    }

    @Step("Ввести сумму: {amount}")
    public WebElement servicesSum() {
        return driver.findElement(By.id("connection-sum"));
    }

    @Step("Ввести email: {email}")
    public WebElement servicesEmail() {
        return driver.findElement(By.id("connection-email"));
    }

    @Step("Нажать кнопку 'Продолжить'")
    public WebElement servicesContinue() {
        return driver.findElement(By.cssSelector("form#pay-connection button"));
    }

    @Step("Проверить плейсхолдер поля Номер телефона для вкладки 'Услуг связи'")
    public String servicesPhonePlaceholder() {
        return servicesPhone().getAttribute("placeholder");
    }

    @Step("Проверить плейсхолдер поля Суммы для вкладки 'Услуг связи'")
    public String servicesSumPlaceholder() {
        return servicesSum().getAttribute("placeholder");
    }

    @Step("Проверить плейсхолдер поля Email для вкладки 'Услуг связи'")
    public String servicesEmailPlaceholder() {
        return servicesEmail().getAttribute("placeholder");
    }

    @Step("Проверить плейсхолдер Поля номер телефона для вкладки 'Домашний интернет'")
    public String internetPhonePlaceholder() {
        return driver.findElement(By.id("internet-phone"))
                .getAttribute("placeholder");
    }

    @Step("Проверить плейсхолдер поля Сумма для вкладки 'Домашний интернет'")
    public String internetSumPlaceholder() {
        return driver.findElement(By.id("internet-sum"))
                .getAttribute("placeholder");
    }

    @Step("Проверить плейсхолдер поля Email для вкладки 'Домашний интернет'")
    public String internetEmailPlaceholder() {
        return driver.findElement(By.id("internet-email"))
                .getAttribute("placeholder");
    }

    @Step("Проверить плейсхолдер поля Номер счёта на 44 для вкладки 'Рассрочка'")
    public String installmentScorePlaceholder() {
        return driver.findElement(By.id("score-instalment"))
                .getAttribute("placeholder");
    }

    @Step("Проверить плейсхолдер поля Сумма для вкладки 'Рассрочка'")
    public String installmentSumPlaceholder() {
        return driver.findElement(By.id("instalment-sum"))
                .getAttribute("placeholder");
    }

    @Step("Проверить плейсхолдер поля Email для вкладки 'Рассрочка'")
    public String installmentEmailPlaceholder() {
        return driver.findElement(By.id("instalment-email"))
                .getAttribute("placeholder");
    }

    @Step("Проверить плейсхолдер поля Номер счета на 2073 для вкладки 'Задолженность'")
    public String dutyScorePlaceholder() {
        return driver.findElement(By.id("score-arrears"))
                .getAttribute("placeholder");
    }

    @Step("Проверить плейсхолдер поля Сумма для вкладки 'Задолженность'")
    public String duutySumPlaceholder() {
        return driver.findElement(By.id("arrears-sum"))
                .getAttribute("placeholder");
    }

    @Step("Проверить плейсхолдер поля Email для вкладки 'Задолженность'")
    public String dutyEmailPlaceholder() {
        return driver.findElement(By.id("arrears-email"))
                .getAttribute("placeholder");
    }
}