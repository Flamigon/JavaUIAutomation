package ru.geekbrains.lesson;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class Test_1 {

    private static final String PAGE = "https://crm.geekbrains.space/user/login";
    private static final String LOGIN = "Applanatest";
    private static final String PASSWORD = "Student2020!";

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver;
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.get(PAGE);

        WebElement loginInput = driver.findElement(By.xpath("//*[@id=\"prependedInput\"]"));
        loginInput.sendKeys(LOGIN);

        WebElement passwordInput = driver.findElement(By.xpath("//*[@id=\"prependedInput2\"]"));
        passwordInput.sendKeys(PASSWORD);

        WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"_submit\"]"));
        loginButton.click();

        String TitleTest = driver.getTitle();
        if (!TitleTest.contains("Панель инструментов")) {
            System.out.println("Incorrect page or page title");
        }

        Actions hoverClick = new Actions(driver);
        WebElement dropMenu = driver.findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[3]"));
        hoverClick.moveToElement(dropMenu).moveToElement(driver.findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[3]/ul/li[4]/a"))).click().build().perform();

        String myProjects = driver.findElement(By.xpath("//*[@id=\"container\"]/div[1]/div/div/div[1]/div/div/div/div[1]/div/h1")).getText();
        if (!myProjects.contains("Мои проекты")) {
            System.out.println("Incorrect page or page title 2");
        }

        WebElement createButton = driver.findElement(By.xpath("//*[@id=\"container\"]/div[1]/div/div/div[2]/div/div/a"));
        createButton.click();

        String createProjects = driver.getTitle();
        if (!createProjects.contains("Создать проект")) {
            System.out.println("Incorrect page or page title");
        }

    }
}

