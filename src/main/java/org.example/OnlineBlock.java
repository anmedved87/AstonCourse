package org.example;


import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class OnlineBlock {

    private WebDriver driver;
    private WebDriverWait wait;

    public OnlineBlock(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public OnlineBlock open() {
        driver.get("https://www.mts.by/");
        return this;
    }

    public OnlineBlock closeCookiesIfPresent() {
        try {
            WebElement cookieButton = wait.until(
                    ExpectedConditions.elementToBeClickable(
                            By.xpath("//button[contains(text(),'Принять')]")
                    )
            );
            cookieButton.click();
        } catch (Exception ignored) {
        }
        return this;
    }

    public OnlineBlock scrollToBlock() {
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 1800);");
        return this;
    }

    public OnlineBlock selectTabServices() {
        WebElement tab = wait.until(ExpectedConditions.elementToBeClickable( By.xpath("//button[contains(.,'Услуги связи')]") )); tab.click(); return this;
    }

    public OnlineBlock selectTabHomeInternet() {
        driver.findElement(By.xpath("//button[contains(.,'Домашний интернет')]")).click();
        return this;
    }

    public OnlineBlock selectTabInstallment() {
        driver.findElement(By.xpath("//button[contains(.,'Рассрочка')]")).click();
        return this;
    }

    public OnlineBlock selectTabDebt() {
        driver.findElement(By.xpath("//button[contains(.,'Задолженность')]")).click();
        return this;
    }


    public WebElement getConnectionPhoneInput() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("connection-phone")));
    }

    public WebElement getConnectionSumInput() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("connection-sum")));
    }

    public WebElement getConnectionEmailInput() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("connection-email")));
    }

    public WebElement getConnectionContinueButton() {
        return wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("form#pay-connection button[type='submit']")));
    }


    public String getConnectionPhonePlaceholder() {
        return getConnectionPhoneInput().getAttribute("placeholder");
    }

    public String getConnectionSumPlaceholder() {
        return getConnectionSumInput().getAttribute("placeholder");
    }

    public String getConnectionEmailPlaceholder() {
        return getConnectionEmailInput().getAttribute("placeholder");
    }

    // --- Домашний интернет ---
    public OnlineBlock tabInternet() {
        public OnlineBlock tabInternet () {
            WebElement tab = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(.,'Домашний интернет')]")));
            tab.click();
            return this;
        }
    }

    public WebElement internetPhone() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("internet-phone")));
    }

    public WebElement internetSum() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("internet-sum")));
    }

    public WebElement internetEmail() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("internet-email")));
    }

    public WebElement internetContinueButton() {
        return wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("form#pay-internet button[type='submit']")
        ));
    }

    public String internetPhonePlaceholder() {
        return internetPhone().getAttribute("placeholder");
    }

    public String internetSumPlaceholder() {
        return internetSum().getAttribute("placeholder");
    }

    public String internetEmailPlaceholder() {
        return internetEmail().getAttribute("placeholder");
    }

    // --- Рассрочка ---
    public OnlineBlock tabInstallment() {
        driver.findElement(By.xpath("//button[contains(.,'Рассрочка')]")).click();
        return this;
    }

    public WebElement installmentScore() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("score-instalment")));
    }

    public WebElement installmentSum() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("instalment-sum")));
    }

    public WebElement installmentEmail() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("instalment-email")));
    }

    public WebElement installmentContinueButton() {
        return wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("form#pay-instalment button[type='submit']")
        ));
    }

    public String installmentScorePlaceholder() {
        return installmentScore().getAttribute("placeholder");
    }

    public String installmentSumPlaceholder() {
        return installmentSum().getAttribute("placeholder");
    }

    public String installmentEmailPlaceholder() {
        return installmentEmail().getAttribute("placeholder");
    }

    // --- Задолженность ---
    public OnlineBlock tabDebt() {
        driver.findElement(By.xpath("//button[contains(.,'Задолженность')]")).click();
        return this;
    }

    public WebElement debtScore() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("score-arrears")));
    }

    public WebElement debtSum() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("arrears-sum")));
    }

    public WebElement debtContinueButton() {
        return wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("form#pay-arrears button[type='submit']")
        ));
    }

    public String debtScorePlaceholder() {
        return debtScore().getAttribute("placeholder");
    }

    public String debtSumPlaceholder() {
        return debtSum().getAttribute("placeholder");
    }

}

