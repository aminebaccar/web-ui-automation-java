
# 🚀 Web UI Automation Project

## 📌 Overview  
This project automates tests on a website UI using **Selenium WebDriver**, **Cucumber (BDD)**, and **TestNG**.  
It supports **cross-browser testing, logging, and reporting** with **headless execution** in CI/CD.

---

## 📦 Tech Stack  
✅ **Java 17** – LTS version for stability.  
✅ **Maven 3.9.9** – Build automation tool.  
✅ **Selenium WebDriver 4.22.0** – Browser automation.  
✅ **Cucumber 7.11.1** – BDD framework for Gherkin syntax.  
✅ **TestNG 7.6.1** – Test execution and reporting.  
✅ **WebDriverManager 5.4.1** – Manages WebDriver binaries automatically.  
✅ **Log4j 2.20.0** – Logging framework for test execution tracking.  

---

## 📂 Project Structure  

```
web-ui-automation/
│── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── pages/                     # Page Object Models (POM)
│   │   │   │   ├── BasePage.java
│   │   │   │   ├── HomePage.java
│   │   │   │   ├── ProductsPage.java
│   │   │   │   ├── ProductDetailsPage.java
│   │   │   ├── utils/
│   │   │   │   ├── DriverManager.java
│   │   │   │   ├── ConfigReader.java
│   │   │   │   ├── Logger.java
│   ├── test/
│   │   ├── java/
│   │   │   ├── stepdefinitions/
│   │   │   │   ├── ProductSteps.java
│   │   │   │   ├── Hooks.java
│   │   │   ├── runners/
│   │   │   │   ├── TestRunner.java
│   │   ├── resources/
│   │   │   ├── features/
│   │   │   │   ├── product_tests.feature
│   │   │   ├── config.properties
│   │   │   ├── log4j2.xml
│   ├── pom.xml
│   ├── README.md
│   ├── test-output/                        # Stores reports & screenshots
```

---

## ⚙️ **Prerequisites**  

### 🔹 **1️⃣ Install Java 17**  
Ensure **Java 17** is installed:
```bash
java -version
```
If missing, download [Java 17](https://adoptium.net/) and install.

### 🔹 **2️⃣ Install Maven 3.9.9**
Check if **Maven** is installed:
```bash
mvn -version
```
If missing, install [Maven 3.9.9](https://maven.apache.org/download.cgi).

---

## 🏗 **Installation**
Clone the repository and build the project:
```bash
https://github.com/aminebaccar/web-ui-automation-java.git
cd web-ui-automation-java
mvn clean install
```

---

## **📝 Configurations**
Modify **`config.properties`** to set environment variables:

📂 **`src/test/resources/config.properties`**
```properties
base_url=<insert your base URL>
browser=chrome
headless=true
```
🔹 **`base_url`** → Set the target test website.  
🔹 **`browser`** → Supports `chrome`, `firefox`, `edge`.  
🔹 **`headless`** → Run tests without opening the browser UI (`true`/`false`).

---

## 🚀 **Running Tests**
### 🔹 **Run All Tests**
```bash
mvn test
```

### 🔹 **Run Tests in Headless Mode**
```bash
mvn test -Dheadless=true
```

### 🔹 **Run Tests on a Specific Browser**
```bash
mvn test -Dbrowser=firefox
```

### 🔹 **Run a Specific Feature File**
```bash
mvn test -Dcucumber.options="src/test/resources/features/Product.feature"
```

### 🔹 **Run Tests and Generate Reports**
```bash
mvn clean test verify
```

---

## 📊 **Test Reporting**
### 🔹 **1️⃣ Cucumber HTML Reports**
After execution, open:
```
target/cucumber-reports.html
```
### 🔹 **2️⃣ Cucumber JSON Reports (for CI/CD)**
```
target/cucumber.json
```

---

## 📜 **Logging Test Execution**
Logs are stored in:
```
logs/test-execution.log
```
To view real-time logs:
```bash
tail -f logs/test-execution.log  # Linux/Mac
type logs\test-execution.log     # Windows
```

---

## 🎯 **Key Features**
✅ **Cross-browser support** (Chrome, Firefox, Edge).  
✅ **Headless execution support** for faster CI/CD runs.  
✅ **Detailed HTML & JSON reports for test results**.  
✅ **Logs all test execution details** to `logs/test-execution.log`.  
✅ **Automatically closes the browser and captures screenshots on failures**.

---

## 📬 Contact
For any issues or suggestions, reach out via email.