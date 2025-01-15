package org.example.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    private WebDriver driver;

    // Các phần tử trên trang chủ
    private By avatar = By.cssSelector("img.avatar");
    private By username = By.cssSelector("span.username");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isAvatarDisplayed() {
        WebElement avatarElement = driver.findElement(avatar);
        return avatarElement.isDisplayed();
    }

    public boolean isUsernameDisplayed() {
        WebElement usernameElement = driver.findElement(username);
        return usernameElement.isDisplayed();
    }
}
