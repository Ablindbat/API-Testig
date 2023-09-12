## Rest-Booker Web site API Testing FrameWork

##### Framework running process

 * Run through Terminal.
  `mvn clean test`
 	 
  * Run through TestNg file
  `Right click on TestNG file -> Click on 'Run As' -> TestNG Suite`
  	
 * Batch Runner														
 ``Double click on batRunner.bat file``
 

 
##### Resource Files

- ** src/main/java ** :- All utility,reporting, POJO classes and reporting module are available.
- ** src/test/java ** :- All API testing module available.
- ** src/test/resources ** :- Log4j2 property file present here.
- ** Payload ** :- Payload property file location.
- ** EntentReport ** :- Extent report Generate here.
- ** logs ** :- log4j2 logs file generate here.

###### Other important files

- ** pom.xml ** :- All required dependencies and plugins are located here.
- **testng.xml ** :- Run the whole framework through TestNG Suite runner and achieve parallel execution from here.




