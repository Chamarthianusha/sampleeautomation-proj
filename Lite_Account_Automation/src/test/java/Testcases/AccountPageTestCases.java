package Testcases;

import CA.Pages.AccountPage;
import CA.base.BaseClass;
import org.testng.annotations.Test;

public class AccountPageTestCases extends BaseClass {

    AccountPage accountPage;

    public AccountPageTestCases() {
        super();
    }

    @Test(priority =1,enabled = true)
    public void verifyexistinguserloginTest() throws InterruptedException {

        accountPage =new AccountPage();
        accountPage.verifyexistinguserlogin(config.getProperty("ValidEmailId"),config.getProperty("ValidPassword"));

    }

    @Test(priority =2,enabled = true)//,dependsOnMethods = "verifyexistinguserloginTest")
    public void verifyAccountPageTest() throws InterruptedException {

        accountPage =new AccountPage();
        accountPage.verifyAccountPage(config.getProperty("ValidEmailId"),config.getProperty("ValidPassword"));

    }

    @Test(priority =3,enabled = true)//,dependsOnMethods = "verifyexistinguserloginTest")
    public void verifyChangeEmail_linkTest() throws InterruptedException {

        accountPage =new AccountPage();
        accountPage.verifyChangeEmail_link(config.getProperty("ValidEmailId"));

    }

    @Test(priority =4,enabled = true)//,dependsOnMethods = "verifyexistinguserloginTest")
    public void verifyCancelButtonOnChangeEmailTest() throws InterruptedException {

        accountPage =new AccountPage();
        accountPage.verifyCancelButtonOnChangeEmail();

    }

    @Test(priority =5,enabled = true)//,dependsOnMethods = "verifyexistinguserloginTest")
    public void verifyViewall_btnTest() throws InterruptedException {

        accountPage =new AccountPage();
        accountPage.verifyViewall_btn();

    }

    @Test(priority =6,enabled =true)//,dependsOnMethods = "verifyexistinguserloginTest")
    public void verifyEdit_btnTest() throws InterruptedException {

        accountPage =new AccountPage();
        accountPage.verifyEdit_btn();

    }

    @Test(priority =7,enabled = true)//,dependsOnMethods = "verifyexistinguserloginTest")
    public void verifyCommunicationpreferences_linkTest() throws InterruptedException {

        accountPage =new AccountPage();
        accountPage.verifyCommunicationpreferences_link();

    }

    @Test(priority =8,enabled = true)//,dependsOnMethods = "verifyexistinguserloginTest")
    public void verifyChangePassword_linkTest() throws InterruptedException {

        accountPage =new AccountPage();
        accountPage.verifyChangePassword_link(config.getProperty("ValidPassword"),config.getProperty("Newpwd"),
                config.getProperty("Confirmpwd"),config.getProperty("ValidEmailId"),config.getProperty("ValidPassword"));

    }

    @Test(priority =9,enabled = true)//,dependsOnMethods = "verifyexistinguserloginTest")
    public void verifyCancelButtonOnChangePasswordTest() throws InterruptedException {

        accountPage =new AccountPage();
        accountPage.verifyCancelButtonOnChangePassword();

    }

    @Test(priority=10,enabled=false,description = "Cancel button on Delete account page")
    public void VerifyCancelBtnOndeleteaccountTest() throws InterruptedException {

        accountPage =new AccountPage();
        accountPage.VerifyCancelBtnOndeleteaccount(config.getProperty("Newpwd"));
    }

    @Test(priority=11,enabled=true,description = "Delete your account")
    public void verifyDeleteYourAccountTest() throws InterruptedException {

        accountPage =new AccountPage();
        accountPage.verifyDeleteAccount_link(config.getProperty("ValidPassword"));
    }

    @Test(priority=12,enabled=false,description = "Delete your account")
    public void verifySignout_linkTest() throws InterruptedException {

        accountPage =new AccountPage();
        accountPage.verifySignout_link();
    }

}
