# Selenium Test Repository

This repository contains Selenium-based test scripts to automate and validate login functionality on the Facebook website. The tests cover various scenarios, including successful login, incorrect credentials, and two-step verification handling.

## Features
- Automates login functionality on Facebook.
- Covers multiple test cases:
  - Successful login.
  - Non-existent account login.
  - Incorrect password login.
  - Empty fields.
  - Invalid email format.
- Handles two-step verification scenarios.

## Prerequisites
1. Install Java (version 8 or higher).
2. Install Maven for dependency management.
3. Add the following dependencies in your `pom.xml`:
   ```xml
   <dependencies>
       <dependency>
           <groupId>org.seleniumhq.selenium</groupId>
           <artifactId>selenium-java</artifactId>
           <version>4.x.x</version>
       </dependency>
   </dependencies>
   ```
4. Install a WebDriver for your browser (e.g., ChromeDriver for Google Chrome).
5. Add the WebDriver to your system path.

## Directory Structure
```plaintext
selenium_test/
├── src/
│   ├── main/
│   │   └── java/
│   │       └── org/
│   │           └── example/
│   │               ├── utils/
│   │               │   └── DriverSetup.java
│   │               └── LoginTest.java
├── pom.xml
└── README.md
```

## Setup Instructions
1. Clone the repository:
   ```bash
   git clone https://github.com/minhlong1802/Selenium_test.git
   ```
2. Open the project in your favorite IDE (e.g., IntelliJ IDEA or Eclipse).
3. Add the WebDriver to your system path or specify its path in the `DriverSetup` class.
4. Update the test credentials in `LoginTest.java` with valid or invalid credentials for testing purposes.

## How to Run
1. Build the project using Maven:
   ```bash
   mvn clean install
   ```
2. Run the `LoginTest` class from your IDE or using the command line:
   ```bash
   mvn exec:java -Dexec.mainClass="org.example.LoginTest"
   ```

## Test Scenarios

### Test Case 1: Successful Login
- **Steps:** Provide valid email and password.
- **Expected Result:** Navigates to Facebook home page.

### Test Case 2: Non-existent Account
- **Steps:** Provide a non-existent email and any password.
- **Expected Result:** Displays an error message indicating invalid credentials.

### Test Case 3: Incorrect Password
- **Steps:** Provide a valid email with an incorrect password.
- **Expected Result:** Displays an error message indicating incorrect password.

### Test Case 4: Empty Fields
- **Steps:** Leave the email and password fields blank.
- **Expected Result:** Displays an error message indicating required fields.

### Test Case 5: Invalid Email Format
- **Steps:** Provide an invalid email format (e.g., `invalidemail`) and any password.
- **Expected Result:** Displays an error message indicating invalid email format.

### Handling Two-Step Verification
- **Steps:** Provide valid email and password for an account with two-step verification enabled.
- **Expected Result:** Navigates to `facebook.com/two_step_verification`.

## Notes
- Ensure your WebDriver version matches your browser version.
- Adjust waiting times in the `WebDriverWait` if tests fail due to timing issues.

## Output
![image](https://github.com/user-attachments/assets/e83b4a06-89ae-46d6-8e58-0f23d2ee3568)


## Reference
[Click here](https://chatgpt.com/share/678539b2-1a00-8013-9e0d-4beecc549266)

## Contributions
Feel free to fork this repository and submit pull requests for enhancements or bug fixes. Ensure all test cases pass before submitting.

## License
This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

## Contact
For issues or questions, please reach out to [your-email@example.com].

