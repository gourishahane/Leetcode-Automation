## LeetCode Automation Project
## Description:
LeetCode is a leading online platform for coding enthusiasts and software engineers to hone their skills and prepare for technical interviews. This project automates essential functionalities of the LeetCode website using Selenium WebDriver and TestNG, ensuring the accuracy of navigation, problem retrieval, and the behavior of the submissions tab.
The project involves verifying URLs, extracting problem details, and testing restrictions on the submissions tab without authentication.

## Key Features
1. Automated Test Cases:
- Verify the LeetCode homepage URL.
- Retrieve and validate details of the first 5 problems on the problems page.
- Verify the URL of the "Two Sum" problem.
- Check the "Register or Sign In" prompt in the submissions tab.
2. Dynamic XPath Usage:
- Enhanced locator stability and adaptability.
3. No Dependency on ID Locators:
- Avoided id attributes to ensure consistency across sessions.
  
## Prerequisites
1. System Requirements
- Java 11 or above
- Maven or Gradle for dependency management
- ChromeDriver compatible with the installed Chrome version
2. Dependencies
- Ensure the following dependencies are included in the pom.xml or build.gradle file:
- Selenium WebDriver
- TestNG

## Installation and Setup
1. Clone the Repository
git clone https://github.com/username/leetcode-automation.git  
cd leetcode-automation  
2. Install Dependencies
Run the following command to install dependencies:
mvn install  
3. Set Up ChromeDriver
- Download and configure ChromeDriver as per your system's Chrome browser version.
- Update the ChromeDriver path in your project setup if required.

## Running the Tests
1. Configure TestNG XML

2. Execute Tests
Run the tests using Maven:
gradlew test

## Automated Test Cases
1. TestCase01: Verify the LeetCode Homepage URL
2. TestCase02: Verify Problem Set URL and Display First 5 Questions
3. TestCase03: Verify the Two Sum Problem
4. TestCase04: Ensure the Submissions Tab Displays "Register or Sign In"

## Project Challenges and Solutions
1. CAPTCHA Handling
- Challenge: CAPTCHA interrupts automation execution.
- Solution: Added sleep to allow manual resolution during execution.
2. Dynamic Content Locators
- Avoided using IDs in locators, which are dynamically generated and unreliable across sessions.
- Utilized dynamic XPath strategies for consistent element identification.

## Enhancements
1. Modular Code Structure
Organized test cases into modular components for better maintainability.

2. Detailed Logging
Included log statements to facilitate debugging and execution tracking.

3. Efficient Locators
Used robust locators that adapt to dynamic UI changes on the website.

## Skills Utilized
- Automation Tools: Selenium WebDriver
- Programming: Java
- Test Framework: TestNG
- Advanced Techniques: Dynamic XPath, efficient DOM traversal
- Debugging: Logs, breakpoints, error handling

## Contact Information
- Name: Gouri Shahane
- Email: gourishahane@gmail.com
- GitHub: github.com/username
- LinkedIn: linkedin.com/in/username
