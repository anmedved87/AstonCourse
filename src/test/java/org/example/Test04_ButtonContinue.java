package org.example;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Test04_ButtonContinue extends DriverTest {
    @Test
    void fillConnectionFormAndCheckContinueButton() {
        driver.get("https://www.mts.by/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        try {
            WebElement cookieButton = wait.until(
                    ExpectedConditions.elementToBeClickable(
                            By.xpath("//button[contains(text(),'Принять')]")
                    )
            );
            cookieButton.click();
        } catch (Exception ignored) {
        }
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,1800);");

        WebElement phoneInput = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.id("connection-phone")
                )
        );
        phoneInput.click();
        phoneInput.sendKeys("297777777");

        WebElement amountInput = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.id("connection-sum")
                )
        );
        amountInput.click();
        amountInput.sendKeys("10");

        WebElement emailInput = driver.findElement(
                By.id("connection-email")
        );
        emailInput.click();
        emailInput.sendKeys("an.medvedeva87@gmail.com");
        WebElement continueButton = driver.findElement(
                By.cssSelector("form#pay-connection button[type='submit']")
        );
        assertTrue(continueButton.isEnabled(), "Кнопка [Продолжить] должна быть активной");
        continueButton.click();
    }
}
