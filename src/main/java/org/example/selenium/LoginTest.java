package org.example.selenium;

import org.example.ultils.DriverSetup;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class LoginTest {
    public static void main(String[] args) {
        // Initialize WebDriver
        WebDriver driver = DriverSetup.getDriver();

        try {
            // Open Facebook page
            driver.get("https://www.facebook.com");
            System.out.println("Opened Facebook page successfully.");

            // Test Case 2: Non-existent account
            loginTest(driver, "nonexistent_email@gmail.com", "any_password");

            // Test Case 3: Wrong password
            loginTest(driver, "example@gmail.com", "wrong_password");

            // Test Case 4: Empty fields
            loginTest(driver, "", "");

            // Test Case 5: Invalid email format
            loginTest(driver, "invalidemail", "password123");

            // Test Case 1: Successful login
            loginTest(driver, "nguyenlongdang76@gmail.com", "nguyenlong");

        } finally {
            // Close the browser
            driver.quit();
        }
    }

    // Login test function
    public static void loginTest(WebDriver driver, String email, String password) {
        try {
            // Find input fields using CSS selectors
            WebElement emailField = driver.findElement(By.cssSelector("#email"));
            WebElement passwordField = driver.findElement(By.cssSelector("#pass"));
            WebElement loginButton = driver.findElement(By.cssSelector("button[name='login']"));

            // Enter credentials
            emailField.clear();
            emailField.sendKeys(email);
            passwordField.clear();
            passwordField.sendKeys(password);

            // Click login button
            loginButton.click();

            // Use WebDriverWait to check URL and UI state
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.or(
                    ExpectedConditions.urlContains("facebook.com"),
                    ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div._9ay7"))
            ));

            // Check URL after login
            String currentUrl = driver.getCurrentUrl();

            if (currentUrl.contains("facebook.com/two_step_verification")) {
                System.out.println("Login successful but requires two-step verification with email: " + email);
            } else if (currentUrl.equals("https://www.facebook.com/")) {
                // Verify user-specific elements
                WebElement avatar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img.avatar")));
                WebElement username = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.username")));
                if (avatar.isDisplayed() && username.isDisplayed()) {
                    System.out.println("Login successful and redirected to homepage with email: " + email);
                } else {
                    System.out.println("Login successful but user-specific elements not found with email: " + email);
                }
            } else {
                // Check for error messages
                List<WebElement> errorMessages = driver.findElements(By.cssSelector("div._9ay7"));
                if (!errorMessages.isEmpty()) {
                    System.out.println("Login failed with email: " + email);
                    System.out.println("Error message: " + errorMessages.get(0).getText());
                    // Close error message
                    WebElement closeButton = errorMessages.get(0).findElement(By.cssSelector("button.close"));
                    if (closeButton != null) {
                        closeButton.click();
                    }
                    // Take a screenshot
                    takeScreenshot(driver, "error_screenshot");
                } else {
                    System.out.println("Login failed with email: " + email + " but no error message found.");
                }
            }
        } catch (Exception e) {
            System.out.println("Error during test with email: " + email + " and password: " + password);
            e.printStackTrace();
            // Take a screenshot
            takeScreenshot(driver, "exception_screenshot");
        }
    }

    // Function to take a screenshot
    public static void takeScreenshot(WebDriver driver, String baseFileName) {
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
        String filePath = baseFileName + "_" + timestamp + ".png";
        try {
            Files.copy(screenshot.toPath(), Paths.get(filePath));
            System.out.println("Screenshot saved to: " + filePath);
        } catch (IOException e) {
            System.out.println("Failed to save screenshot: " + e.getMessage());
        }
    }
}