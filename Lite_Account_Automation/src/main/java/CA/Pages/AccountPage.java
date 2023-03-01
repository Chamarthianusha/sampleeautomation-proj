package CA.Pages;

import CA.base.BaseClass;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;

public class AccountPage extends BaseClass {

    SoftAssert sa = new SoftAssert();

    public AccountPage() {

        PageFactory.initElements(driver, this);
    }
    public JavascriptExecutor js = ((JavascriptExecutor) driver);

    @FindBy(xpath="//*[@id='gigya-loginID-130625356090677300']")
    WebElement username;
    @FindBy(xpath="//div[@class='gigya-composite-control gigya-composite-control-password']//input[@id='gigya-password-143048122469795340']")
    WebElement password;
    @FindBy(xpath="//*[@id='gigya-login-form']//input[@class='gigya-input-submit']")
    WebElement login_btn;

    @FindBy(xpath="//*[contains(text(),'Delete Account')]")
    WebElement deleteaccount_link;
    @FindBy(xpath="//input[@placeholder=\"Password *\"]")
    WebElement reauth_pwd;
    @FindBy(xpath="//*[@id=\"gigya-reauthentication-form\"]//input[@class='gigya-input-submit']")
    WebElement reauth_login;
    @FindBy(xpath="//*[@id=\"gigya-profile-form\"]//input[@class='gigya-input-submit']")
    WebElement delete_account_btn;
    @FindBy(xpath="//*[@id=\"gigya-profile-form\"]//a[@class='gigya-composite-control gigya-composite-control-link']")
    WebElement cancel_btn;

    @FindBy(xpath="//*[contains(text(),'Change Email')]")
    WebElement changeemail_link;
    @FindBy(xpath="//div[@class='gigya-composite-control gigya-composite-control-textbox']//input[@id='gigya-textbox-79836852443641820']")
    WebElement change_email_txt;
    @FindBy(xpath = "//input[@value='Get verification code']")
    WebElement getverificationcode;
    @FindBy(xpath = "//*[@id='cancel-link-email-success']")
    WebElement CancelOnchangeemail_btn;
    @FindBy(xpath = "//div[@class='gigya-composite-control gigya-composite-control-textbox w-192']//input[@aria-label='Code']")
    WebElement changeemailverificationcode;
    @FindBy(xpath = "//div[@id='email-container_content']//*[contains(text(),'Cancel')]")
    WebElement verifyemail_cancelbtn;
    @FindBy(xpath = "//input[@value='Done']")
    WebElement done_btn;
    @FindBy(xpath = "//*[contains(text(),'Return to Cricket ID Account')]")
    WebElement returnto_cricketidaccount;
    @FindBy(xpath="")
    WebElement loginagain_btn;

    @FindBy(xpath="")
    WebElement signout_link;

    @FindBy(xpath="//*[contains(text(),'Communication Preferences')]")
    WebElement communicationpreferences_link;
    @FindBy(xpath="//button[contains(text(),'Unsubscribe from all')]")
    WebElement Unsubscribe_btn;
    @FindBy(xpath="//*[contains(text(),'View All')]")
    WebElement viewall_link;

    @FindBy(xpath="//*[contains(text(),'Edit')]")
    WebElement edit_link;
    @FindBy(xpath="//*[@value='Save']")
    WebElement profileUpdate_davebtn;
    @FindBy(xpath="//*[@id='profile-cancel-link']")
    WebElement profileUpdate_cancelbtn;
    @FindBy(xpath="//*[contains(text(),'Change Password')]")
    WebElement changepwd_link;
    @FindBy(xpath = "//input[@id='gigya-password-password']")
    WebElement current_pwd;
    @FindBy(xpath = "//input[@id='gigya-password-newPassword']")
    WebElement new_pwd;
    @FindBy(xpath = "//input[@id='gigya-password-passwordRetype']")
    WebElement confirmnew_pwd;
    @FindBy(xpath = "//input[@value='Save']")
    WebElement save_btn;
    @FindBy(xpath = "//*[contains(text(),'Cancel')]")
    WebElement chanagepwdCancel_btn;

