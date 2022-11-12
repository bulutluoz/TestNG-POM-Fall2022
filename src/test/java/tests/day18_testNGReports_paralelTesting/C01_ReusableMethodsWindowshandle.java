package tests.day18_testNGReports_paralelTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.ReusableMethods;

public class C01_ReusableMethodsWindowshandle {
    // Elemental Selenium: Receive a Free, Weekly Tip on Using Selenium like a Pro


    @Test
    public void test01(){
        // https://the-internet.herokuapp.com/iframe adresine gidin
        Driver.getDriver().get("https://the-internet.herokuapp.com/iframe");
        // elemental selenium linkini tiklayin
        Driver.getDriver().findElement(By.linkText("Elemental Selenium")).click();
        /*
          link tiklandiginda ikinci sayfa tab olarak acilacak
          bizim de driver'i 2.sayfaya gecirmemiz gerekiyor

         */

        ReusableMethods.switchToWindow("Elemental Selenium: Receive a Free, Weekly Tip on Using Selenium like a Pro");
        // Acilan sayfadaki en bastaki yazinin gorunur oldugunu
        WebElement baslikElementi= Driver.getDriver().findElement(By.tagName("h1"));
        Assert.assertTrue(baslikElementi.isDisplayed());
        // ve yazinin Elemental Selenium oldugunu test edin
        String expectedYazi="Elemental Selenium";
        String actualYazi= baslikElementi.getText();
        Assert.assertEquals(expectedYazi,actualYazi);
    }
}
