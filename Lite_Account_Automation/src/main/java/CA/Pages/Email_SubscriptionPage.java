package CA.Pages;

import CA.base.BaseClass;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class Email_SubscriptionPage extends BaseClass {

    SoftAssert sa = new SoftAssert();

    public Email_SubscriptionPage() {

        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath="//*[@id='gigya-loginID-130625356090677300']")
    WebElement username;
    @FindBy(xpath="//div[@class='gigya-composite-control gigya-composite-control-password']//input[@id='gigya-password-143048122469795340']")
    WebElement password;
    @FindBy(xpath="//*[@id='gigya-login-form']//input[@class='gigya-input-submit']")
    WebElement login_btn;
    @FindBy(xpath="//*[@data-testid='login']")
    WebElement login;
    @FindBy(xpath="//*[@id='gigya-loginID-130625356090677300']")
    WebElement email;
    @FindBy(xpath="//*[@id=\"gigya-password-143048122469795340\"]")
    WebElement pwd;
    @FindBy(xpath="//*[@id=\"gigya-login-form\"]//input[@class='gigya-input-submit']")
    WebElement login_link;
    @FindBy(xpath="//*[contains(text(),'Log Out')]")
    WebElement logout_btn;
    @FindBy(xpath="//*[@data-testid='login']")
    WebElement login_downarrow;
    @FindBy(xpath="//*[@id='gigya-textbox-firstname']")
    WebElement emailsubscription_firstname;
    @FindBy(xpath="//*[@id='gigya-textbox-lastname']")
    WebElement emailsubscription_lastname;
    @FindBy(xpath="//*[@id='gigya-textbox-email']")
    WebElement emailsubscription_email;
    @FindBy(xpath="//*[@value='Submit']")
    WebElement emailsubscription_submit;
    @FindBy(xpath="//*[@id='gigya-checkbox-subscription']")
    WebElement emailsubscription_checkbox;
    @FindBy(xpath="//*[@id='gigya-input-state']")
    WebElement emailsubscription_state;

    @FindBy(xpath="//*[@id='fav-team-wrapper']//span[contains(text(),'Australian Cricket Team')]")
    WebElement Australian_CricketTeam;
    @FindBy(xpath="//*[@id='fav-team-wrapper']//span[contains(text(),'Adelaide Strikers')]")
    WebElement Adelaide_StrikersTeam;
    @FindBy(xpath="//*[@id='fav-team-wrapper']//span[contains(text(),'Brisbane Heat')]")
    WebElement Brisbane_HeatTeam;
    @FindBy(xpath="//*[@id='fav-team-wrapper']//span[contains(text(),'Hobart Hurricanes')]")
    WebElement Hobart_HurricanesTeam;
    @FindBy(xpath="//*[@id='fav-team-wrapper']//span[contains(text(),'Melbourne Renegades')]")
    WebElement Melbourne_RenegadesTeam;
    @FindBy(xpath="//*[@id='fav-team-wrapper']//span[contains(text(),'Melbourne Stars')]")
    WebElement Melbourne_StarsTeam;
    @FindBy(xpath="//*[@id='fav-team-wrapper']//span[contains(text(),'Perth Scorchers')]")
    WebElement Perth_ScorchersTeam;
    @FindBy(xpath="//*[@id='fav-team-wrapper']//span[contains(text(),'Sydney Sixers')]")
    WebElement Sydney_SixersTeam;
    @FindBy(xpath="//*[@id='fav-team-wrapper']//span[contains(text(),'Sydney Thunder')]")
    WebElement Sydney_ThunderTeam;
    @FindBy(xpath="//*[@id='fav-team-wrapper']//span[contains(text(),'Other')]")
    WebElement OtherTeam;
    @FindBy(xpath="//*[@id='fav-team-wrapper']//span[contains(text(),'I don’t have a favourite team')]")
    WebElement I_dont_have_a_favouriteteam;

    @FindBy(xpath="//*[@id='id-subscribe-thank-you-screen']//*[@class='subscribe-thank-you']")
    WebElement thankyouscreen_text;
    @FindBy(xpath="//*[@id=\"gigya-subscribe-with-email-form\"]//span[@data-bound-to='profile.firstName']")
    WebElement firstname_errormsg;
    @FindBy(xpath="//*[@id=\"gigya-subscribe-with-email-form\"]//span[@data-bound-to='profile.lastName']")
    WebElement lastname_errormsg;
    @FindBy(xpath="//*[@id=\"gigya-subscribe-with-email-form\"]//span[@data-bound-to='email']")
    WebElement emailid_errormsg;

    @FindBy(xpath="//*[@id='exsisting-email-message']")
    WebElement existingemail_msg;


    Select name;
    public JavascriptExecutor js = ((JavascriptExecutor) driver);

    String emailsubscription_url = config.getProperty("testsiteurl") +"" + "email-subscription";

    public void verifyexistinguserlogin( String existun, String existpwd) throws InterruptedException {//String userid,

        driver.navigate().to(config.getProperty("testsiteurl"));
        Thread.sleep((Long.parseLong(config.getProperty("Thread5000"))));
        //  driver.navigate().refresh();
        username.click();
       /* userid= email+ "+" +timeStamp + "@gmail.com";
        System.out.println(userid);
        username.sendKeys(userid);*/
        username.sendKeys(existun);
        password.click();
        password.sendKeys(existpwd);
        js.executeScript("window.scrollBy(0,11000)");
        Thread.sleep((Long.parseLong(config.getProperty("Thread3000"))));
        login_btn.click();
        /*if(continuelogin_btn.isDisplayed()) {
            continuelogin_btn.click();
        }*/
        Thread.sleep((Long.parseLong(config.getProperty("Thread7000"))));

        String actualUrl="https://uat-identity-cdn.ca-digi.com/profile";
        Assert.assertEquals(driver.getCurrentUrl(), actualUrl);/**/
        // driver.navigate().to(config.getProperty("testsiteurl"));


    }
    public void verifyemailsubscriptionreg(String f_name, String l_name, String email) throws InterruptedException {

        driver.navigate().to(emailsubscription_url);
        Thread.sleep((Long.parseLong(config.getProperty("Thread3000"))));
        emailsubscription_firstname.click();
        emailsubscription_firstname.sendKeys(f_name);

        emailsubscription_lastname.click();
        emailsubscription_lastname.sendKeys(l_name);

        emailsubscription_email.click();
        emailsubscription_email.sendKeys(email);

        emailsubscription_state.click();
        name=new Select(emailsubscription_state);
        name.selectByIndex(1);

        js.executeScript("window.scrollBy(0,1000)");
        Thread.sleep((Long.parseLong(config.getProperty("Thread3000"))));

        Australian_CricketTeam.click();
        Adelaide_StrikersTeam.click();
        Sydney_SixersTeam.click();
        Sydney_ThunderTeam.click();

        emailsubscription_checkbox.click();
        emailsubscription_submit.click();
        Thread.sleep((Long.parseLong(config.getProperty("Thread5000"))));
        System.out.println("Success screen message : " + thankyouscreen_text.getText());
        String actualUrl="https://uat-identity-cdn.ca-digi.com/email-subscription";
        Assert.assertEquals(driver.getCurrentUrl(), actualUrl);

    }
    public void verifyerrormessageonemailsubscriptionreg() throws InterruptedException {

        driver.navigate().to(emailsubscription_url);
        Thread.sleep((Long.parseLong(config.getProperty("Thread3000"))));
        js.executeScript("window.scrollBy(0,10000)");
        js.executeScript("window.scrollBy(0,1000)");
        //js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        Thread.sleep((Long.parseLong(config.getProperty("Thread5000"))));
        emailsubscription_submit.click();
        sa.assertEquals(firstname_errormsg.getText(),"This field is required");
        sa.assertEquals(lastname_errormsg.getText(),"This field is required");
        sa.assertEquals(emailid_errormsg.getText(),"This field is required");
        sa.assertAll();

        String actualUrl="https://uat-identity-cdn.ca-digi.com/email-subscription";
        Assert.assertEquals(driver.getCurrentUrl(), actualUrl);
    }
    public void verifyemailsubscriptionlogin(String u_name, String u_pwd) throws InterruptedException {

        driver.navigate().to(emailsubscription_url);
        Thread.sleep((Long.parseLong(config.getProperty("Thread3000"))));
        login.click();
        Thread.sleep((Long.parseLong(config.getProperty("Thread5000"))));
        email.click();
        email.sendKeys(u_name);
        js.executeScript("window.scrollBy(0,1000)");
        Thread.sleep((Long.parseLong(config.getProperty("Thread3000"))));
        pwd.click();
        pwd.sendKeys(u_pwd);
        Thread.sleep((Long.parseLong(config.getProperty("Thread3000"))));
        login_link.click();
        Thread.sleep((Long.parseLong(config.getProperty("Thread5000"))));
        String actualUrl="https://uat-identity-cdn.ca-digi.com/email-subscription";
        Assert.assertEquals(driver.getCurrentUrl(), actualUrl);
        Thread.sleep((Long.parseLong(config.getProperty("Thread3000"))));
        System.out.println(existingemail_msg.getText());

        /*login_downarrow.click();
        logout_btn.click();
        Thread.sleep((Long.parseLong(config.getProperty("Thread5000"))));
        Assert.assertEquals(driver.getCurrentUrl(), actualUrl);*/

    }
}
