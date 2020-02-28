package pom.automationpractice.utils;

import pom.automationpractice.fragments.AccountCreationFragment;
import pom.automationpractice.fragments.CreateAnAccountFragment;
import pom.automationpractice.fragments.HeaderFragment;
import pom.automationpractice.pages.MainPage;

public class UserActionUtils {
    private static final String FIRST_NAME = "FirstName";
    private static final String LAST_NAME = "LastName";
    private static final String PASSWORD = "Password";
    private static final String ADDRESS = "str. address 1";
    private static final String CITY = "City";
    private static final String STATE = "Alaska";
    private static final String DOMAIN_COM = "@domain.com";
    private static final String EMAIL_PREFIX = "test";
    private static final String POSTCODE = "37000";
    private static final String PHONE = "+380981234567";

    private MainPage mainPage;
    private CreateAnAccountFragment createAnAccountFragment;
    private AccountCreationFragment accountCreationFragment;
    private HeaderFragment headerFragment;

    public UserActionUtils() {
        mainPage = new MainPage();
        createAnAccountFragment = new CreateAnAccountFragment();
        accountCreationFragment = new AccountCreationFragment();
        headerFragment = new HeaderFragment();
    }

    public String signUpNewUserWithoutLogout(String userName) {
        String email = EMAIL_PREFIX + userName + DOMAIN_COM;

        mainPage.visit();
        headerFragment.clickSignInButton();
        createAnAccountFragment.setEmailField(email);
        createAnAccountFragment.clickCreateAnAccountButton();

        accountCreationFragment.setFirstNameField(FIRST_NAME);
        accountCreationFragment.setLastNameField(LAST_NAME);
        accountCreationFragment.setPasswordField(PASSWORD);
        accountCreationFragment.setAddressField(ADDRESS);
        accountCreationFragment.setCityField(CITY);
        accountCreationFragment.setStatePicker(STATE);
        accountCreationFragment.setPostcodeField(POSTCODE);
        accountCreationFragment.setMobilePhoneField(PHONE);
        accountCreationFragment.clickRegisterButton();

        headerFragment.waitUntilSignOutButtonVisible();
        return email;
    }

    public String signUpNewUserWithLogout(String userName) {
        String email = signUpNewUserWithoutLogout(userName);

        headerFragment.clickSignOutButton();

        return email;
    }

    public void signInByExistedUser(String email) {

        mainPage.visit();
        headerFragment.clickSignInButton();
    }
}
