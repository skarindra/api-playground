# api-playground

#Pre-requisite Tools:
-    Apache Maven
-    JDK 8

#Project Structure:
-	pom.xml
-	src/main/java/com/bestbuy/testapi/constant : to list constant variable, like Base URL and API Key.
-	src/main/java/com/bestbuy/testapi/steps : to list all of the actions that will be performed.
-	src/main/resources/log4j.xml : logging properties
- src/test/java/com/bestbuy/testapi/TestRunner.java : Test runner
- src/test/java/com/bestbuy/testapi/stepdefinitions : consist of classes that can be used to map the story (scenario) in feature file with "steps" classes.
- src/test/resources/features : feature file

#Note:
-    I used Serenity BDD (Thucydides) combine with Cucumber and it will create good graphical report. You can find anything about Serenity here : http://www.thucydides.info/#/
-    As for the programming language, I used Java and Apache Maven as build tool.
-    To run the test : point to the project directory (where the pom.xml exist) - type "mvn clean install" and enter
-    To check the report : /target/site/serenity/index.html
