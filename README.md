# Backend_Technology_Assessment

1- we can ru code by make mavan instal to download required dependances 
2- then run app as springBoot app
3- We can ru test by right click on CalculateDiscountServiceTest class and select run as JUnit Test
4- we can generate the coverage reports by install JaCoCo plugin in STS and right click on CalculateDiscountServiceTest classe and select Coverage As
5 project run on port 8080

to build project from command line: we can run command 
mvn clean then
mvn install


to generate unit test report we can add 
<plugin>
				<groupId>org.apache.maven.plugins</groupId>
				<artifactId>maven-surefire-report-plugin</artifactId>
				<version>2.18</version>
			</plugin>

   and run this comand:
   mvn surefire-report:report
