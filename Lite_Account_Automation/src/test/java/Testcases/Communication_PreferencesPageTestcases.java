package Testcases;

import CA.Pages.Communication_PreferencesPage;
import CA.base.BaseClass;
import org.apache.log.Priority;
import org.testng.annotations.Test;

public class Communication_PreferencesPageTestcases extends BaseClass {

    Communication_PreferencesPage communication_PreferencesPage;

    public Communication_PreferencesPageTestcases() {
        super();
    }

    @Test(priority =1,enabled = true,description="Login functionality on communication preferences page")
    public void verifycommunicationpreferencesloginTest() throws InterruptedException {

        communication_PreferencesPage =new Communication_PreferencesPage();
        communication_PreferencesPage.verifycommunicationpreferenceslogin(config.getProperty("ValidEmailId"),config.getProperty("ValidPassword"));

    }

    @Test(priority =2,enabled = true,description="User is associated with any cricketID lite account")
    public void verifycommunicationpreferencesforliteaccountTest() throws InterruptedException {

        communication_PreferencesPage =new Communication_PreferencesPage();
        communication_PreferencesPage.verifycommunicationpreferencesforliteaccount(config.getProperty("LiteAccount"));

    }

    @Test(priority =3,enabled = true,description="User is not associated with any cricketID account")
    public void verifycommunicationpreferencesforNoaccountTest() throws InterruptedException {

        communication_PreferencesPage =new Communication_PreferencesPage();
        communication_PreferencesPage.verifycommunicationpreferencesforNoaccount(config.getProperty("NoAccount"));

    }

    @Test(priority =4,enabled = true,description="User is  associated with full account cricketID")
    public void verifycommunicationpreferencesforCricketIdTest() throws InterruptedException {

        communication_PreferencesPage =new Communication_PreferencesPage();
        communication_PreferencesPage.verifycommunicationpreferencesforCricketId(config.getProperty("ValidEmailId"),config.getProperty("ValidPassword"));

    }

    @Test(priority =5,enabled = true,description="User is  associated with full account cricketID",dependsOnMethods ="verifycommunicationpreferencesforCricketIdTest" )
    public void verifyUnsubscribeallbtnTest() throws InterruptedException {

        communication_PreferencesPage =new Communication_PreferencesPage();
        communication_PreferencesPage.verifyUnsubscribeallbtn(config.getProperty("ValidEmailId"),config.getProperty("ValidPassword"));

    }

    @Test(priority =6,enabled = true,description="User is  associated with full account cricketID",dependsOnMethods ="verifycommunicationpreferencesforCricketIdTest" )
    public void verifysubscribes_by_checking_boxTest() throws InterruptedException {

        communication_PreferencesPage =new Communication_PreferencesPage();
        communication_PreferencesPage.verifysubscribes_by_checking_box();

    }

    @Test(priority =7,enabled = true,description="User is  associated with full account cricketID",dependsOnMethods ="verifycommunicationpreferencesforCricketIdTest" )
    public void verifyUnsubscribes_by_unchecking_boxTest() throws InterruptedException {

        communication_PreferencesPage =new Communication_PreferencesPage();
        communication_PreferencesPage.verifyUnsubscribes_by_unchecking_box();

    }
}
