package demo;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.logging.Level;
import io.github.bonigarcia.wdm.WebDriverManager;


public class TestCases {
    ChromeDriver driver;
    public TestCases()
    {
        System.out.println("Constructor: TestCases");

        WebDriverManager.chromedriver().timeout(30).setup();
        ChromeOptions options = new ChromeOptions();
        LoggingPreferences logs = new LoggingPreferences();

        // Set log level and type
        logs.enable(LogType.BROWSER, Level.ALL);
        logs.enable(LogType.DRIVER, Level.ALL);
        options.setCapability("goog:loggingPrefs", logs);

        // Set path for log file
        System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "chromedriver.log");

        driver = new ChromeDriver(options);

        // Set browser to maximize and wait
        driver.manage().window().maximize();
        // driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    public void endTest()
    {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    
    public  void testCase01(){
        System.out.println("Start Test case: testCase01");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        
        try{
        driver.get("https://www.google.com");
        String leetCodeUrl="https://leetcode.com/";
        if(!driver.getCurrentUrl().equals(leetCodeUrl)){
            driver.get(leetCodeUrl);
            System.out.println("User is navigated to correct url");
        }
       wait.until(ExpectedConditions.urlContains("leetcode"));
       System.out.println("The URL of the Leetcode homepage contains \"leetcode\"");
    }catch(Exception e){
        System.out.println("The URL of the Leetcode homepage does NOT contain \"leetcode\"");

    }
        System.out.println("end Test case: testCase01");
    }


public  void testCase02(){
    System.out.println("Start Test case: testCase02");
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
 
    try{
    WebElement questionsLink=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[text()='View Questions ']")));
    questionsLink.click();
    
    wait.until(ExpectedConditions.urlContains("problemset"));
    System.out.println("User is on the problem set page");

    for(int i=1; i<=5; i++){

        List<WebElement> questions=wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//a[@class='h-5 hover:text-blue-s dark:hover:text-dark-blue-s']")));
        WebElement question=questions.get(i);
        
        String questionText=question.getText();
        System.out.println(questionText);

        
        question.click();
        wait.until(ExpectedConditions.urlContains("description"));
        
        String questionTitle=driver.getTitle();
        System.out.println("Page title: " + questionTitle);
        
        if(questionTitle.contains(questionText)){
          
            System.out.println("The title of question is correct.");
        }else{
            
            System.out.println("The title of question is NOT correct.");
        }
        driver.navigate().back();
    }
    System.out.println("The correct details of the problems are obtained and verified.");
    
}catch(Exception e){
    System.out.println("Exception occurred while verifying  details of problem.");

}
    System.out.println("end Test case: testCase02");
}

public  void testCase03(){
    System.out.println("Start Test case: testCase03");
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
 
    try{
    
    WebElement question=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/problems/two-sum']")));
    question.click();
    wait.until(ExpectedConditions.urlContains("two-sum"));
    System.out.println("URL contains 'two-sum'.");
    
}catch(Exception e){
    System.out.println("Exception occurred while verifying  url.");

}
    System.out.println("end Test case: testCase03");
}

public  void testCase04(){
    System.out.println("Start Test case: testCase04");
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
 
    try{
    
    
    WebElement submissionsTab=wait.until(ExpectedConditions.elementToBeClickable(By.id("submissions_tab")));
  
    submissionsTab.click();
    System.out.println("submission tab clicked");


    WebElement submitButton=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Register or Sign In']")));
    String buttonText=submitButton.getText();

    if(buttonText.equals("Register or Sign In")){
        System.out.println("Button displays text as 'Register or Sign In'");
    }else{
        System.out.println("Button does NOT display text as 'Register or Sign In'");
    }
    
}catch(Exception e){
    System.out.println("Exception occurred while verifying  the button text."+e.getMessage());
    e.printStackTrace();

}
    System.out.println("end Test case: testCase04");
}
}

