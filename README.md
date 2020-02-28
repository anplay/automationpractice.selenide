# UI Tests for Tech Tasks around Automationpractice site
### Tech stack:
- Java 8 ([Install docs](https://docs.oracle.com/javase/8/docs/technotes/guides/install/install_overview.html))
- Maven ([Install docs](https://maven.apache.org/install.html))
- Selenide (Will be installed automatically)
- TestNG (Will be installed automatically)
- Allure ([Install docs](https://docs.qameta.io/allure/#_how_to_proceed))
- Please see pom.xml file for more details on application modules

### Source code
Source code (git repo) is available at ```https://github.com/anplay/automationpractice.selenide```

### Assumptions
- You already familiar with: Git, Java, Terminal/Command line implementation of your Operation System
- Application code will be located in (Unix): ```~/Projects``` or in (Windows) ```C:\Projects```

Use this command to download code base
```bash
cd PROJECT_DIR
git clone git@github.com:anplay/automationpractice.selenide.git
```

Open terminal (Unix) or CMD prompt (MS Windows) and run following commands:
```bash
cd PROJECT_DIR
git pull
```

## Run tests

For MacOS platform:

To execute UI tests -
```
mvn clean test site -PRunUITestsProfile && allure serve allure-results

## Reports and logs
Allure report will be generated and opened in browser.
TestNg report will be generated in ```target/surefire-reports/UI Automation Suite``` directory.

