# EWD_AT_TestProject

Automation framework components:
1. Selenium: Perform elment recognition and action using Selenium APIs.
2. Cucumber: To structure and run est cases in BDD format.
3. Log4j: Its the logging API used.
4. Maven: Used for dependency management nad build projects.

**Maven installation**
Maven installation step for Windows/Mac
https://maven.apache.org/install.html

After Maven is installed run below command to check if its setup properly.
```
mvn -version
```

**Run Automation**
1. In Comman prompt/terminal navigate to the project root directory.
2. To run automation use below command:
```
mvn test
```
**Check run report**
In the project root directory report is created in the target folder.


**Project structure detail & description**

![image](https://user-images.githubusercontent.com/20679871/127774677-d1a2916a-3613-4887-9bee-ce8053017116.png)

**Packages description:**
*	baseUtils: Contains mandatory utilities like browser factory.
*	CommonUtils: Contains all commonly used utilities like date, wait.
*	elementRepository: Contains all element definitions (locators) and methods to access it.
*	Pages: Contains page class.
*	Runner: Contains test runner class file
*	stepDefenition: Contains supporting step definition functions for feature files.

**Resources description**
*	Feature: Contains feature files in Cucumber BDD format.
*	Driver: Contains webDriver for selenium.
*	testData: Contains test data files for expected result.
	
**Others:**
*	Target: Contains HTML report for test runs
*	Logs: Contains log files for the run

![image](https://user-images.githubusercontent.com/20679871/127774693-af4b45f5-2c55-46a1-aa05-042e512f5a19.png)

