package mobile_refueling_dev.TestCases;

import org.testng.annotations.Test;

public class MerchantRegistrationTest extends BaseTest {
    @Test
    public void testMerchantRegistration() throws InterruptedException {
        String username = properties.getProperty("username");
        String password = properties.getProperty("password");
        loginLogoutPage.login(username.trim(), password.trim());

        merchantRegistrationPage = loginLogoutPage.merchantRegistrationPage();
        merchantRegistrationPage.clickMerchantManagementMenu();
        merchantRegistrationPage.clickMerchantSubMenu();
        merchantRegistrationPage.clickAddButton();
        merchantRegistrationPage.setMerchantEmail();
        merchantRegistrationPage.setPhoneNumber1();
        merchantRegistrationPage.selectMerchantType();
        merchantRegistrationPage.setMerchantName();
        merchantRegistrationPage.setAddress1();
        merchantRegistrationPage.setTaxPayerID();
        merchantRegistrationPage.setStartTime();
        merchantRegistrationPage.setFirstName();
        merchantRegistrationPage.setLastName();
        merchantRegistrationPage.setContactEmail();
        merchantRegistrationPage.selectBank();
        merchantRegistrationPage.selectBranch();
        merchantRegistrationPage.setAccountNumber();
        merchantRegistrationPage.clickAddBankButton();
        merchantRegistrationPage.clickSaveButton();

        String text = merchantRegistrationPage.getText();
        assert text.equals("Merchant Added Successfully");
        Thread.sleep(2000);
        merchantRegistrationPage.clickOkButton();

        loginLogoutPage.Logout();
        Thread.sleep(1000);
    }
}
