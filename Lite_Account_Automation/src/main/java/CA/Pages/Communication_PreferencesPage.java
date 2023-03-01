package CA.Pages;

import CA.base.BaseClass;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Communication_PreferencesPage extends BaseClass {

    SoftAssert sa = new SoftAssert();

    public Communication_PreferencesPage() {

        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath="//*[@id='recaptcha-anchor']/div[1]")
    WebElement recaptcha;
    @FindBy(xpath="/html/body/div[2]/main/div/div[2]/div/form/div[4]/label/a")
    //"//a[@id='login_registration_gtm']")
    WebElement signuplink;
    @FindBy(xpath="//*[@id='gigya-textbox-17380892084082752']")
    //"//input[@data-display-name='First Name']")
    WebElement firstname;
    @FindBy(xpath="//*[@id='gigya-textbox-55143518532496990']")
    // "//input[@data-display-name='Last Name']")
    WebElement lastname;
    @FindBy(xpath="//div[@class='gigya-composite-control gigya-composite-control-textbox gigya-composite-control-loginID']//*[@id='gigya-loginID-14119022676662832']")
    WebElement emailid;

    @FindBy(xpath="//div[@class='gigya-composite-control gigya-composite-control-textbox']//input[@id='gigya-textbox-157483191469630700']")
    WebElement yearofbirth;

    @FindBy(xpath="//div[@class='gigya-composite-control gigya-composite-control-dropdown']//*[@id='gigya-dropdown-101146705214511980']")
    WebElement country;

    @FindBy(xpath="//*[@id='gigya-register-form']//input[@data-display-name='Postcode']")
    WebElement postcode;
    @FindBy(xpath="//*[@id='gigya-register-form']//span[contains(text(),'Australian Cricket Team')]")
    WebElement AustralianCricketTeam;

    @FindBy(xpath="//*[@id='gigya-register-form']//span[contains(text(),'Adelaide Strikers')]")
    WebElement AdelaideStrikersTeam;

    @FindBy(xpath="//*[@id='gigya-register-form']//span[contains(text(),'Sydney Sixers')]")
    WebElement SydneySixersTeam;

    @FindBy(xpath="//*[@id=\"gigya-register-form\"]//span[contains(text(),'I have read and agree to the terms of the Australian Cricket ')]")
    WebElement privacypolicy;
    @FindBy(xpath="//*[@id=\"gigya-register-form\"]//input[@class='gigya-input-submit']")
    //"//div[@class='gigya-composite-control gigya-composite-control-submit btn-width']//input[@class='gigya-input-submit']")
    WebElement createcricketId;
    @FindBy(xpath="/html/body/div[2]/main/div/div[2]/div/form/div[2]/div/input")
    //"//*[@id='gigya-textbox-code']")
    WebElement verificationcode;
    @FindBy(xpath="//*[@id='gigya-otp-update-form']//input[@class='gigya-input-submit']")
    WebElement continue_btn;
    @FindBy(xpath="//*[@id='gigya-loginID-130625356090677300']")
    WebElement username;
    @FindBy(xpath="//div[@class='gigya-composite-control gigya-composite-control-password']//input[@id='gigya-password-143048122469795340']")
    WebElement password;
    @FindBy(xpath="//*[@id='gigya-login-form']//input[@class='gigya-input-submit']")
    WebElement login_btn;
    @FindBy(xpath="//*[@id=\"gigya-register-form\"]//span[@data-bound-to=\"profile.firstName\"]")
    WebElement firstname_errormsg;
    @FindBy(xpath="//*[@id=\"gigya-register-form\"]//span[@data-bound-to=\"profile.lastName\"]")
    WebElement lastname_errormsg;
    @FindBy(xpath="//*[@id=\"gigya-register-form\"]//span[@data-bound-to=\"email\"]")
    WebElement emailid_errormsg;
    @FindBy(xpath="//*[@id=\"gigya-register-form\"]//span[@data-bound-to=\"password\"]")
    WebElement password_errormsg;
    @FindBy(xpath="//*[@id=\"gigya-register-form\"]//span[@data-bound-to=\"profile.birthYear\"]")
    WebElement yearofbirth_errormsg;
    @FindBy(xpath="//*[@id='fav_team_err']")
    WebElement favteam_errormsg;
    @FindBy(xpath="//*[@id=\"gigya-register-form\"]//span[@data-bound-to=\"profile.zip\"]")
    WebElement postcode_errormsg;
    @FindBy(xpath="//*[@data-testid='login']")
    WebElement login;
    @FindBy(xpath="//*[@id='gigya-loginID-130625356090677300']")
    WebElement email;
    @FindBy(xpath="//*[@id=\"gigya-password-143048122469795340\"]")
    WebElement pwd;
    @FindBy(xpath="//*[@id=\"gigya-login-form\"]//input[@class='gigya-input-submit']")
    WebElement login_link;
    @FindBy(xpath="//*[@id='email-input']")
    WebElement email_text;
    @FindBy(xpath="//*[contains(text(),'Send me the link')]")
    WebElement sendme_link;
    @FindBy(xpath="//*[@id='gigya-password-143048122469795340']")
    WebElement pwd_text;
    @FindBy(xpath="//*[@class='form-container-centered']")
    WebElement liteaccount_text;
    @FindBy(xpath="//*[contains(text(),'Log Out')]")
    WebElement logout_btn;
    @FindBy(xpath="//*[@data-testid='login']")
    WebElement login_downarrow;
    @FindBy(xpath="//*[@class='CommunicationPreferencesScreen__UnsubButton-sc-1gzw8v0-6 bShQPN']")
    WebElement unsubscribeall_btn;

    @FindBy(xpath="//*[@id=\"__next\"]/main/div[2]/div[2]/div[1]/img")
    WebElement mysubscriptions_arrow;
    @FindBy(xpath="//*[@id=\"__next\"]/main/div[2]/div[3]/div[1]/img")
          //  "//p[contains(text(),'Other Subscriptions')]")
    WebElement othersubscriptions_arrow;

    @FindBy(xpath="//div[@class='gigya-container gigya-visible-when gigya-container-enabled']//h2[contains(text(),'Cricket Australia')]")
    WebElement Cricket_Australia_subscription;
    @FindBy(xpath="//div[@class='gigya-container gigya-visible-when gigya-container-enabled']//h2[contains(text(),'Melbourne Renegades')]")
    WebElement Melbourne_Renegades_subscription;
    @FindBy(xpath="//div[@class='gigya-container gigya-visible-when gigya-container-enabled']//h2[contains(text(),'Melbourne Stars')]")
    WebElement Melbourne_Stars_subscription;
    @FindBy(xpath="//div[@class='gigya-container gigya-visible-when gigya-container-enabled']//h2[contains(text(),'Brisbane Heat')]")
    WebElement Brisbane_Heat_subscription;
    @FindBy(xpath="//div[@class='gigya-container gigya-visible-when gigya-container-enabled']//h2[contains(text(),'Hobart Hurricanes')]")
    WebElement Hobart_Hurricanes_subscription;
    @FindBy(xpath="//div[@class='gigya-container gigya-visible-when gigya-container-enabled']//h2[contains(text(),'Perth Scorchers')]")
    WebElement Perth_Scorchers_subscription;
    @FindBy(xpath="//div[@class='gigya-container gigya-visible-when gigya-container-enabled']//h2[contains(text(),'Sydney Sixers')]")
    WebElement Sydney_Sixers_subscription;
    @FindBy(xpath="//div[@class='gigya-container gigya-visible-when gigya-container-enabled']//h2[contains(text(),'Sydney Thunder')]")
    WebElement Sydney_Thunder_subscription;

    @FindBy(xpath="//div[@class='gigya-container gigya-visible-when gigya-container-enabled']")
    WebElement Subscription;

    @FindBy(xpath="/html/body/div[2]/main/div[2]/div[3]/div[2]/div/div[2]/div/form/div[1]/div[2]/div[3]/div/label/span")
            //*[@id='gigya-subscribe-with-email-form']/div[1]/div[2]/div[3]/div/label/span")
    WebElement Cricket_Australia_generalmarketing;

    @FindBy(xpath="/html/body/div[2]/main/div[2]/div[3]/div[2]/div/div[2]/div/form/div[1]/div[6]/div[2]/div/label/span")
    WebElement Melbourne_Renegades_tickets;

    @FindBy(xpath="/html/body/div[2]/main/div[2]/div[2]/div[2]/div/div[2]/div/form/div[1]/div[2]/div[3]/div/label/span")
    WebElement mySubscriptionCricket_Australia_generalmarketing;

    @FindBy(xpath="/html/body/div[2]/main/div[2]/div[2]/div[2]/div/div[2]/div/form/div[1]/div[6]/div[2]/div/label/span")
    WebElement mySubscriptionMelbourne_Renegades_tickets;

    @FindBy(xpath="//div[@id='Id-lite-current-subscriptions']")
    WebElement currentSubscription;

    @FindBy(xpath="//div[@id='Id-lite-other-subscriptions']")
    WebElement otherSubscription;

    public JavascriptExecutor js = ((JavascriptExecutor) driver);
    Select name;
    String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
    String email1;
    String  userid;
    String communicationpreferences_url = config.getProperty("testsiteurl") +"" + "communication-preferences";
    public void verifyallmandatoryfields(String fname,String lname,String email,String pwd,String dob,
                                         String cname1 ,String cname2,String code ) throws InterruptedException {

        Thread.sleep((Long.parseLong(config.getProperty("Thread3000"))));
        //  signuplink.click();
        // config.getProperty(sleep);
        firstname.click();
        firstname.sendKeys(fname);

        lastname.click();
        lastname.sendKeys(lname);

        emailid.click();
        userid= email1+ "+" +timeStamp + "@gmail.com";
        System.out.println( "Registered EmailId is :" + userid);
        emailid.sendKeys(userid);


        js.executeScript("window.scrollBy(0,400)");
        Thread.sleep((Long.parseLong(config.getProperty("Thread3000"))));

        password.click();
        password.sendKeys(pwd);

        yearofbirth.click();
        yearofbirth.sendKeys(dob);

        country.click();
        name=new Select(country);
        name.selectByValue(cname1);
        country.click();
        name.selectByValue(cname2);
        Thread.sleep((Long.parseLong(config.getProperty("Thread3000"))));

        js.executeScript("window.scrollBy(0,400)");
        Thread.sleep((Long.parseLong(config.getProperty("Thread3000"))));
       /* postcode.click();
        postcode.sendKeys(code);*/

        String cname= name.getFirstSelectedOption().getText();
        System.out.println(cname);
        if(cname.equalsIgnoreCase("Australia"))
        {
            postcode.click();
            postcode.sendKeys(code);
        }

        AustralianCricketTeam.click();
        AdelaideStrikersTeam.click();

        js.executeScript("window.scrollBy(0,400)");
        Thread.sleep((Long.parseLong(config.getProperty("Thread3000"))));

        SydneySixersTeam.click();
        privacypolicy.click();

       /*createcricketId.click();
       verificationcode.click();
       Thread.sleep((Long.parseLong(config.getProperty("Thread25000"))));
       continue_btn.click();*/
    }

    public void verifyregistrationUsingsite(String fname, String lname, String email, String pwd, String dob,
                                            String cname1 , String cname2, String code, String userid, String pwd1,String existun, String existpwd) throws InterruptedException {

        Thread.sleep((Long.parseLong(config.getProperty("Thread3000"))));
        if(config.getProperty("NewOrExist").equalsIgnoreCase("new")){
            Thread.sleep((Long.parseLong(config.getProperty("Thread3000"))));
            js.executeScript("window.scrollBy(0,11000)");
            Thread.sleep((Long.parseLong(config.getProperty("Thread3000"))));
            signuplink.click();
            Thread.sleep((Long.parseLong(config.getProperty("Thread3000"))));
            verifyallmandatoryfields(fname,lname,email,pwd,dob,cname1 ,cname2,code);
            js.executeScript("window.scrollBy(0,11000)");
            Thread.sleep((Long.parseLong(config.getProperty("Thread3000"))));
            createcricketId.click();
            System.out.println("clicked on cricketId");

            sa.assertEquals(firstname.getAttribute("aria-invalid"),"false",firstname_errormsg.getText());
            //   sa.assertEquals(firstname_errormsg.getText(),"This field is required");
            sa.assertEquals(lastname.getAttribute("aria-invalid"),"false",lastname_errormsg.getText());

            if(emailid_errormsg.getText().equalsIgnoreCase("Email already exists")) {
                sa.assertEquals(emailid.getAttribute("aria-invalid"), "false","Email already exists");
            }
            else if(emailid_errormsg.getText().equalsIgnoreCase("E-mail address is invalid.")){
                sa.assertEquals(emailid.getAttribute("aria-invalid"), "false","E-mail address is invalid.");
            }
            else if(emailid_errormsg.getText().equalsIgnoreCase("This field is required")){
                sa.assertEquals(emailid_errormsg.getAttribute("aria-invalid"),"false", "This field is required");
            }

            if(password_errormsg.getText().equalsIgnoreCase("Password does not meet complexity requirements")){
                sa.assertEquals(this.password.getAttribute("aria-invalid"),"false","Password does not meet complexity requirements");
            }
            else if (password_errormsg.getText().equalsIgnoreCase("This field is required")) {
                sa.assertEquals(this.password.getAttribute("aria-invalid"),"false", "This field is required");
            }

            if(yearofbirth_errormsg.getText().equalsIgnoreCase("Invalid Year of Birth")){
                sa.assertEquals(yearofbirth.getAttribute("aria-invalid"), "false","Invalid Year of Birth");
            }
            else if (yearofbirth_errormsg.getText().equalsIgnoreCase("This field is required")){
                sa.assertEquals(yearofbirth.getAttribute("aria-invalid"),"false", "This field is required");
            }

            if(postcode_errormsg.getText().equalsIgnoreCase("Invalid Postcode")){
                sa.assertEquals(postcode.getAttribute("aria-invalid"), "false","Invalid Postcode");
            }
            else if(postcode_errormsg.getText().equalsIgnoreCase("This field is required")) {
                sa.assertEquals(postcode.getAttribute("aria-invalid"), "false","This field is required");
            }

            if(favteam_errormsg.getText().equalsIgnoreCase("Please select at least one option")){
                sa.assertEquals(favteam_errormsg.getText(), "Please select at least one option");
            }

            sa.assertAll();

            verificationcode.click();
            //continue_btn.click();
            Thread.sleep((Long.parseLong(config.getProperty("Thread30000"))));
            System.out.println("navigated to verify email page");
            continue_btn.click();
            System.out.println("clicked on continuebtn");/**/
         /* if(continuelogin_btn.isDisplayed()) {
                continuelogin_btn.click();
           } */
            Thread.sleep((Long.parseLong(config.getProperty("Thread5000"))));
            Assert.assertEquals(driver.getCurrentUrl(), "https://uat-identity-cdn.ca-digi.com/profile");
            Thread.sleep((Long.parseLong(config.getProperty("Thread5000"))));
            driver.navigate().to(config.getProperty("testsiteurl"));
            //sa.assertAll();
            Thread.sleep((Long.parseLong(config.getProperty("Thread5000"))));
            username.click();
            userid= email+ "+" +timeStamp + "@gmail.com";
            System.out.println(userid);

            username.sendKeys(userid); // updated the string value
            //username.sendKeys(email1);
            password.click();
            password.sendKeys(pwd1);

            js.executeScript("window.scrollBy(0,400)");
            Thread.sleep((Long.parseLong(config.getProperty("Thread3000"))));

            login_btn.click();
           /*if(continuelogin_btn.isDisplayed()) {
               continuelogin_btn.click();
           }*/
            Thread.sleep((Long.parseLong(config.getProperty("Thread5000"))));
            String actualUrl="https://uat-identity-cdn.ca-digi.com/profile";
            Assert.assertEquals(driver.getCurrentUrl(), actualUrl);

        }
        else {
            Thread.sleep((Long.parseLong(config.getProperty("Thread5000"))));
            //verifyexistinguserlogin(existun,existpwd);
            verifyexistinguserlogin(email,existpwd);

        }
        sa.assertAll();
    }

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

    public void verifycommunicationpreferenceslogin(String u_name, String u_pwd) throws InterruptedException {

        driver.navigate().to(communicationpreferences_url);
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
        String actualUrl="https://uat-identity-cdn.ca-digi.com/communication-preferences";
        Assert.assertEquals(driver.getCurrentUrl(), actualUrl);
        login_downarrow.click();
        logout_btn.click();
        Thread.sleep((Long.parseLong(config.getProperty("Thread5000"))));
        Assert.assertEquals(driver.getCurrentUrl(), actualUrl);

    }

    public void verifycommunicationpreferencesforCricketId(String u_name, String u_pwd) throws InterruptedException {

        driver.navigate().to(communicationpreferences_url);
        Thread.sleep((Long.parseLong(config.getProperty("Thread3000"))));
        js.executeScript("window.scrollBy(0,1000)");
        Thread.sleep((Long.parseLong(config.getProperty("Thread3000"))));
        email_text.click();
        email_text.sendKeys(u_name);
        js.executeScript("window.scrollBy(0,700)");
        Thread.sleep((Long.parseLong(config.getProperty("Thread3000"))));
        sendme_link.click();
        Thread.sleep((Long.parseLong(config.getProperty("Thread3000"))));
        System.out.println("Full account email address message : " + liteaccount_text.getText());
        Thread.sleep((Long.parseLong(config.getProperty("Thread10000"))));
        js.executeScript("window.scrollBy(0,1100)");
        Thread.sleep((Long.parseLong(config.getProperty("Thread5000"))));
        pwd_text.click();
        pwd_text.sendKeys(u_pwd);
        Thread.sleep((Long.parseLong(config.getProperty("Thread3000"))));
        login_link.click();
        Thread.sleep((Long.parseLong(config.getProperty("Thread5000"))));
        String actualUrl="https://uat-identity-cdn.ca-digi.com/communication-preferences";
        Assert.assertEquals(driver.getCurrentUrl(), actualUrl);

        System.out.println(" -------------------------------  " );
        System.out.println("My Subscription are : " + currentSubscription.getText());
        js.executeScript("arguments[0].scrollIntoView();", othersubscriptions_arrow);
        Thread.sleep((Long.parseLong(config.getProperty("Thread3000"))));
        othersubscriptions_arrow.click();
        System.out.println(" -------------------------------  " );
        System.out.println("Other Subscription are : " + otherSubscription.getText());

        /*unsubscribeall_btn.click();
        System.out.println("User clicked on Unsubscribe from all button");

        js.executeScript("window.scrollBy(-2000,0)");
        Thread.sleep((Long.parseLong(config.getProperty("Thread5000"))));
        login_downarrow.click();
        logout_btn.click();
        Thread.sleep((Long.parseLong(config.getProperty("Thread5000"))));
        Assert.assertEquals(driver.getCurrentUrl(), actualUrl);*/

    }

    public void verifycommunicationpreferencesforliteaccount(String liteu_name) throws InterruptedException {

        //driver.navigate().to(config.getProperty("testsiteurl"));
        driver.navigate().to(communicationpreferences_url);
        Thread.sleep((Long.parseLong(config.getProperty("Thread3000"))));
        js.executeScript("window.scrollBy(0,1000)");
        Thread.sleep((Long.parseLong(config.getProperty("Thread3000"))));
        email_text.click();
        email_text.sendKeys(liteu_name);
        sendme_link.click();
        Thread.sleep((Long.parseLong(config.getProperty("Thread5000"))));
        String actualUrl="https://uat-identity-cdn.ca-digi.com/communication-preferences";
        Assert.assertEquals(driver.getCurrentUrl(), actualUrl);
        System.out.println("Lite account email address message : " + liteaccount_text.getText());

    }

    public void verifycommunicationpreferencesforNoaccount(String invalid_name) throws InterruptedException {

        driver.navigate().to(communicationpreferences_url);
        //driver.navigate().to(config.getProperty("testsiteurl"));
        Thread.sleep((Long.parseLong(config.getProperty("Thread3000"))));
        js.executeScript("window.scrollBy(0,1000)");
        Thread.sleep((Long.parseLong(config.getProperty("Thread3000"))));
        email_text.click();
        email_text.sendKeys(invalid_name);
        sendme_link.click();
        Thread.sleep((Long.parseLong(config.getProperty("Thread5000"))));
        String actualUrl="https://uat-identity-cdn.ca-digi.com/communication-preferences";
        Assert.assertEquals(driver.getCurrentUrl(), actualUrl);
        System.out.println("No account email address message : " + liteaccount_text.getText());

    }

    public void verifyUnsubscribeallbtn(String u_name, String u_pwd) throws InterruptedException {

        driver.navigate().to(communicationpreferences_url);
        Thread.sleep((Long.parseLong(config.getProperty("Thread5000"))));
        js.executeScript("window.scrollBy(0,20000)");
        //js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        Thread.sleep((Long.parseLong(config.getProperty("Thread5000"))));
        unsubscribeall_btn.click();
        System.out.println("User clicked on Unsubscribe from all button");
        Thread.sleep((Long.parseLong(config.getProperty("Thread5000"))));
        js.executeScript("window.scrollBy(0,900)");
        Thread.sleep((Long.parseLong(config.getProperty("Thread5000"))));

        System.out.println(" -------------------------------  " );
        System.out.println("My Subscription are : " + currentSubscription.getText());
        js.executeScript("arguments[0].scrollIntoView();", othersubscriptions_arrow);
        Thread.sleep((Long.parseLong(config.getProperty("Thread3000"))));
        othersubscriptions_arrow.click();
        System.out.println(" -------------------------------  " );
        System.out.println("Other Subscription are : " + otherSubscription.getText());

       /* login_downarrow.click();
        logout_btn.click();
        Thread.sleep((Long.parseLong(config.getProperty("Thread5000"))));
        Assert.assertEquals(driver.getCurrentUrl(), actualUrl);*/

    }

    public void verifysubscribes_by_checking_box() throws InterruptedException {

        driver.navigate().to(communicationpreferences_url);
        Thread.sleep((Long.parseLong(config.getProperty("Thread5000"))));

        js.executeScript("arguments[0].scrollIntoView();", othersubscriptions_arrow);
        Thread.sleep((Long.parseLong(config.getProperty("Thread3000"))));
        othersubscriptions_arrow.click();
        Thread.sleep((Long.parseLong(config.getProperty("Thread3000"))));
         /*js.executeScript("window.scrollBy(0,21500)");
        Thread.sleep((Long.parseLong(config.getProperty("Thread5000"))));
       mysubscriptions_arrow.click();
        Thread.sleep((Long.parseLong(config.getProperty("Thread5000"))));
        js.executeScript("window.scrollBy(-700,0)");
        Thread.sleep((Long.parseLong(config.getProperty("Thread3000"))));
        othersubscriptions_arrow.click();
        Thread.sleep((Long.parseLong(config.getProperty("Thread3000"))));
        Actions a = new Actions(driver);
        a.moveToElement(Cricket_Australia_generalmarketing).click().build().perform();*/
        Cricket_Australia_generalmarketing.click();
        Thread.sleep((Long.parseLong(config.getProperty("Thread3000"))));
        Melbourne_Renegades_tickets.click();
        Thread.sleep((Long.parseLong(config.getProperty("Thread5000"))));
        js.executeScript("window.scrollBy(0,-500)");
        Thread.sleep((Long.parseLong(config.getProperty("Thread5000"))));

        System.out.println(" -------------------------------  " );
        System.out.println("My Subscription are : " + currentSubscription.getText());
        js.executeScript("arguments[0].scrollIntoView();", othersubscriptions_arrow);
        Thread.sleep((Long.parseLong(config.getProperty("Thread3000"))));
        //othersubscriptions_arrow.click();
        System.out.println(" -------------------------------  " );
        System.out.println("Other Subscription are : " + otherSubscription.getText());

    }

    public void verifyUnsubscribes_by_unchecking_box() throws InterruptedException {

        driver.navigate().to(communicationpreferences_url);
        Thread.sleep((Long.parseLong(config.getProperty("Thread5000"))));
        js.executeScript("arguments[0].scrollIntoView();", mysubscriptions_arrow);
        Thread.sleep((Long.parseLong(config.getProperty("Thread3000"))));
        mySubscriptionCricket_Australia_generalmarketing.click();
        Thread.sleep((Long.parseLong(config.getProperty("Thread3000"))));

        System.out.println(" -------------------------------  " );
        System.out.println("My Subscription are : " + currentSubscription.getText());
        js.executeScript("arguments[0].scrollIntoView();", othersubscriptions_arrow);
        Thread.sleep((Long.parseLong(config.getProperty("Thread3000"))));
        othersubscriptions_arrow.click();
        System.out.println(" -------------------------------  " );
        System.out.println("Other Subscription are : " + otherSubscription.getText());

    }



}



    /*public void verifyOthersubscriptionscategory() throws InterruptedException {

        // othersubscriptions_arrow.click();
        Thread.sleep((Long.parseLong(config.getProperty("Thread5000"))));

        if (Melbourne_Stars_subscription.isDisplayed()) {

            System.out.println("MelbourneStars subscription are in other subscriptions category : " + Melbourne_Stars_subscription.getText());
        } else
            System.out.println("MelbourneStars subscription are not in other subscriptions category : ");

        Thread.sleep((Long.parseLong(config.getProperty("Thread3000"))));
        if (Melbourne_Renegades_subscription.isDisplayed()) {

            System.out.println("Melbourne_Renegades subscription are in other subscriptions category : " + Melbourne_Renegades_subscription.getText());
        } else
            System.out.println("Melbourne_Renegades subscription are not in other subscriptions category : ");

        Thread.sleep((Long.parseLong(config.getProperty("Thread3000"))));
        if (Hobart_Hurricanes_subscription.isDisplayed()) {

            System.out.println("Hobart_Hurricanes subscription are in other subscriptions category : " + Hobart_Hurricanes_subscription.getText());
        } else
            System.out.println("Hobart_Hurricanes subscription are not in other subscriptions category : ");

        Thread.sleep((Long.parseLong(config.getProperty("Thread3000"))));
        if (Perth_Scorchers_subscription.isDisplayed()) {

            System.out.println("Perth_Scorchers subscription are in other subscriptions category : " + Perth_Scorchers_subscription.getText());
        } else
            System.out.println("Perth_Scorchers subscription are not in other subscriptions category : ");

        Thread.sleep((Long.parseLong(config.getProperty("Thread3000"))));
        if (Sydney_Sixers_subscription.isDisplayed()) {

            System.out.println("Sydney_Sixers subscription are in other subscriptions category : " + Sydney_Sixers_subscription.getText());
        } else
            System.out.println("Sydney_Sixers subscription are not in other subscriptions category : ");

        Thread.sleep((Long.parseLong(config.getProperty("Thread3000"))));
        if (Sydney_Thunder_subscription.isDisplayed()) {

            System.out.println("Sydney_Thunder subscription are in other subscriptions category : " + Sydney_Thunder_subscription.getText());
        } else
            System.out.println("Sydney_Thunder subscription are not in other subscriptions category : ");

        Thread.sleep((Long.parseLong(config.getProperty("Thread3000"))));
        if (Brisbane_Heat_subscription.isDisplayed()) {

            System.out.println("Brisbane_Heat subscription are in other subscriptions category : " + Brisbane_Heat_subscription.getText());
        } else
            System.out.println("Brisbane_Heat subscription are not in other subscriptions category : ");

        Thread.sleep((Long.parseLong(config.getProperty("Thread3000"))));
        if (Cricket_Australia_subscription.isDisplayed()) {

            System.out.println("Cricket Australia subscription are in other subscriptions category : " + Cricket_Australia_subscription.getText());
        } else
            System.out.println("Cricket Australia subscription are not in other subscriptions category : ");


    }

    public void verifyMysubscriptionscategory() throws InterruptedException {

        //mysubscriptions_arrow.click();
        Thread.sleep((Long.parseLong(config.getProperty("Thread3000"))));
        if (Cricket_Australia_subscription.isDisplayed()) {

            System.out.println("Cricket Australia subscription are in my subscriptions category : " + Cricket_Australia_subscription.getText());
        } else
            System.out.println("Cricket Australia subscription are not in my subscriptions category : ");

        Thread.sleep((Long.parseLong(config.getProperty("Thread3000"))));
        if (Melbourne_Stars_subscription.isDisplayed()) {

            System.out.println("MelbourneStars subscription are in my subscriptions category : " + Melbourne_Stars_subscription.getText());
        } else
            System.out.println("MelbourneStars subscription are not in my subscriptions category : ");

        Thread.sleep((Long.parseLong(config.getProperty("Thread3000"))));
        if (Melbourne_Renegades_subscription.isDisplayed()) {

            System.out.println("Melbourne_Renegades subscription are in my subscriptions category : " + Melbourne_Renegades_subscription.getText());
        } else
            System.out.println("Melbourne_Renegades subscription are not in my subscriptions category : ");

        Thread.sleep((Long.parseLong(config.getProperty("Thread3000"))));
        if (Hobart_Hurricanes_subscription.isDisplayed()) {

            System.out.println("Hobart_Hurricanes subscription are in my subscriptions category : " + Hobart_Hurricanes_subscription.getText());
        } else
            System.out.println("Hobart_Hurricanes subscription are not in my subscriptions category : ");

        Thread.sleep((Long.parseLong(config.getProperty("Thread3000"))));
        if (Perth_Scorchers_subscription.isDisplayed()) {

            System.out.println("Perth_Scorchers subscription are in my subscriptions category : " + Perth_Scorchers_subscription.getText());
        } else
            System.out.println("Perth_Scorchers subscription are not in my subscriptions category : ");

        Thread.sleep((Long.parseLong(config.getProperty("Thread3000"))));
        if (Sydney_Sixers_subscription.isDisplayed()) {

            System.out.println("Sydney_Sixers subscription are in my subscriptions category : " + Sydney_Sixers_subscription.getText());
        } else
            System.out.println("Sydney_Sixers subscription are not in my subscriptions category : ");

        Thread.sleep((Long.parseLong(config.getProperty("Thread3000"))));
        if (Sydney_Thunder_subscription.isDisplayed()) {

            System.out.println("Sydney_Thunder subscription are in my subscriptions category : " + Sydney_Thunder_subscription.getText());
        } else
            System.out.println("Sydney_Thunder subscription are not in my subscriptions category : ");

        Thread.sleep((Long.parseLong(config.getProperty("Thread3000"))));
        if (Brisbane_Heat_subscription.isDisplayed()) {

            System.out.println("Brisbane_Heat subscription are in my subscriptions category : " + Brisbane_Heat_subscription.getText());
        } else
            System.out.println("Brisbane_Heat subscription are not in my subscriptions category : ");

    }

    public void verifysubscriptionscategory() throws InterruptedException {

        //mysubscriptions_arrow.click();
        Thread.sleep((Long.parseLong(config.getProperty("Thread3000"))));

        if (Cricket_Australia_subscription.isDisplayed()) {

            System.out.println("Cricket Australia subscription are in my subscriptions category : " + Cricket_Australia_subscription.getText());
        } else
            System.out.println("Cricket Australia subscription are in other subscriptions category : ");

        if (Melbourne_Stars_subscription.isDisplayed()) {

            System.out.println("MelbourneStars subscription are in my subscriptions category : " + Melbourne_Stars_subscription.getText());
        } else
            System.out.println("MelbourneStars subscription are in other subscriptions category : ");

        Thread.sleep((Long.parseLong(config.getProperty("Thread3000"))));
        if (Melbourne_Renegades_subscription.isDisplayed()) {

            System.out.println("Melbourne_Renegades subscription are in my subscriptions category : " + Melbourne_Renegades_subscription.getText());
        } else
            System.out.println("Melbourne_Renegades subscription are in other subscriptions category : ");

        Thread.sleep((Long.parseLong(config.getProperty("Thread3000"))));
        if (Hobart_Hurricanes_subscription.isDisplayed()) {

            System.out.println("Hobart_Hurricanes subscription are in my subscriptions category : " + Hobart_Hurricanes_subscription.getText());
        } else
            System.out.println("Hobart_Hurricanes subscription are in other subscriptions category : ");

        Thread.sleep((Long.parseLong(config.getProperty("Thread3000"))));
        if (Perth_Scorchers_subscription.isDisplayed()) {

            System.out.println("Perth_Scorchers subscription are in my subscriptions category : " + Perth_Scorchers_subscription.getText());
        } else
            System.out.println("Perth_Scorchers subscription are in other subscriptions category : ");

        Thread.sleep((Long.parseLong(config.getProperty("Thread3000"))));
        if (Sydney_Sixers_subscription.isDisplayed()) {

            System.out.println("Sydney_Sixers subscription are in my subscriptions category : " + Sydney_Sixers_subscription.getText());
        } else
            System.out.println("Sydney_Sixers subscription are in other subscriptions category : ");

        Thread.sleep((Long.parseLong(config.getProperty("Thread3000"))));
        if (Sydney_Thunder_subscription.isDisplayed()) {

            System.out.println("Sydney_Thunder subscription are in my subscriptions category : " + Sydney_Thunder_subscription.getText());
        } else
            System.out.println("Sydney_Thunder subscription are in other subscriptions category : ");

        Thread.sleep((Long.parseLong(config.getProperty("Thread3000"))));
        if (Brisbane_Heat_subscription.isDisplayed()) {

            System.out.println("Brisbane_Heat subscription are in my subscriptions category : " + Brisbane_Heat_subscription.getText());
        } else
            System.out.println("Brisbane_Heat subscription are in other subscriptions category : ");

        *//*if(.isDisplayed()) {

            System.out.println(" subscription are in other subscriptions category : " + Melbourne_Stars_subscription.getText());
        }
        else
            System.out.println(" subscription are not in other subscriptions category : ");*//*

        //mysubscriptions_arrow.click();
    }*/