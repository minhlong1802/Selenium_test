package org.example.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private WebDriver driver;

    // Các phần tử trên trang đăng nhập
    private By emailField = By.cssSelector("#email");
    private By passwordField = By.cssSelector("#pass");
    private By loginButton = By.cssSelector("button[name='login']");
    private By errorMessage = By.cssSelector("div._9ay7");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterEmail(String email) {
        WebElement emailElement = driver.findElement(emailField);
        emailElement.clear();
        emailElement.sendKeys(email);
    }

    public void enterPassword(String password) {
        WebElement passwordElement = driver.findElement(passwordField);
        passwordElement.clear();
        passwordElement.sendKeys(password);
    }

    public void clickLoginButton() {
        WebElement loginBtn = driver.findElement(loginButton);
        loginBtn.click();
    }

    public String getErrorMessage() {
        WebElement error = driver.findElement(errorMessage);
        return error.isDisplayed() ? error.getText() : "";
    }
}