    String profile_url = config.getProperty("testsiteurl") +"" + "profile";
    String account_url = config.getProperty("testsiteurl") +"" + "account";
    String communicationpreferences_url = config.getProperty("testsiteurl") +"" + "communicationpreferences";
    String emailsubscription_url = config.getProperty("testsiteurl") +"" + "emailsubscription";
    public void verifyexistinguserlogin( String existun, String existpwd) throws InterruptedException {

        System.out.println("Profile page url : " + profile_url);
        driver.navigate().to(profile_url);
        Thread.sleep((Long.parseLong(config.getProperty("Thread5000"))));
        username.click();
        username.sendKeys(existun);
        password.click();
        password.sendKeys(existpwd);
        js.executeScript("window.scrollBy(0,11000)");
        Thread.sleep((Long.parseLong(config.getProperty("Thread3000"))));
        login_btn.click();
        Thread.sleep((Long.parseLong(config.getProperty("Thread7000"))));
        String actualUrl="https://uat-identity-cdn.ca-digi.com/profile";
        Assert.assertEquals(driver.getCurrentUrl(), actualUrl);

    }
    public void verifyAccountPage( String existun, String existpwd) throws InterruptedException {

        /*String url =driver.getCurrentUrl().replaceFirst("profile_url", "account_url");
        String currentURL  = driver.getCurrentUrl();
        String editURL = currentURL.replace("profile_url", "account_url");
        System.out.println("New URL : " + editURL);*/
        System.out.println("Account Page url : " + account_url);
        ((JavascriptExecutor)driver).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.navigate().to(account_url);
        Thread.sleep((Long.parseLong(config.getProperty("Thread5000"))));
        //driver.switchTo().window(tabs.get(0)).close();

        //js.executeScript("window.scrollBy(0,11000)");
        //Thread.sleep((Long.parseLong(config.getProperty("Thread3000"))));
        String actualUrl="https://uat-identity-cdn.ca-digi.com/account";
        Assert.assertEquals(driver.getCurrentUrl(), actualUrl);
    }
    public void verifyChangeEmail_link(String existun) throws InterruptedException {

        changeemail_link.click();
        Thread.sleep((Long.parseLong(config.getProperty("Thread3000"))));
        change_email_txt.click();
        change_email_txt.sendKeys(existun);

        getverificationcode.click();
        changeemailverificationcode.click();
        Thread.sleep((Long.parseLong(config.getProperty("Thread35000"))));
        done_btn.click();

        String actualurl="https://uat-identity-cdn.ca-digi.com/account-management?mode=change-email&apiKey=3_ZL4_AfSH8xImBgcV_GXxQUSv-a3v-u2WMonqnyHkcz_ActZfd00UTFBllrpLMUF_";
        Assert.assertEquals(driver.getCurrentUrl(), actualurl);
        returnto_cricketidaccount.click();

        // here made a changes after changeemail  we need to logout
        Thread.sleep((Long.parseLong(config.getProperty("Thread3000"))));
        //js.executeScript("window.scrollBy(0,1000)");
        //Thread.sleep((Long.parseLong(config.getProperty("Thread3000"))));
        /*signout_link.click();
        Thread.sleep((Long.parseLong(config.getProperty("Thread3000"))));
        loginagain_btn.click(); */

    }

    public void verifyCancelButtonOnChangeEmail() throws InterruptedException {

        changeemail_link.click();
        Thread.sleep((Long.parseLong(config.getProperty("Thread3000"))));
        CancelOnchangeemail_btn.click();
        Thread.sleep((Long.parseLong(config.getProperty("Thread5000"))));
        String actualurl="https://uat-identity-cdn.ca-digi.com/account";
        Assert.assertEquals(driver.getCurrentUrl(), actualurl);

    }

