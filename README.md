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

## Prerequisites
1. Install Java (version 8 or higher).
2. Install Maven for dependency management.
3. Add the following dependencies in your `pom.xml`:
   ```xml
   <dependencies>
       <dependency>
           <groupId>org.seleniumhq.selenium</groupId>
           <artifactId>selenium-java</artifactId>
           <version>4.5.0</version>
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

Để thêm hướng dẫn cách chạy kiểm thử vào file `README.md` của bạn, bạn có thể cập nhật phần **How to Run** với các bước chi tiết như sau:

---

## How to Run

### 1. Build Project
Trước tiên, bạn cần xây dựng dự án sử dụng Maven:

```bash
mvn clean install
```

Lệnh này sẽ tải về tất cả các phụ thuộc được khai báo trong `pom.xml` và biên dịch mã nguồn của bạn.

### 2. Chạy Kiểm Thử Từ IDE
- Mở dự án trong IDE yêu thích của bạn (ví dụ: IntelliJ IDEA hoặc Eclipse).
- Tìm và chạy lớp `LoginTest.java`. Bạn có thể chạy nó như một ứng dụng Java thông thường từ IDE.

### 3. Chạy Kiểm Thử Từ Dòng Lệnh
Nếu bạn muốn chạy kiểm thử từ dòng lệnh, bạn có thể sử dụng lệnh sau:

```bash
mvn exec:java -Dexec.mainClass="org.example.LoginTest"
```

Lệnh này sẽ chạy lớp `LoginTest` từ dòng lệnh.

### 4. Kiểm Tra Kết Quả
Sau khi chạy kiểm thử, các kết quả sẽ được hiển thị trong bảng điều khiển của IDE hoặc trong dòng lệnh. Nếu các bài kiểm thử thành công, bạn sẽ thấy thông báo xác nhận. Nếu có lỗi, các thông báo lỗi sẽ được ghi lại, và bạn có thể cần kiểm tra lại các bước cài đặt hoặc mã nguồn của mình.

### 5. Điều Chỉnh Thời Gian Chờ
Nếu các bài kiểm thử bị lỗi do vấn đề thời gian tải trang hoặc đồng bộ, bạn có thể điều chỉnh thời gian chờ trong lớp `DriverSetup.java` hoặc sử dụng `WebDriverWait` để đảm bảo rằng các phần tử đã sẵn sàng trước khi thực hiện các thao tác.

---

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

## Notes
- Ensure your WebDriver version matches your browser version.
- Adjust waiting times in the `WebDriverWait` if tests fail due to timing issues.

## Output
![image](https://github.com/user-attachments/assets/f8a722b6-05f6-412b-8f9e-5fcfe92e4ac6)


## Reference
[Click here](https://chatgpt.com/share/678539b2-1a00-8013-9e0d-4beecc549266)

## Contributions
Feel free to fork this repository and submit pull requests for enhancements or bug fixes. Ensure all test cases pass before submitting.

## License
This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

## Contact
For issues or questions, please reach out to [nguyenlong18022004@gmail.com].

