package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigReader;
import utilities.Driver;

public class MyCoursedemyPage {
    public MyCoursedemyPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//a[text()='Log in']")
    public WebElement loginLinki;

    @FindBy(xpath = "//input[@id='login-email']")
    public WebElement emailKutusu;

    @FindBy(xpath = "//input[@id='login-password']")
    public WebElement passwordKutusu;

    @FindBy(xpath = "//button[text()='Login']")
    public WebElement loginButonu;

    @FindBy(linkText = "My courses")
    public WebElement coursesLinki;

    @FindBy(linkText = "Instructor")
    public WebElement instructorLinki;

    @FindBy(xpath = "//*[text()='Course manager']")
    public WebElement courseManagerLinki;

    @FindBy(xpath = "//*[text()='Add new course']")
    public WebElement addNewCourseButonu;

    @FindBy(xpath = "//*[@id='course_title']")
    public WebElement courseTitleKutusu;

    @FindBy(xpath = "(//*[text()='Select a category'])[2]")
    public WebElement categoryMenusu;

    @FindBy(xpath = "(//*[text()='Web Design for Web Developers'])[2]")
    public WebElement categorySecimi;

    @FindBy(xpath = "//*[@class='mdi mdi-arrow-right-bold']")
    public WebElement ilkNextButonu;

    @FindBy(xpath = "//*[@placeholder='Enter course course price']")
    public WebElement coursePrice;

    @FindBy(xpath = "//*[@name='discounted_price']")
    public WebElement discountKutusu;

    @FindBy(xpath = "(//*[@placeholder='Write a keyword and then press enter button'])[2]")
    public WebElement metaKeywordsKutusu;

    @FindBy(xpath = "//*[text()='Submit']")
    public WebElement submitButonu;

    @FindBy(xpath = "//*[text()=' Back to course list']")
    public WebElement backToCourseListButonu;

    public void loginMethodu(){
        loginLinki.click();
        emailKutusu.sendKeys(ConfigReader.getProperty("myGecerliEmail"));
        passwordKutusu.sendKeys(ConfigReader.getProperty("myGecerliPassword"));
        loginButonu.click();
    }
}