    public void verifySignout_link() throws InterruptedException {

        Thread.sleep((Long.parseLong(config.getProperty("Thread3000"))));
        signout_link.click();
        String actualurl="";
        Assert.assertEquals(driver.getCurrentUrl(), actualurl);

    }

    public void verifyViewall_btn() throws InterruptedException {

        viewall_link.click();
        Thread.sleep((Long.parseLong(config.getProperty("Thread5000"))));
        String actualurl="https://uat-identity-cdn.ca-digi.com/profile?apiKey=3_ZL4_AfSH8xImBgcV_GXxQUSv-a3v-u2WMonqnyHkcz_ActZfd00UTFBllrpLMUF_";
        Assert.assertEquals(driver.getCurrentUrl(), actualurl);

        driver.navigate().back();
        Thread.sleep((Long.parseLong(config.getProperty("Thread3000"))));

    }

    public void verifyEdit_btn() throws InterruptedException {

        edit_link.click();
        Thread.sleep((Long.parseLong(config.getProperty("Thread5000"))));
        String actualurl="https://uat-identity-cdn.ca-digi.com/profile?mode=edit-profile&apiKey=3_ZL4_AfSH8xImBgcV_GXxQUSv-a3v-u2WMonqnyHkcz_ActZfd00UTFBllrpLMUF_";
        Assert.assertEquals(driver.getCurrentUrl(), actualurl);
        js.executeScript("window.scrollBy(0,1100)");
        Thread.sleep((Long.parseLong(config.getProperty("Thread3000"))));
        profileUpdate_cancelbtn.click();
        String actualurl1="https://uat-identity-cdn.ca-digi.com/account?apiKey=3_ZL4_AfSH8xImBgcV_GXxQUSv-a3v-u2WMonqnyHkcz_ActZfd00UTFBllrpLMUF_";
        Assert.assertEquals(driver.getCurrentUrl(), actualurl1);

        driver.navigate().back();
        Thread.sleep((Long.parseLong(config.getProperty("Thread3000"))));
    }

