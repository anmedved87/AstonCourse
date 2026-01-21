package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;
import java.util.List;

public class PaymentConfirmationPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public PaymentConfirmationPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    // Ждём появления контейнера страницы оплаты
    public PaymentConfirmationPage waitLoaded() {
        wait.until(ExpectedConditions.presenceOfElementLocated(
                By.cssSelector(".payment-page__container")
        ));
        return this;
    }

    // Получаем текст с номером телефона и описанием
    public String getOrderDescriptionText() {
        return driver.findElement(By.cssSelector(".payment-page__order-description")).getText();
    }

    // Получаем сумму из блока .pay-description__cost
    public String getAmountText() {
        return driver.findElement(By.cssSelector(".pay-description__cost span")).getText();
    }

    // Получаем текст кнопки оплаты
    public String getPayButtonText() {
        return driver.findElement(By.xpath("//button[contains(.,'BYN') or contains(.,'RUB')]")).getText();
    }

    // Получаем все поля с плейсхолдерами
    public List<WebElement> getCardFields() {
        return driver.findElements(By.xpath("//input[@placeholder]"));
    }

    // Получаем все логотипы платёжных систем
    public List<WebElement> getPaymentIcons() {
        return driver.findElements(By.cssSelector("img"));
    }
}
