package org.example;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NameBlockTest extends DriverTest {
    @Test
    void nameBlock() {
        driver.get("https://www.mts.by/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            WebElement cookieButton = wait.until(
                    ExpectedConditions.elementToBeClickable(
                            By.xpath("//button[contains(text(),'Принять')]")
                    )
            );
            cookieButton.click();
        } catch (Exception ignored) {
        }

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 1700);");

        WebElement blockTitle = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//h2[contains(.,'Онлайн пополнение') and contains(.,'без комиссии')]")
                )
        );
        String actualText = blockTitle.getText().replace("\n", " ").trim();
        assertEquals("Онлайн пополнение без комиссии", actualText);

    }
}