    public void verifyCommunicationpreferences_link() throws InterruptedException {

        communicationpreferences_link.click();
        Thread.sleep((Long.parseLong(config.getProperty("Thread5000"))));
        js.executeScript("window.scrollBy(0,1100)");
        Thread.sleep((Long.parseLong(config.getProperty("Thread3000"))));
        Unsubscribe_btn.click();
        System.out.println("Clicked on Unsubscribe from all button");
        String actualurl="https://uat-identity-cdn.ca-digi.com/communication-preferences?apiKey=3_ZL4_AfSH8xImBgcV_GXxQUSv-a3v-u2WMonqnyHkcz_ActZfd00UTFBllrpLMUF_";
        Assert.assertEquals(driver.getCurrentUrl(), actualurl);

        driver.navigate().back();
        Thread.sleep((Long.parseLong(config.getProperty("Thread3000"))));
    }
    public void verifyChangePassword_link(String currentpwd, String newpwd, String retypenewpwd,String existun, String existpwd) throws InterruptedException {

        Thread.sleep((Long.parseLong(config.getProperty("Thread3000"))));
        js.executeScript("window.scrollBy(0,1000)");
        Thread.sleep((Long.parseLong(config.getProperty("Thread3000"))));
        changepwd_link.click();
        current_pwd.click();
        current_pwd.sendKeys(currentpwd);
        new_pwd.click();
        new_pwd.sendKeys(newpwd);
        confirmnew_pwd.click();
        confirmnew_pwd.sendKeys(retypenewpwd);
        save_btn.click();

        String actualurl="https://uat-identity-cdn.ca-digi.com/account-management?mode=change-password&apiKey=3_ZL4_AfSH8xImBgcV_GXxQUSv-a3v-u2WMonqnyHkcz_ActZfd00UTFBllrpLMUF_";
        Assert.assertEquals(driver.getCurrentUrl(), actualurl);
        returnto_cricketidaccount.click();

        Thread.sleep((Long.parseLong(config.getProperty("Thread5000"))));
        js.executeScript("window.scrollBy(0,1100)");
        Thread.sleep((Long.parseLong(config.getProperty("Thread3000"))));
        changepwd_link.click();
        current_pwd.click();
        current_pwd.sendKeys(newpwd);
        new_pwd.click();
        new_pwd.sendKeys(currentpwd);
        confirmnew_pwd.click();
        confirmnew_pwd.sendKeys(currentpwd);
        save_btn.click();

        //String actualurl="https://uat-identity-cdn.ca-digi.com/account-management?mode=change-password&apiKey=3_ZL4_AfSH8xImBgcV_GXxQUSv-a3v-u2WMonqnyHkcz_ActZfd00UTFBllrpLMUF_";
        Assert.assertEquals(driver.getCurrentUrl(), actualurl);
        returnto_cricketidaccount.click();

        /*Thread.sleep((Long.parseLong(config.getProperty("Thread3000"))));
        signout_link.click();
        Thread.sleep((Long.parseLong(config.getProperty("Thread3000"))));
        loginagain_btn.click();
        Thread.sleep((Long.parseLong(config.getProperty("Thread5000"))));

        verifyAccountPage(existun, existpwd);
        js.executeScript("window.scrollBy(0,1000)");
        Thread.sleep((Long.parseLong(config.getProperty("Thread3000"))));
        changepwd_link.click();
        current_pwd.click();
        current_pwd.sendKeys(currentpwd);
        new_pwd.click();
        new_pwd.sendKeys(newpwd);
        confirmnew_pwd.click();
        confirmnew_pwd.sendKeys(retypenewpwd);
        save_btn.click();

       *//* String actualurl="https://uat-identity-cdn.ca-digi.com/account-management?mode=change-password&apiKey=3_ZL4_AfSH8xImBgcV_GXxQUSv-a3v-u2WMonqnyHkcz_ActZfd00UTFBllrpLMUF_";
        Assert.assertEquals(driver.getCurrentUrl(), actualurl);*//*
        returnto_cricketidaccount.click();
*/

        /*js.executeScript("window.scrollBy(0,1000)");
        Thread.sleep((Long.parseLong(config.getProperty("Thread3000"))));
        signout_link.click();
        Thread.sleep((Long.parseLong(config.getProperty("Thread3000"))));
        loginagain_btn.click();*/

    }

    public void verifyCancelButtonOnChangePassword() throws InterruptedException {

        Thread.sleep((Long.parseLong(config.getProperty("Thread3000"))));
        js.executeScript("window.scrollBy(0,1100)");
        Thread.sleep((Long.parseLong(config.getProperty("Thread3000"))));
        changepwd_link.click();
        Thread.sleep((Long.parseLong(config.getProperty("Thread3000"))));
        chanagepwdCancel_btn.click();
        Thread.sleep((Long.parseLong(config.getProperty("Thread5000"))));
        String actualurl="https://uat-identity-cdn.ca-digi.com/account";
        Assert.assertEquals(driver.getCurrentUrl(), actualurl);

    }

    public void Verifyloginwithnewpassword(String existun1, String newpwd1, String currentpwd, String newpwd, String retypenewpwd , String existun, String existpwd) throws InterruptedException {

        driver.navigate().to(config.getProperty("testsiteurl"));
        Thread.sleep((Long.parseLong(config.getProperty("Thread5000"))));
        username.click();
        username.sendKeys(existun1);
        password.click();
        password.sendKeys(newpwd1);
        js.executeScript("window.scrollBy(0,400)");
        Thread.sleep((Long.parseLong(config.getProperty("Thread3000"))));
        login_btn.click();
        Thread.sleep((Long.parseLong(config.getProperty("Thread6000"))));
        js.executeScript("window.scrollBy(0,1000)");
        Thread.sleep((Long.parseLong(config.getProperty("Thread3000"))));
        changepwd_link.click();
        current_pwd.click();
        current_pwd.sendKeys(currentpwd);
        new_pwd.click();
        new_pwd.sendKeys(newpwd);
        confirmnew_pwd.click();
        confirmnew_pwd.sendKeys(retypenewpwd);
        save_btn.click();
        Thread.sleep((Long.parseLong(config.getProperty("Thread3000"))));
        js.executeScript("window.scrollBy(0,1000)");
        Thread.sleep((Long.parseLong(config.getProperty("Thread3000"))));
        signout_link.click();
        Thread.sleep((Long.parseLong(config.getProperty("Thread3000"))));
        loginagain_btn.click();
        Thread.sleep((Long.parseLong(config.getProperty("Thread6000"))));
        Assert.assertEquals(driver.getCurrentUrl(), "https://uat-identity-cdn.ca-digi.com/login?apiKey=3_ZL4_AfSH8xImBgcV_GXxQUSv-a3v-u2WMonqnyHkcz_ActZfd00UTFBllrpLMUF_");
        //driver.navigate().to(config.getProperty("testsiteurl"));
        //verifyexistinguserlogin(existun, existpwd);
    }

