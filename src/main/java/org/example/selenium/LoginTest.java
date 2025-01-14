package org.example.selenium;

//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//import java.time.Duration;
//
//public class LoginTest {
//    public static void main(String[] args) {
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--remote-allow-origins=*");
//        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
//
//        WebDriver driver = new ChromeDriver(options);
//
//        try {
//            driver.get("https://qlbh.ric.vn/Login");
//
//            // Test cases
//            testLogin(driver, "wrongemail@gmail.com", "sinh viên", "invalid");            // Wrong username
//            testLogin(driver, "sinhvien@gmail.com", "wrongpassword", "invalid");          // Wrong password
//            testLogin(driver, "wrongemail@gmail.com", "wrongpassword", "invalid");        // Both wrong
//            testLogin(driver, "", "sinh viên", "empty");                                  // Empty username
//            testLogin(driver, "sinhvien@gmail.com", "", "empty");                         // Empty password
//            testLogin(driver, "", "", "empty");                                           // Both fields empty
//            testLogin(driver, "sinhvien@gmail.com", "sinh viên", "https://qlbh.ric.vn/"); // Correct credentials
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            driver.quit();
//        }
//    }
//
//    private static void testLogin(WebDriver driver, String username, String password, String expected) {
//        try {
//            // Reload the login page
//            driver.get("https://qlbh.ric.vn/Login");
//
//            // Find and clear username and password fields
//            WebElement usernameField = driver.findElement(By.id("txtuid"));
//            WebElement passwordField = driver.findElement(By.id("txtpwd"));
//            usernameField.clear();
//            passwordField.clear();
//
//            // Input test credentials
//            usernameField.sendKeys(username);
//            passwordField.sendKeys(password);
//
//            // Click login button
//            WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"cmdlogin\"]"));
//            loginButton.click();
//
//            // Wait for potential navigation or error messages
//            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//            if (expected.equals("https://qlbh.ric.vn/")) {
//                wait.until(ExpectedConditions.urlToBe(expected));
//                String currentUrl = driver.getCurrentUrl();
//                if (currentUrl.equals(expected)) {
//                    System.out.println("Test Passed: Login successful with username '" + username + "' and password '" + password + "'");
//                } else {
//                    System.out.println("Test Failed: Expected redirection to homepage, but got: " + currentUrl);
//                }
//            } else if (expected.equals("invalid")) {
//                // Check for error message
//                WebElement errorMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginError"))); // Adjust locator
//                if (errorMsg.isDisplayed()) {
//                    System.out.println("Test Passed: Login failed as expected with username '" + username + "' and password '" + password + "'");
//                } else {
//                    System.out.println("Test Failed: No error message for invalid login credentials.");
//                }
//            } else if (expected.equals("empty")) {
//                // Check for validation message
//                WebElement validationMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("fieldError"))); // Adjust locator
//                if (validationMsg.isDisplayed()) {
//                    System.out.println("Test Passed: Validation error displayed for empty fields.");
//                } else {
//                    System.out.println("Test Failed: No validation message for empty fields.");
//                }
//            }
//        } catch (Exception e) {
//            System.out.println("Exception occurred during test with username '" + username + "' and password '" + password + "'");
//            e.printStackTrace();
//        }
//    }
//}

import org.example.ultils.DriverSetup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class LoginTest {
    public static void main(String[] args) {
        // Khởi tạo WebDriver
        WebDriver driver = DriverSetup.getDriver();

        try {
            // Mở trang Facebook
            driver.get("https://www.facebook.com");
            System.out.println("Mở trang Facebook thành công.");

            // Test Case 2: Tài khoản không tồn tại
            loginTest(driver, "nonexistent_email@gmail.com", "any_password");

            // Test Case 3: Sai mật khẩu
            loginTest(driver, "example@gmail.com", "wrong_password");

            // Test Case 4: Bỏ trống các trường
            loginTest(driver, "", "");

            // Test Case 5: Email không hợp lệ
            loginTest(driver, "invalidemail", "password123");

            // Test Case 1: Đăng nhập thành công
            loginTest(driver, "nguyenlongdang76@gmail.com", "nguyenlong");

        } finally {
            // Đóng trình duyệt
            driver.quit();
        }
    }

    // Hàm kiểm thử đăng nhập
    public static void loginTest(WebDriver driver, String email, String password) {
        try {
            // Tìm các trường nhập liệu
            WebElement emailField = driver.findElement(By.id("email"));
            WebElement passwordField = driver.findElement(By.id("pass"));
            WebElement loginButton = driver.findElement(By.name("login"));

            // Nhập thông tin
            emailField.clear();
            emailField.sendKeys(email);
            passwordField.clear();
            passwordField.sendKeys(password);

            // Nhấn nút đăng nhập
            loginButton.click();

            // Sử dụng WebDriverWait để kiểm tra URL
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.urlContains("facebook.com"));

            // Kiểm tra URL sau khi đăng nhập
            String currentUrl = driver.getCurrentUrl();

            if (currentUrl.contains("facebook.com/two_step_verification")) {
                System.out.println("Đăng nhập thành công nhưng cần xác minh hai bước với email: " + email);
            } else if (currentUrl.equals("https://www.facebook.com/")) {
                System.out.println("Đăng nhập thành công và chuyển đến trang chủ với email: " + email);
            } else {
                // Kiểm tra sự tồn tại của thông báo lỗi
                List<WebElement> errorMessages = driver.findElements(By.xpath("//div[contains(@class, '_9ay7')]"));
                if (!errorMessages.isEmpty()) {
                    System.out.println("Đăng nhập thất bại với email: " + email);
                    System.out.println("Thông báo lỗi: " + errorMessages.get(0).getText());
                } else {
                    System.out.println("Đăng nhập thất bại với email: " + email + " nhưng không tìm thấy thông báo lỗi.");
                }
            }
        } catch (Exception e) {
            System.out.println("Lỗi trong quá trình kiểm thử: " + e.getMessage());
        }
    }
}

