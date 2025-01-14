package org.example.ultils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverSetup {
    public static WebDriver getDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        // Đặt đường dẫn đến chromedriver
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

        // Khởi tạo trình duyệt Chrome
        WebDriver driver = new ChromeDriver(options);

        // Thiết lập kích thước cửa sổ trình duyệt
        driver.manage().window().maximize();
        return driver;
    }
}
