# Test Automation Project for [Bell Integrator](https://bellintegrator.ru/)

## **Contents:** ##

* <a href="#tools">Technologies and tools</a>

* <a href="#cases">Examples of automated test cases</a>

* <a href="#jenkins">Build in Jenkins</a>

* <a href="#console">Run from Terminal</a>

* <a href="#allure">Allure report</a>

* <a href="#testops">Integration with Allure TestOps</a>

* <a href="#jira">Integration with Jira</a>

* <a href="#telegram">Telegram notification with bot</a>

* <a href="#video">Selenoid test execution video examples</a>


-----
<a id="tools"></a>
## <a name="Technologies and tools">**Technologies and tools:**</a>

<p align="center">
<a href="https://www.w3schools.com/java/"> <img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/java/java-original.svg" title="Java" alt="Java" width="40" height="40"/> </a> 
<a href="https://www.jetbrains.com/idea/"> <img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/intellij/intellij-original.svg" title="IntelliJ Idea" alt="IntelliJ Idea" width="40" height="40"/> </a> 
<a href="https://git-scm.com/"> <img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/git/git-original.svg" title="Git" alt="Git" width="40" height="40"/> </a> 
<a href="https://junit.org/junit5"> <img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/junit/junit-original.svg" title="JUnit5" alt="JUnit5" width="40" height="40"/> </a>
<a href="https://selenide.org"> <img src="images/logo/selenide.png" title="Selenide" alt="Selenide" width="40" height="40"/> </a>
<a href="https://gradle.org"> <img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/gradle/gradle-original.svg" title="Gradle" alt="Gradle" width="40" height="40"/> </a>
<a href="https://allurereport.org/"> <img src="images/logo/allure_report.png" title="Allure report" alt="Allure report" width="40" height="40"/> </a>
<a href="https://qameta.io/"> <img src="images/logo/allure_testops.png" title="Allure TestOps" alt="Allure TestOps" width="40" height="40"/> </a>
<a href="https://www.jenkins.io"> <img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/jenkins/jenkins-original.svg" title="Jenkins" alt="Jenkins" width="40" height="40"/> </a>
<a href="https://www.atlassian.com/software/jira"> <img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/jira/jira-original.svg" title="Jira" alt="Jira" width="40" height="40"/> </a>
</p>

- The UI autotests were written in **Java**.
- **Gradle** was used as a builder.
- **JUnit 5** and **Selenide** frameworks were used as test frameworks.
- For remote run, a job in **Jenkins** with **Allure report** generation and result send to **Telegram** via a bot has been implemented.
- Integration with **Allure TestOps** and **Jira** has been established.


----
<a id="cases"></a>
## **Examples of automated test cases:**
**Site search**
- ✅ Checking that the search is case-insensitive  
- ✅ An error is displayed when entering a search query of fewer than 3 characters  
- ✅ Checking a search with a complex search query using "AND"   
- ✅ Checking that the search text field can be cleared with the Backspace key   
- ✅ Checking exact search using quotation marks  

**Vacancy filters**
- ✅ Checking that vacancies are correctly filtered by specialty  
- ✅ Checking that vacancies are correctly filtered by location  
- ✅ Checking that vacancies are correctly filtered by "hot" option  
- ✅ Checking that vacancies are correctly filtered by a combination of filters: specialty + location + enabled "hot" option + enabled remote option  


----
<a id="jenkins"></a>
## Build in Jenkins ([link](https://jenkins.autotests.cloud/job/egorovaa_uitests_17/))
<p align="center">  
<a href="https://jenkins.autotests.cloud/job/egorovaa_uitests_17/"><img src="images/screen/jenkins_report.png" alt="Jenkins" width="950"/></a>  
</p>

### **Jenkins build options:**

- `BROWSER_SIZE` (default screen size - 1920x1080)
- `REMOTE_URL`
- `COMMENT` (default - Bellintegrator ui test results)


----
<a id="console"></a>
## Run from Terminal
___
**Local launch**
```bash  
gradle clean test
```

**Remote launch via Jenkins**
```bash
clean test
-DremoteUrl=${REMOTE_URL}
-DbrowserSize=${BROWSER_SIZE}
```


----
<a id="allure"></a>
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
<a id="testops"></a>
## Integration with Allure TestOps ([link](https://allure.autotests.cloud/project/4178/dashboards))
<p align="center">  
<a href="https://allure.autotests.cloud/project/4178/dashboards"><img src="images/screen/allure_testops_main.png" alt="Allure TestOps" width="950"/></a>  
</p>

**Manual test cases**
<p align="center">  
<a href="https://allure.autotests.cloud/project/4178/dashboards"><img src="images/screen/allure_testops_manual.png" alt="Allure TestOps" width="950"/></a>  
</p>

**Automation test cases**
<p align="center">  
<a href="https://allure.autotests.cloud/project/4178/dashboards"><img src="images/screen/allure_testops_auto.png" alt="Allure TestOps" width="950"/></a>  
</p>

----
<a id="jira"></a>
## Integration with Jira ([link](https://jira.autotests.cloud/browse/HOMEWORK-1191))
<p align="center">  
<a href="https://jira.autotests.cloud/browse/HOMEWORK-1191"><img src="images/screen/jira_task.png" alt="Jira" width="950"/></a>  
</p>

----
<a id="telegram"></a>
## Telegram notification with bot
<p align="center">  
<img src="images/screen/tg_bot_report.png" width="350"/> 
</p>


----
<a id="video"></a>
## Selenoid test execution video examples
<p align="center">
<img title="Selenoid Video" src="images/video/video_report.gif" width="550" height="350"  alt="video">   
</p>
