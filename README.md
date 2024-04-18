# Test Automation Project for [Bellintegrator](https://bellintegrator.ru/)

## **Contents:** ##

* Technologies and tools

* Examples of automated test cases

* Build in Jenkins

* Run from Terminal

* Allure report

* Integration with Allure TestOps

* Integration with Jira

* Telegram notification with bot

* Selenoid test execution video examples


-----
## <a name="Technologies and tools">**Technologies and tools:**</a>

<p align="center">
<a href="https://www.w3schools.com/java/"> <img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/java/java-original.svg" title="Java" alt="Java" width="40" height="40"/> </a> 
<a href="https://www.jetbrains.com/idea/"> <img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/intellij/intellij-original.svg" title="IntelliJ Idea" alt="IntelliJ Idea" width="40" height="40"/> </a> 
<a href="https://git-scm.com/"> <img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/git/git-original.svg" title="Git" alt="Git" width="40" height="40"/> </a> 
<a href="https://junit.org/junit5"> <img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/junit/junit-original.svg" title="JUnit5" alt="JUnit5" width="40" height="40"/> </a>
<a href="https://selenide.org"> <img src="images/logo/selenide.png" title="Selenide" alt="Selenide" width="40" height="40"/> </a>
<a href="https://gradle.org"> <img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/gradle/gradle-original.svg" title="Gradle" alt="Gradle" width="40" height="40"/> </a>
<a href="https://allurereport.org/"> <img src="images/logo/allure_report.svg" title="Allure report" alt="Allure report" width="40" height="40"/> </a>
<a href="https://qameta.io/"> <img src="images/logo/allure_testops.png" title="Allure TestOps" alt="Allure TestOps" width="40" height="40"/> </a>
<a href="https://www.jenkins.io"> <img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/jenkins/jenkins-original.svg" title="Jenkins" alt="Jenkins" width="40" height="40"/> </a>
<a href="https://www.atlassian.com/software/jira"> <img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/jira/jira-original.svg" title="Jira" alt="Jira" width="40" height="40"/> </a>
</p>


----
## **Examples of automated test cases:**
**Site search**
- ✅ Checking that the search is case-insensitive  
- ✅ An error is displayed when entering a search query < 3 characters  
- ✅ Checking a search with a complex search query with AND   
- ✅ Checking that the search text field can be cleared with the Backspace key   
- ✅ Checking exact search using quotation marks  

**Vacancy filters**
- ✅ Checking that vacancies are correctly filtered by specialty  
- ✅ Checking that vacancies are correctly filtered by location  
- ✅ Checking that vacancies are correctly filtered by hot option  
- ✅ Checking that vacancies are correctly filtered by combination of filters: specialty + location + enabled hot option + enabled remote option  


----
## Build in Jenkins ([link](https://jenkins.autotests.cloud/job/egorovaa_uitests_17/))
<p align="center">  
<a href="https://jenkins.autotests.cloud/job/egorovaa_uitests_17/"><img src="images/screen/jenkins_report.png" alt="Jenkins" width="950"/></a>  
</p>

### **Jenkins build options:**

- `BROWSER` (default browser - chrome)
- `BROWSER_VERSION` (default browser version - 100.0)
- `BROWSER_SIZE` (default screen size - 1920x1080)
- `COMMENT` (default - Bellintegrator ui test results)


----
## Run from Terminal
___
**Local launch**
```bash  
gradle clean test
```

**Remote launch via Jenkins**
```bash
clean test
-Dbrowser=${BROWSER}
-Dbrowser_size=${BROWSER_SIZE}
-Dbrowser_version=${BROWSER_VERSION}
-Dcomment=${COMMENT}
```


----
## Allure report ([link](https://jenkins.autotests.cloud/job/egorovaa_uitests_17/allure/))

**Main report page**
<p align="center">  
<a href="https://jenkins.autotests.cloud/job/egorovaa_uitests_17/allure/"><img src="images/screen/allure_report_main.png" alt="Allure Report main" width="950"/></a>  
</p>

**Test cases**
<p align="center">  
<a href="https://jenkins.autotests.cloud/job/egorovaa_uitests_17/allure/"><img src="images/screen/allure_report_cases.png" alt="Allure Report testcases" width="950"/></a>  
</p>


----
## Integration with Allure TestOps


----
## Integration with Jira ([link](https://jira.autotests.cloud/browse/HOMEWORK-1191))
<p align="center">  
<a href="https://jira.autotests.cloud/browse/HOMEWORK-1191"><img src="images/screen/jira_task.png" alt="Jira" width="950"/></a>  
</p>

----
## Telegram notification with bot


----
## Selenoid test execution video examples
