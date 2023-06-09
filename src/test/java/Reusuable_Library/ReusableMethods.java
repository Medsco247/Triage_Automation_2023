package Reusuable_Library;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public class ReusableMethods {
//create a return method to return the webdriver you are going to use on your test cases
    // static comand allows your method to be global
    public static WebDriver defineChromeDriver() {

        //set up your driver through web driver manager
        WebDriverManager.chromedriver().setup();

        //set your chrome options arguments for your web driver
        ChromeOptions options = new ChromeOptions();
        options.addArguments("incognito");

        //define the chrome driver that you will use for automation test
        //option variable must be passed inside chromeDriver in order for your driver to recognize those conditions
        WebDriver driver = new ChromeDriver(options);

        driver.manage().window().maximize();

        return driver;

    }//end of webdriver method

    //capture a text and return it using return method
    public static String captureTextMethod(WebDriver driver,String xpath,String elementName){
        WebDriverWait wait =  new WebDriverWait(driver,10);
        String result = null;
        try{
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            result = element.getText();
            System.out.println("Successfully captured a text from element " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to capture text from element " + elementName + ": " + e);
        }
        return  result;
    }//end of get text method

    //return method will execute your statements along with returning some conditions/value
    //example of return methods are only WebDriver method & getText action

    //void method will only perform the action but won't return anything
    //void actions are click, sendKeys, scrolling, submit, select, mouse hover, clear

    //click action is one of the type of void method
    public static void clickMethod(WebDriver driver,String xpath,String elementName){
        WebDriverWait wait =  new WebDriverWait(driver,10);
        try{
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath))).click();
            System.out.println("Successfully clicked on element " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to click on element " + elementName + ": " + e);
        }
    }//end of click method

    //submit mthod
    public static void submitMethod(WebDriver driver,String xpath,String elementName){
        WebDriverWait wait =  new WebDriverWait(driver,10);
        try{
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath))).submit();
            System.out.println("Successfully submitted element " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to submit element " + elementName + ": " + e);
        }
    }//end of click method

    //sendKeys action is one of the type of void method
    public static void sendKeysMethod(WebDriver driver,String xpath,String userValue,String elementName){
        WebDriverWait wait =  new WebDriverWait(driver,10);
        try{
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            element.clear();
            element.sendKeys(userValue);
            System.out.println("Successfully entered a value on element " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to enter a value on element " + elementName + ": " + e);
        }
    }//end of sendKeys method
    //click action is one of the type of void method
    public static void clickMethodByIndex(WebDriver driver,String xpath,int index,String elementName){
        WebDriverWait wait =  new WebDriverWait(driver,10);
        try{
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(xpath))).get(index).click();
            System.out.println("Successfully clicked on element " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to click on element " + elementName + ": " + e);
        }
    }//end of click method by index

    //sendKeys is one of the type of void method
    public static void sendKeysMethodByIndex(WebDriver driver,String xpath,String userValue,int index,String elementName){
        WebDriverWait wait =  new WebDriverWait(driver,10);
        try{
            WebElement element = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(xpath))).get(index);
            element.clear();
            element.sendKeys(userValue);
            System.out.println("Successfully entered a value on element " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to enter a value on element " + elementName + ": " + e);
        }
    }//end of sendKeysByIndex method

    //scrolling by element method
    public static void scrollingByElementMethod (WebDriver driver,String xpath,String userValue,String elementName){
        WebDriverWait wait =  new WebDriverWait(driver,10);
        try{
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("arguments[0].scrollIntoView(true)", element);
            System.out.println("Successfully scrolled by element " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to scroll by element " + elementName + ": " + e);
        }
    }//end of scrolling by element method

    //select by text method
    public static void selectByTextMethod (WebDriver driver,String xpath,String userValue,String elementName){
        WebDriverWait wait =  new WebDriverWait(driver,10);
        try{
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            Select elementByText = new Select(element);
            elementByText.selectByVisibleText(userValue);
            System.out.println("Successfully selected element by text " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to select element by text " + elementName + ": " + e);
        }
    }//end of select by text method

    //mouse hover method
    public static void mouseHoverMethod (WebDriver driver,String xpath,String userValue,String elementName){
        WebDriverWait wait =  new WebDriverWait(driver,10);
        try{
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            Actions mouseAction = new Actions(driver);
            mouseAction.moveToElement(element);
            mouseAction.perform();
            System.out.println("Successfully mouse hovered over element " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to mouse hover over text " + elementName + ": " + e);
        }
    }//end of select by text method

    //Boolean Statement method
    public static void verifyBooleanStatement(WebDriver driver, String xpath, boolean expectedValue, String elementName){
        //store the xpath in boolean statement
        WebDriverWait wait = new WebDriverWait(driver, 7);
        try {
            boolean elementState = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath))).isSelected();
            System.out.println("Value: " + elementState);
            if (elementState == expectedValue) {
                System.out.println("Passed: Checkbox is " + expectedValue);
            } else {
                System.out.println("Failed: Checkbox is " + elementState);
            }
        } catch (Exception e) {
            System.out.println("Unable to verify element  " + elementName + " " + e);
        }//end of exception

    }//end of verifyBooleanStatement


    public static void switchTabByIndexMethod (WebDriver driver,String userValue,String elementName){
        WebDriverWait wait =  new WebDriverWait(driver,10);
        try{
            ArrayList<String> tabs=new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(Integer.parseInt(userValue)));
            System.out.println("Successfully switched tabs by index " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to switch tabs by index" + elementName + ": " + e);
        }
    }//end of select by text method

    //  ArrayList<String> tabs=new ArrayList<>(driver.getWindowHandles());
    //        //switch to the new tab by index of 1
    //        driver.switchTo().window(tabs.get(1));

}//end of class
