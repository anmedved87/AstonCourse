package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class PaymentConfirmationPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    public PaymentConfirmationPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public PaymentConfirmationPage waitLoaded() {

        // Ждём iframe оплаты и переключаемся в него
        WebElement iframe = wait.until(
                ExpectedConditions.presenceOfElementLocated(
                        By.cssSelector("iframe[src*='bepaid']")
                )
        );

        driver.switchTo().frame(iframe);

        // Ждём контейнер страницы оплаты
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector(".payment-page__container")
        ));

        return this;
    }

    public String getOrderDescriptionText() {
        return driver.findElement(
                By.cssSelector(".payment-page__order-description")
        ).getText();
    }

    public String getAmountText() {
        return driver.findElement(
                By.cssSelector(".pay-description__cost span")
        ).getText();
    }

    public String getPayButtonText() {
        return driver.findElement(
                By.cssSelector("button[type='submit']")
        ).getText();
    }


    public String getCardNumberLabel() {
        return driver.findElement(By.xpath("//label[text()='Номер карты']")).getText();
    }

    public String getExpirationLabel() {
        return driver.findElement(By.xpath("//label[text()='Срок действия']")).getText();
    }

    public String getCvcLabel() {
        return driver.findElement(By.xpath("//label[text()='CVC']")).getText();
    }

    public String getCardHolderLabel() {
        return driver.findElement(By.xpath("//label[text()='Имя и фамилия на карте']")).getText();
    } // ================= иконки платёжных систем =================

    public List<WebElement> getPaymentSystemIcons() {
        return driver.findElements(By.cssSelector(".cards-brands__container img"));
    }
}