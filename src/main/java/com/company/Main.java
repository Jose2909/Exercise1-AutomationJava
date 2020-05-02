package com.company;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.File;


public class Main {

    public static void main(String[] args) throws InterruptedException {
        File rootPath = new File("src/test/resources/drivers");
        File chromeFilePath = new File(rootPath, "chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", chromeFilePath.getPath());
        WebDriver myDriver = new ChromeDriver();
        myDriver.get("https://www.google.com.mx");



        myDriver.navigate().to("https://www.apple.com/mx/");
        myDriver.findElement(By.xpath("//nav[@id=\"ac-globalnav\"]//ul[2]//a[@href=\"/mx/mac/\"]")).click();

        String header = myDriver.findElement(By.xpath("//*[@id=\"main\"]/section[1]/div/div[2]/div/h2")).getText();
        Assert.assertEquals(header, "Velocidad para llevar a todas partes.","Is not the same string");
        Thread.sleep(1000);
        System.out.println(header);


        myDriver.findElement(By.xpath("//*[@id=\"ac-gn-link-search\"]")).click();
        WebElement search = myDriver.findElement(By.xpath("//*[@id=\"ac-gn-searchform-input\"]"));
        search.sendKeys("iPhone SE", Keys.ENTER);


        String title = myDriver.getTitle();
        Assert.assertEquals(title, "iPhone SE - Apple (MX)", "Title doesn´t match");
        myDriver.findElement(By.xpath("//*[@id=\"exploreCurated\"]/div[1]/div[2]/h2")).click();



        WebDriverWait wait = new WebDriverWait(myDriver, 3);
        WebElement buscaElemnt = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//nav[@id=\"ac-localnav\"]//div[@class=\"ac-ln-menu-tray\"]/ul//span[contains(text(),\"Descr\")]")));
        boolean descripcion = buscaElemnt.isDisplayed();
        boolean cambEna = buscaElemnt.isEnabled();
        Assert.assertTrue(descripcion, "Descripcion is Displayed");
        Assert.assertTrue(cambEna, "Descripcion is Enabled");


        WebDriverWait wait2 = new WebDriverWait(myDriver, 3);
        WebElement buscaElemnt2 = wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"ac-localnav\"]/div/div[2]/div[2]/div[1]/ul/li[2]/a")));
        boolean cambiar = buscaElemnt2.isDisplayed();
        boolean cambEn = buscaElemnt2.isEnabled();
        Assert.assertTrue(cambiar, "Por que cambiar is Displayed");
        Assert.assertTrue(cambEn, "Por que cambiar is Enabled");


        WebDriverWait wait3 = new WebDriverWait(myDriver, 3);
        WebElement buscaElemnt3 = wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"ac-localnav\"]/div/div[2]/div[2]/div[1]/ul/li[3]/a")));
        boolean specs =buscaElemnt3.isDisplayed();
        boolean specEn =buscaElemnt3.isEnabled();
        Assert.assertTrue(specs, "Especificaciones is Displayed");
        Assert.assertTrue(specEn, "Especificaciones is Enabled");


        WebDriverWait wait4 = new WebDriverWait(myDriver, 3);
        WebElement buscaElemnt4 = wait4.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"ac-localnav\"]/div/div[2]/div[2]/div[2]/div[2]/a")));
        boolean buy = buscaElemnt4.isDisplayed();
        boolean buyEn = buscaElemnt4.isEnabled();
        Assert.assertTrue(buy, "Comprar is Displayed");
        Assert.assertTrue(buyEn, "Comprar is Enabled");


        Thread.sleep(5000);
        myDriver.close();
    }
}


