package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class App {

    WebDriver driver;
    String BASE_URL = "https://twitter.com/";
    By singInLocator = By.cssSelector("a[class='css-4rbku5 css-18t94o4 css-1dbjc4n r-1niwhzg r-sdzlij r-1phboty r-rs99b7 r-1loqt21 r-a9p05 r-eu3ka r-5oul0u r-17w48nw r-2yi16 r-1qi8awa r-1ny4l3l r-ymttw5 r-o7ynqc r-6416eg r-lrvibr r-1ipicw7']");
    By informationLocator = By.cssSelector("input[name='text']");
    By nextButtonLocator = By.xpath("//div[@role='button'][2]");
    By passwordLocator = By.cssSelector("input[type='password']");
    By logInLocator = By.cssSelector("div[data-testid='LoginForm_Login_Button']");
    By tweetBoxLocator = By.cssSelector("div[role='textbox']");
    By tweetLocator = By.cssSelector("div[class='notranslate public-DraftEditor-content']");
    By tweetSubmitLocator = By.cssSelector("div[data-testid='tweetButtonInline']");


    public App(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(BASE_URL);
    }

    public void singIn(){
        waitFor(singInLocator);
        driver.findElement(singInLocator).click();
    }

    public void information(String username, String password){
        waitFor(informationLocator);
        driver.findElement(informationLocator).sendKeys(username);
        driver.findElement(nextButtonLocator).click();
        waitFor(passwordLocator);
        driver.findElement(passwordLocator).sendKeys(password);
        driver.findElement(logInLocator).click();

    }

    public void tweet(String message){
        waitFor(tweetBoxLocator);
        driver.findElement(tweetBoxLocator).click();
        driver.findElement(tweetLocator).sendKeys(message);
        driver.findElement(tweetSubmitLocator).click();
    }



















    private void waitFor(By locator){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }


}
