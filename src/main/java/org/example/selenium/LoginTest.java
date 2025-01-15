package org.example.selenium;

import org.example.selenium.pages.HomePage;
import org.example.selenium.pages.LoginPage;
import org.example.ultils.DriverSetup;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.time.format.DateTimeFormatter;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;

public class LoginTest {
    public static void main(String[] args) {
        // Khởi tạo WebDriver
        WebDriver driver = DriverSetup.getDriver();

        try {
            // Mở trang Facebook
            driver.get("https://www.facebook.com");
            System.out.println("Opened Facebook page successfully.");

            // Tạo đối tượng Page Object
            LoginPage loginPage = new LoginPage(driver);
            HomePage homePage = new HomePage(driver);

            // Kiểm thử với các trường hợp khác nhau
            testLogin(driver, loginPage, homePage, "nonexistent_email@gmail.com", "any_password");
            testLogin(driver, loginPage, homePage, "example@gmail.com", "wrong_password");
            testLogin(driver, loginPage, homePage, "", "");
            testLogin(driver, loginPage, homePage, "invalidemail", "password123");
            testLogin(driver, loginPage, homePage, "nguyenlongdang76@gmail.com", "nguyenlong");

        } finally {
            // Đóng trình duyệt
            driver.quit();
        }
    }

    public static void testLogin(WebDriver driver, LoginPage loginPage, HomePage homePage, String email, String password) {
        try {
            loginPage.enterEmail(email);
            loginPage.enterPassword(password);
            loginPage.clickLoginButton();

            // Kiểm tra kết quả đăng nhập
            String errorMessage = loginPage.getErrorMessage();
            if (!errorMessage.isEmpty()) {
                System.out.println("Login failed with email: " + email);
                System.out.println("Error message: " + errorMessage);
                // Chụp ảnh màn hình khi có lỗi
                takeScreenshot(driver, "error_screenshot");
            } else if (homePage.isAvatarDisplayed() && homePage.isUsernameDisplayed()) {
                System.out.println("Login successful with email: " + email);
            } else {
                System.out.println("Login failed with email: " + email + " but no error message found.");
            }
        } catch (Exception e) {
            System.out.println("Error during test with email: " + email + " and password: " + password);
            e.printStackTrace();
            // Chụp ảnh màn hình khi có lỗi
            takeScreenshot(driver, "exception_screenshot");
        }
    }

    // Hàm chụp ảnh màn hình
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
