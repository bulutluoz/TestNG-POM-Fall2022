package tests.day14_dependsOnMethods_softAssert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class C04_SoftAssert extends TestBase {

    @Test
    public void test01() {
        // 1. “http://zero.webappsecurity.com/” Adresine gidin
        driver.get("http://zero.webappsecurity.com/");
        // 2. Sign in butonuna basin

        driver.findElement(By.id("signin_button")).click();
        // 3. Login kutusuna “username” yazin

        driver.findElement(By.id("user_login")).sendKeys("username");
        // 4. Password kutusuna “password” yazin
        driver.findElement(By.id("user_password")).sendKeys("password");
        // 5. Sign in tusuna basin
        driver.findElement(By.name("submit")).click();
        driver.navigate().back();
        // 6. Online banking menusu icinde Pay Bills sayfasina gidin
        driver.findElement(By.xpath("//strong[text()='Online Banking']")).click();
        driver.findElement(By.id("pay_bills_link")).click();
        // 7. “Purchase Foreign Currency” tusuna basin
        driver.findElement(By.xpath("//*[text()='Purchase Foreign Currency']")).click();
        // 8. “Currency” drop down menusunden Eurozone’u secin
        WebElement dropdownMenu= driver.findElement(By.id("pc_currency"));
        Select select=new Select(dropdownMenu);
        select.selectByValue("EUR");
        // 9. soft assert kullanarak "Eurozone (euro)" secildigini test edin

        SoftAssert softAssert=new SoftAssert();
        String expectedOption= "Eurozone (euro)";
        String actualOption= select.getFirstSelectedOption().getText();
        softAssert.assertEquals(actualOption,expectedOption,"Eurozone secilemedi");
        fotografCek("EurozoneResmi");
        // 10. soft assert kullanarak DropDown listesinin su secenekleri oldugunu test edin "Select One", "Australia (dollar)", "Canada (dollar)","Switzerland (franc)","China (yuan)","Denmark (krone)","Eurozone (euro)","Great Britain (pound)","Hong Kong (dollar)","Japan (yen)","Mexico (peso)","Norway (krone)","New Zealand (dollar)","Sweden (krona)","Singapore (dollar)","Thailand (baht)"

        String[] expectedKurlarArr={"Select One", "Australia (dollar)", "Canada (dollar)","Switzerland (franc)","China (yuan)","Denmark (krone)","Eurozone (euro)","Great Britain (pound)","Hong Kong (dollar)","Japan (yen)","Mexico (peso)","Norway (krone)","New Zealand (dollar)","Sweden (krona)","Singapore (dollar)","Thailand (baht)"};
        List<String> expectedKurlarList= Arrays.asList(expectedKurlarArr);

        List<WebElement> actualKurlarElementList=select.getOptions();

        List<String> actualKurlarListesi=new ArrayList<>();


        for (WebElement eachelement:actualKurlarElementList
             ) {
            actualKurlarListesi.add(eachelement.getText());
        }

        softAssert.assertEquals(actualKurlarListesi,expectedKurlarList,"Kurlar listesi farkli");

        softAssert.assertAll();
        bekle(5);
    }
}