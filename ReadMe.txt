TOPIC: GSD APP
--------------
 
 
CONTENTS OF THE FILE
--------------------
 
1. Team Members
2. Introduction
3. Description
4. Prerequisites
5. Frameworks & Tools Used
6. Ways to execute the project
7. Report
8. Screenshots
9. Excel File and Test file to store information of featured News
 
 
Team Members:
-------------
 
EmpID - 2303886          Name - Ayush Kumar Pandey
EmpID - 2304139          Name - Dheeraj Kumar Amanchi 
EmpID - 2303700          Name - Devansh
EmpID - 2304060          Name - Venkata Naga Sai Nivas Mangu
 
 
Introduction:
-------------
This automation project focuses on streamlining the user journey within the beCognizant portal, specifically 
targeting the login process, navigation to a oneCognizant page, searching for the General Service Desk (GSD) 
application, and validating its basic functions.
 
 
Description:
------------
 
1. Logging into the Cognizant Portal: 
   The script initiates by automating the login process to the Cognizant portal. It includes entering the user
   credentials, handling authentication, and ensuring a secure and successful login.
 
2. Navigating to a Cognizant Page:
   Following successful login, the script automates the navigation to a predefined Cognizant page. This step 
   ensures that the user is directed to the desired location within the portal for further actions.
 
3. Searching for the GSD App: 
   The automation script simulates the user's interaction with the portal's search functionality to locate the
   General Service Desk (GSD) application. This involves entering search queries, parsing search results, and 
   identifying the correct application.
 
4. Validating Basic Functions of the GSD App: 
   Once the GSD app is accessed, the script systematically validates its basic functions. This include:
 
    i)   Validating the user.
	ii)  Checking and counting the Ticket history of existing ticket.
	iii) Counting and storing all the queries and their tool tip.
	iv)  Validating the language change and the country change functionalities.

Prerequisites:
--------------
 
1. Access to Cognizant Portal Credentials.
2. Stable Internet Connection
 
 
Frameworks and tools used:
--------------------------
 
1. TestNG
2. Cucumber
3. Apache POI
4. Extent Reports
5. Page object mode
 
 
Ways to execute the project:
---------------------------
 
1. Run the testng.xml file using TestNG suite
2. Run the testRun class using Junit Test
3. Run the testRun class using the TestNG test
 
 
Report:
-------
 
1. Cucumber Report
2. Extent Report
 
 
Screenshots:
------------
 
To view screenshots for each scenario visit "src/test/resources/ScreenShots/".
 
 
Excel File:
-----------
 
Excel file is created to store all the queries and their tooltip.
the excel file can be visited from "src/test/resources/GSDAppData.xlsx".