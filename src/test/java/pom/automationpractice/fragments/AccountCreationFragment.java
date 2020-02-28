package pom.automationpractice.fragments;

import org.openqa.selenium.By;
import pom.components.AbstractFragment;

import static com.codeborne.selenide.Condition.visible;

public class AccountCreationFragment extends AbstractFragment {
    private final By rootElement = By.xpath(".//*[contains(@id,'creation_form')]");
    private final By firstNameField = By.id("customer_firstname");
    private final By lastNameField = By.id("customer_lastname");
    private final By passwordField = By.id("passwd");
    private final By dayPicker = By.id("days");
    private final By monthPicker = By.id("months");
    private final By yearPicker = By.id("years");
    private final By addressField = By.id("address1");
    private final By cityField = By.id("city");
    private final By statePicker = By.id("id_state");
    private final By postcodeField = By.id("postcode");
    private final By mobilePhoneField = By.id("phone_mobile");
    private final By registerButton = By.id("submitAccount");

    public AccountCreationFragment() {
        setRootElement(rootElement);
    }

    public void setFirstNameField(String firstName) {
        getRootElement().shouldBe(visible);
        getRootElement().$(firstNameField).setValue(firstName);
    }

    public void setLastNameField(String lastName) {
        getRootElement().$(lastNameField).setValue(lastName);
    }

    public void setPasswordField(String password) {
        getRootElement().$(passwordField).setValue(password);
    }

    public void setDayPicker(String dayOfMonth) {
        getRootElement().$(dayPicker).selectOption(dayOfMonth);
    }

    public void setMonthPicker(String month) {
        getRootElement().$(monthPicker).selectOption(month);
    }

    public void setYearPicker(String year) {
        getRootElement().$(yearPicker).selectOption(year);
    }

    public void setAddressField(String address) {
        getRootElement().$(addressField).setValue(address);
    }

    public void setCityField(String city) {
        getRootElement().$(cityField).setValue(city);
    }

    public void setStatePicker(String state) {
        getRootElement().$(statePicker).selectOption(state);
    }

    public void setPostcodeField(String postcode) {
        getRootElement().$(postcodeField).setValue(postcode);
    }

    public void setMobilePhoneField(String phone) {
        getRootElement().$(mobilePhoneField).setValue(phone);
    }

    public void clickRegisterButton() {
        getRootElement().$(registerButton).click();
    }

}
