package mobile_refueling_dev.pages;

import com.microsoft.playwright.Page;

public class LoginLogoutPage {

    private final Page page;

    private final String xpathOfUsername = "//html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/input[1]";
    private final String xpathOfPassword = "//html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[2]/input[1]";
    private final String xpathOfSignIn = "//html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[4]/input[2]";
    private final String xpathOfMyProfile = "//html[1]/body[1]/uni-root[1]/uni-dashboard[1]/nz-spin[1]/div[1]/nz-layout[1]/uni-header[1]/nz-header[1]/div[1]/div[1]/div[2]/div[1]/div[4]/div[1]/div[1]/span[1]";
    private final String xpathOfLogout = "//div[@class='cdk-overlay-container']//li[1]";
    private final String xpathOfConveniencePay = "//h1[normalize-space()='Convenience Pay']";

    public LoginLogoutPage(Page page) {
        this.page = page;
    }

    public void login(String username, String password) {
        page.locator(xpathOfUsername).fill(username);
        page.locator(xpathOfPassword).fill(password);
        page.locator(xpathOfSignIn).click();
        assert page.textContent(xpathOfConveniencePay).equals("Convenience Pay");
    }

    public void Logout() {
        page.locator(xpathOfMyProfile).click();
        page.locator(xpathOfLogout).click();
    }

    public MyProfilePage navigateToMyProfile() {
        return new MyProfilePage(page);
    }
}
