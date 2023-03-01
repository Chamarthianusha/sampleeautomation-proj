package Testcases;

import CA.Pages.Communication_PreferencesPage;
import CA.Pages.Email_SubscriptionPage;
import CA.base.BaseClass;
import org.testng.annotations.Test;

public class Email_SubscriptionPageTestCases extends BaseClass {

    Email_SubscriptionPage email_SubscriptionPage;

    public Email_SubscriptionPageTestCases() {
        super();
    }

    @Test(priority =1,enabled = true,description="Registration functionality on email subscription page")
    public void verifyemailsubscriptionregTest() throws InterruptedException {

        email_SubscriptionPage =new Email_SubscriptionPage();
        email_SubscriptionPage.verifyemailsubscriptionreg(config.getProperty("Liteacc_FirstName"),config.getProperty("Liteacc_lastName"),config.getProperty("Liteacc_EmailAddress"));

    }

    @Test(priority =2,enabled = true,description="Error messages on email subscription page")
    public void verifyerrormessageonemailsubscriptionregTest() throws InterruptedException {

        email_SubscriptionPage =new Email_SubscriptionPage();
        email_SubscriptionPage.verifyerrormessageonemailsubscriptionreg();

    }

    @Test(priority =3,enabled = true,description="Login functionality on email subscription page")
    public void verifycommunicationpreferencesloginTest() throws InterruptedException {

        email_SubscriptionPage =new Email_SubscriptionPage();
        email_SubscriptionPage.verifyemailsubscriptionlogin(config.getProperty("ValidEmailId"),config.getProperty("ValidPassword"));

    }
}
