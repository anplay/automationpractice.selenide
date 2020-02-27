package pom.automationpractice.fragments;

import org.openqa.selenium.By;
import pom.components.AbstractFragment;

import static com.codeborne.selenide.Condition.visible;

public class AccountCreationFragment extends AbstractFragment {
    private By rootElement = By.xpath(".//*[contains(@id,'creation_form')]");
    private By firstNameField = By.id("customer_firstname");
    private By lastNameField = By.id("customer_lastname");
    private By passwordField = By.id("passwd");
    private By dayPicker = By.id("days");
    private By monthPicker = By.id("months");
    private By yearPicker = By.id("years");
    private By addressField = By.id("address1");
    private By cityField = By.id("city");
    private By statePicker = By.id("id_state");
    private By postcodeField = By.id("postcode");
    private By mobilePhoneField = By.id("phone_mobile");
    private By registerButton = By.id("submitAccount");

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
