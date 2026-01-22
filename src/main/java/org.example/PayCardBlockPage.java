package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class PayCardBlockPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    public PayCardBlockPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public PayCardBlockPage payCard() {

        WebElement iframe = wait.until(
                ExpectedConditions.presenceOfElementLocated(
                        By.cssSelector("iframe[src*='bepaid']")
                )
        );
        driver.switchTo().frame(iframe);
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector(".payment-page__container")
        ));
        return this;
    }

    public String descriptionOrder() {
        return driver.findElement(
                By.cssSelector(".payment-page__order-description")
        ).getText();
    }

    public String textOrder() {
        return driver.findElement(
                By.cssSelector(".pay-description__cost span")
        ).getText();
    }

    public String payButton() {
        return driver.findElement(
                By.cssSelector("button[type='submit']")
        ).getText();
    }

    public String сardNumberPlaceholder() {
        return driver.findElement(By.xpath("//label[text()='Номер карты']")).getText();
    }

    public String periodPlaceholder() {
        return driver.findElement(By.xpath("//label[text()='Срок действия']")).getText();
    }

    public String cvcPlaceholder() {
        return driver.findElement(By.xpath("//label[text()='CVC']")).getText();
    }

    public String nameCardPlaceholder() {
        return driver.findElement(By.xpath("//label[text()='Имя и фамилия на карте']")).getText();
    }

    public List<WebElement> payIcons() {
        return driver.findElements(By.cssSelector(".cards-brands__container img"));
    }
}