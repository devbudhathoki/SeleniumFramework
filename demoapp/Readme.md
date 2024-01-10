# SeleniumFramework

## Framework Libraries and Tools

* **Testng**: *Testing framework uses listener class and setting testsuites and parallel test run*
* **RestAssured** : *Sending test log to ElasticSearch*
* **Apache POI**: *Reading data from Google spreadsheet*
* **Ownerns**: *Setting configuration properties for project*
* **ExtentReport**: *Report generation*
* **WebDriverManger**: *Manages webdriver instantiation*
* **Renovate**: *Dependency management*

## Configuration File
Following configurations can be set on [config.properties](src/test/resources/config.properties) file:

1. Setting web Url of web application for testing

   1. For Testing FinraLogin webpage
        
   2. For Testing OrangeHRMLive webpage

```
staging.url=https://ews.finra.org/auth/logon
```

```
dev.url=https://opensource-demo.orangehrmlive.com/index.php/auth/login
uat.url=https://uat-opensource-demo.orangehrmlive.com/index.php/auth/login
prod.url=https://prod-opensource-demo.orangehrmlive.com/index.php/auth/login
staging.url=https://opensource-demo.orangehrmlive.com/web/index.php/auth/login
```
2. Setting selenium grid url for remote run
```
seleniumgridurl=http://localhost:4444/wd/hub
```

3. Setting run mode to local or on docker selenium hub
```
run_mode=local
```

Note: For remote run using docker container, we should launch selenium hub using [docker-compose.yaml](docker-compose.yaml) file as follows:
It runs elasticsearch and kibana on docker as well.
```
docker-compose -f docker-compose.yaml up
```
Inorder to shutdown selenium hub, elasticsearch database and kibana docker container, run:
```
docker-compose -f docker-compose.yaml down
```
4. Setting retry mechanism for failed test cases using IRetryAnalyzer -->Yes or No
```
retry_mode=no
```

5. Taking a screenshot ot passed steps --> Yes or No
```
passedstepsscreenshots=no
```

6. Taking a screenshot ot failed steps --> Yes or No
```
failedstepsscreenshots=yes
```


7. Generating dynamic extent reports.  yes or no
```
overridereports=yes
```

8. Sending log to ElasticSearch
```
sendresulttoelk=no
```

9. Setting elasticsearch database url
```
elasticurl=http://localhost:9200/regression/results
```
# Configuring Testsuite

Testsuite can be configured using [testng.xml](testng.xml)
## Running test
Run testing from root directory where pom.xml file is present:
```
mvn clean test
```
