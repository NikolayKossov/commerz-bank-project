## Test automation project for [Commerzbank Poland Careers](https://lodz.commerzbank.pl/)

## Table of contents

- [Technologies and tools](#technologist-technologies-and-tools)  
- [Implemented checks](#bookmark-tabs-implemented-checks)  
- [Running tests from the terminal](#computer-running-tests-from-the-terminal)  
- [Running tests in Jenkins](#-running-tests-in-jenkins)  
- [Test results report in Allure Report](#-test-results-report-in-allure-report)  
- [Integration with Jira](#-integration-with-jira)  
- [Telegram notifications using a bot](#-telegram-notifications-using-a-bot)  
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

### :computer: UI Tests (Commerzbank Careers)

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

## :computer: Running tests from the terminal

- **Run locally**  
  ```bash
  gradle clean simple_test
    gradle clean simple_test \
      -Dbrowser=${BROWSER} \
      -Dremote_url=${URL_LINK} \
      -Dbrowser_version=${BROWSER_VERSION} \
      -Dbrowser_size=${BROWSER_SIZE}
    gradle clean simple_test \
  -Dbrowser=chrome \
  -Dremote_url=http://selenoid.company.com:4444/wd/hub \
  -Dbrowser_version=120.0 \
  -Dbrowser_size=1920x1080
