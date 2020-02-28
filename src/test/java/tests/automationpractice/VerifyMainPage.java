package tests.automationpractice;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.Step;
import org.testng.annotations.Parameters;
import pom.automationpractice.fragments.ColumnsFragment;
import pom.automationpractice.fragments.FooterFragment;
import pom.automationpractice.fragments.HeaderFragment;
import pom.automationpractice.pages.MainPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pom.automationpractice.utils.UserActionUtils;

import static org.assertj.core.api.Assertions.assertThat;

public class VerifyMainPage {
    private MainPage mainPage;
    private FooterFragment footerFragment;
    private HeaderFragment headerFragment;
    private ColumnsFragment columnsFragment;
    private UserActionUtils userActionUtils;

    @Parameters({"browser"})
    @BeforeMethod
    public void setUpClass(String browser) {
        Configuration.browser = browser;
        mainPage = new MainPage();
        footerFragment = new FooterFragment();
        headerFragment = new HeaderFragment();
        columnsFragment = new ColumnsFragment();
        userActionUtils = new UserActionUtils();
    }

    @Test
    public void verifyMainPage() {
        mainPage.visit();

        assertThat(headerFragment.isVisible()).isTrue();
        assertThat(columnsFragment.isVisible()).isTrue();
        assertThat(footerFragment.isVisible()).isTrue();
    }

    @Test
    public void registerNewUser() {
        String timestamp = String.valueOf(System.currentTimeMillis());

        userActionUtils.signUpNewUserWithoutLogout(timestamp);

        assertThat(headerFragment.isSignOutButtonVisible()).isTrue();
    }

}
