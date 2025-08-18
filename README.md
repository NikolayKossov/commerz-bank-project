# Test automation project for [Commerzbank Poland Careers](https://lodz.commerzbank.pl/)

## Table of contents

- [Technologies and tools](#technologist-technologies-and-tools)  
- [Implemented checks](#bookmark_tabs-implemented-checks)  
- [Running tests from the terminal](#rocket-running-tests-from-the-terminal)  
- [Running tests in Jenkins](#jenkins-running-tests-in-jenkins)  
- [Test results report in Allure Report](#allure-test-results-report-in-allure-report)  
- [Integration with Jira](#-integration-with-jira)  
- [Telegram notifications using a bot](#telegram-telegram-notifications-using-a-bot)  
- [Test running example in Selenoid](#-test-running-example-in-selenoid)  

## :technologist: Technologies and tools

<p align="center">
  <code><img height="40" title="IntelliJ IDEA" src="media/logo/Idea.svg"></code>
  <code><img height="40" title="Java" src="media/logo/Java.svg"></code>
  <code><img height="40" title="Selenoid" src="media/logo/Selenoid.svg"></code>
  <code><img height="40" title="Selenide" src="media/logo/Selenide.svg"></code>
  <code><img height="40" title="Gradle" src="media/logo/Gradle.svg"></code>
  <code><img height="40" title="JUnit5" src="media/logo/Junit5.svg"></code>
  <code><img height="40" title="GitHub" src="media/logo/GitHub.svg"></code>
  <code><img height="40" title="Allure Report" src="media/logo/Allure.svg"></code>
  <code><img height="40" title="Jenkins" src="media/logo/Jenkins_logo.svg"></code>
  <code><img height="40" title="Jira" src="media/logo/Jira.svg"></code>
  <code><img height="40" title="Telegram" src="media/logo/Telegram.svg"></code>
</p>

## :bookmark_tabs: Implemented checks

### 🧪 UI Tests (Commerzbank Careers)

- **Main page → Careers navigation**  
  Open `lodz.commerzbank.pl` → accept cookies → switch to **EN** → click **Apply** → switch to new tab → verify header **“Join Commerzbank Team”**.

- **Find vacancy by title**  
  Open Commerzbank Careers home → click vacancy **“Test Engineer Intern”** → assert vacancy header is **“Test Engineer Intern”**.

- **Open application form from vacancy page**  
  On the vacancy page click **“Apply To Position”** → navigate to the application form.

- **Fill and validate application form**  
  Open the **apply** page → fill **Name / Email / Phone** → add **Work experience** (company, title, summary, dates) → add **Education** (school, field, summary, dates) → fill **Summary & Cover Letter** → accept **GDPR**.  
  *(final submit intentionally disabled for demo safety)*

> All tests run on **Selenoid**; each run attaches **screenshots**, **page source**, and **video** to Allure Report.

## :rocket: Running tests from the terminal

- **Run locally**  
  ```bash
  gradle clean simple_test
  ```
- **Run remotely**
  ```bash
  gradle clean simple_test \
  -Dbrowser=${BROWSER} \
  -Dremote_url=${URL_LINK} \
  -Dbrowser_version=${BROWSER_VERSION} \
  -Dbrowser_size=${BROWSER_SIZE}
  ```

## <img height="25" src="media/logo/Jenkins_logo.svg"> Running tests in Jenkins

You can run tests directly from Jenkins, either on your own server or using the prepared project job.  

- **Example: Commerzbank Test Project**  
  Open [Jenkins Job](http://91.98.64.185:8080/job/commerz-bank-test-project/)  

1. Click **Build with Parameters**.  
2. Set the required parameters (browser, version, resolution, remote URL).  
3. Click **Build** to start the test run.  

<p align="left">
  <img src="media/jenkins1.png" alt="Jenkins build with parameters" width="1080"/>
</p>

After the build is completed, in the **Builds history** opposite the build number will appear the **Allure Report** icon.  
Clicking on it will open the generated HTML report page.

<p align="left">
  <img src="media/jenkins2.png" alt="Allure Report in Jenkins" width="1080"/>
</p>

## <img height="25" src="media/logo/Allure.svg"> Test results report in Allure Report
<p align="left">
  <img src="media/allure1.png" alt="Allure Report in Jenkins" width="1080"/>
</p>

## <img height="25" src="media/logo/Telegram.svg"> Telegram Notifications
After the build is completed, a special bot created in **Telegram** automatically sends a notification with summarized test results.

<p align="left">
  <img src="media/telegram1.png" alt="Telegram notification with test results" width="1080"/>
</p>

## <img height="25" src="media/logo/Selenoid.svg"> Selenoid Test Running Example
Below is an example of a test execution in **Selenoid**:

<p align="center">
  <img src="media/video/test1.gif" alt="Selenoid test run example" width="1080"/>
</p>
