package com.galaxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.util.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;
public class UITest
{
    
    public void startB()
    {
        WebDriverManager.chromedriver().setup();
        WebDriver d = new ChromeDriver();
        d.manage().window().maximize();
        d.get("https://opensource-demo.orangehrmlive.com/");
        Assert.isTrue(d.getTitle().contains("Orange"), "Not found");
        d.quit();
    }
}