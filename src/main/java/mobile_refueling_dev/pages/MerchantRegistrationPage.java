package mobile_refueling_dev.pages;

import com.github.javafaker.Faker;
import com.microsoft.playwright.Page;

import static mobile_refueling_dev.pages.Locators.LocatorsOfMerchantRegistration.*;

public class MerchantRegistrationPage {
    private final Page page;
    Faker faker = new Faker();

    public MerchantRegistrationPage(Page page) {
        this.page = page;
    }

    public void clickMerchantManagementMenu() {
        page.locator(MERCHANT_MANAGEMENT_MENU).click();
    }

    public void clickMerchantSubMenu() {
        page.locator(MERCHANT_SUB_MENU).click();
    }

    public void clickAddButton() {
        page.locator(ADD_MERCHANT_BUTTON).click();
    }

    public void setMerchantEmail() {
        page.locator(EMAIL_FIELD).fill(faker.name().username() + "@yopmail.com");
    }

    public void setPhoneNumber1() {
        page.locator(PHONE_CODE_DROPDOWN).click();
        page.locator(PHONE_CODE).click();
        page.locator(PHONE_NUMBER_1).fill(String.format("%07d", faker.number().numberBetween(0, 9999999)));
    }

    public void selectMerchantType() {
        page.locator(MERCHANT_TYPE_DROPDOWN_FIELD).click();
        page.locator(MERCHANT_TYPE).click();
    }
    public void setMerchantName() {
        page.locator(MERCHANT_NAME_FIELD).fill(faker.name().username());
    }

    public void setAddress1() {
        page.locator(ADDRESS_1).fill(faker.address().fullAddress());
    }
    public void setTaxPayerID() {
        page.locator(TAX_PAYER_ID).fill(faker.code().imei());
    }
    public void setStartTime() {
        page.locator(START_TIME).fill("07:30 AM");
    }
    public void setFirstName() {
        page.locator(CONTACT_FIRST_NAME).fill(faker.name().firstName());
    }
    public void setLastName() {
        page.locator(CONTACT_LAST_NAME).fill(faker.name().lastName());
    }

    public void setContactEmail() {
        page.locator(CONTACT_EMAIL).scrollIntoViewIfNeeded();
        page.locator(CONTACT_EMAIL).fill(faker.name().username() + "@yopmail.com");
    }
    public void selectBank() {
        page.locator(BANK_DROPDOWN).scrollIntoViewIfNeeded();
        page.locator(BANK_DROPDOWN).click();
        page.locator(SELECT_BANK).click();
    }
    public void selectBranch() {
        page.locator(BRANCH_DROPDOWN).evaluate("element => element.scrollIntoView()");
        page.locator(BRANCH_DROPDOWN).click();
        page.locator(SELECT_BRANCH).click();
    }
    public void setAccountNumber() {
        page.locator(ACCOUNT_NUMBER).fill(faker.code().imei());
    }

    public void clickAddBankButton() {
        page.locator(ADD_BANK_FOR_MERCHANT).evaluate("element => element.scrollIntoView()");
        page.locator(ADD_BANK_FOR_MERCHANT).click();
    }

    public void clickSaveButton() {
        page.locator(SAVE_BUTTON).evaluate("element => element.scrollIntoView()");
        page.locator(SAVE_BUTTON).click();
    }

    public void clickOkButton() {
        page.locator(OK_BUTTON).click();
    }

    public String getText() {
        return page.locator(TEXT_ASSERT).textContent();
    }

}