    public void verifyDeleteAccount_link(String existpwd) throws InterruptedException {

        Thread.sleep((Long.parseLong(config.getProperty("Thread3000"))));
        js.executeScript("window.scrollBy(0,1000)");
        Thread.sleep((Long.parseLong(config.getProperty("Thread3000"))));
        deleteaccount_link.click();
        Thread.sleep((Long.parseLong(config.getProperty("Thread3000"))));
        reauth_pwd.click();
        reauth_pwd.sendKeys(existpwd);
        reauth_login.click();
        js.executeScript("window.scrollBy(0,1000)");
        Thread.sleep((Long.parseLong(config.getProperty("Thread3000"))));
        delete_account_btn.click();
        Thread.sleep((Long.parseLong(config.getProperty("Thread3000"))));
        String actualUrl ="https://uat-identity-cdn.ca-digi.com/delete-account?apiKey=3_ZL4_AfSH8xImBgcV_GXxQUSv-a3v-u2WMonqnyHkcz_ActZfd00UTFBllrpLMUF_&returnUrl=https://id.cricket.com.au/";
        //"https://uat-identity-cdn.ca-digi.com/delete-account?apiKey=3_ZL4_AfSH8xImBgcV_GXxQUSv-a3v-u2WMonqnyHkcz_ActZfd00UTFBllrpLMUF_&returnUrl=https://uat-identity-cdn.ca-digi.com";
        Assert.assertEquals(driver.getCurrentUrl(), actualUrl);

    }
    public void VerifyCancelBtnOndeleteaccount(String existpwd) throws InterruptedException {


        Thread.sleep((Long.parseLong(config.getProperty("Thread5000"))));
        js.executeScript("window.scrollBy(0,1000)");
        Thread.sleep((Long.parseLong(config.getProperty("Thread3000"))));
        deleteaccount_link.click();
        Thread.sleep((Long.parseLong(config.getProperty("Thread3000"))));
        reauth_pwd.click();
        reauth_pwd.sendKeys(existpwd);
        reauth_login.click();
        Thread.sleep((Long.parseLong(config.getProperty("Thread6000"))));

        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        Thread.sleep((Long.parseLong(config.getProperty("Thread3000"))));
        cancel_btn.click();
        Thread.sleep((Long.parseLong(config.getProperty("Thread5000"))));
        String actualUrl ="https://uat-identity-cdn.ca-digi.com/profile?apiKey=3_ZL4_AfSH8xImBgcV_GXxQUSv-a3v-u2WMonqnyHkcz_ActZfd00UTFBllrpLMUF_&returnUrl=https://id.cricket.com.au/";
        Assert.assertEquals(driver.getCurrentUrl(), actualUrl);

        js.executeScript("window.scrollBy(0,1000)");
        Thread.sleep((Long.parseLong(config.getProperty("Thread3000"))));
        signout_link.click();
        Thread.sleep((Long.parseLong(config.getProperty("Thread3000"))));
        loginagain_btn.click();

    }

    public void verifyemailsubscriptionpage(){

    }
}
