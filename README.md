# Selenium Test Project

This repository contains a Selenium-based automation project for testing the login functionality of a website. The project is written in Java and uses ChromeDriver to interact with Google Chrome.

## Prerequisites

Ensure you have the following installed before running the project:

1. **Java Development Kit (JDK)**: Version 8 or later.
2. **Maven**: For dependency management.
3. **Google Chrome**: Ensure the browser is installed and updated.
4. **ChromeDriver**: Ensure it matches your Chrome browser version. Download from [ChromeDriver](https://chromedriver.chromium.org/downloads).
5. **IDE**: IntelliJ IDEA, Eclipse, or any preferred Java IDE.

## Project Setup

1. Clone the repository:
   ```bash
   git clone <repository-url>
   cd Selenium_test
   ```

2. Add the Selenium dependency to your `pom.xml` file:
   ```xml
   <dependency>
       <groupId>org.seleniumhq.selenium</groupId>
       <artifactId>selenium-java</artifactId>
       <version>4.7.2</version>
   </dependency>
   ```

3. Download ChromeDriver:
   - Download the appropriate version from [ChromeDriver](https://chromedriver.chromium.org/downloads).
   - Place the `chromedriver.exe` file in a known location (e.g., `D:\chromedriver-win64\`).

4. Update the path to ChromeDriver in the code:
   ```java
   System.setProperty("webdriver.chrome.driver", "path\to\chromedriver.exe");
   ```

## Running the Tests

1. Open the project in your preferred IDE.
2. Run the `LoginTest.java` file to execute the test cases.

### Test Cases

The following test cases are implemented:

1. **Valid Login**: Ensures successful login with correct credentials.
2. **Invalid Username**: Verifies the system's response to an incorrect username.
3. **Invalid Password**: Checks the behavior with a wrong password.
4. **Invalid Username and Password**: Tests the scenario where both username and password are incorrect.
5. **Empty Username**: Ensures validation messages appear for an empty username field.
6. **Empty Password**: Ensures validation messages appear for an empty password field.
7. **Both Fields Empty**: Verifies validation messages when both fields are left empty.

### Expected Results

- **Successful Login**: User is redirected to `https://qlbh.ric.vn/`.
- **Failed Login**: Error messages appear on invalid inputs or empty fields.

## Sample Code

```java
WebElement usernameField = driver.findElement(By.id("txtuid"));
usernameField.sendKeys("valid_username");

WebElement passwordField = driver.findElement(By.id("txtpwd"));
passwordField.sendKeys("svalid_password");

WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"cmdlogin\"]"));
loginButton.click();
```

## Troubleshooting

1. **WebDriverException**: Ensure ChromeDriver version matches your Chrome browser.
2. **TimeoutException**: Check your internet connection or increase the `WebDriverWait` timeout.
3. **ElementNotFoundException**: Verify the `id` or `xpath` of the web elements.

## Reference
[Click here](https://chatgpt.com/share/67855269-e838-8000-8889-b73e42e8c793)

## License

This project is licensed under the MIT License. See the LICENSE file for details.

## Contribution

Feel free to open issues or submit pull requests to improve this project.
