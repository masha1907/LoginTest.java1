package org.example;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.*;

public class LoginTest {
    private WebDriver driver;
    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();


    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void Login() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/login");
        driver.manage().window().setSize(new Dimension(1280, 796));
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.cssSelector(".fa")).click();
        Thread.sleep(3000);
        assertEquals(driver.findElement(By.cssSelector(".icon-2x")).getText(), "Logout");

    }
}
