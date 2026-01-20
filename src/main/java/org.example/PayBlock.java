package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class PayBlock {

    private WebDriver driver;
    private WebDriverWait wait;

    public PayBlock(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public PayBlock waitLoaded() {
        wait.until(ExpectedConditions.urlContains("checkout"));
        return this;
    }

    public String getSummaryText() {
        WebElement block = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//*[contains(.,'Оплата: Услуги связи')]")
                )
        );
        return block.getText();
    }

    public String getAmountOnButton() {
        WebElement payButton = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//button[contains(.,'BYN')]")
                )
        );
        return payButton.getText();
    }

    public List<WebElement> getCardPlaceholders() {
        return driver.findElements(
                By.xpath("//input[@placeholder]")
        );
    }

    public List<WebElement> getPaymentLogos() {
        return driver.findElements(
                By.cssSelector("img")
        );
    }
}

