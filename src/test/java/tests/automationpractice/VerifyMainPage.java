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

import static org.assertj.core.api.Assertions.assertThat;

public class VerifyMainPage {
    private MainPage mainPage;
    private FooterFragment footerFragment;
    private HeaderFragment headerFragment;
    private ColumnsFragment columnsFragment;

    @Parameters({"browser"})
    @BeforeMethod
    public void setUpClass(String browser) {
        Configuration.browser = browser;
        mainPage = new MainPage();
        footerFragment = new FooterFragment();
        headerFragment = new HeaderFragment();
        columnsFragment = new ColumnsFragment();
    }

    @Step()
    @Test
    public void verifyMainPage() {
        mainPage.visit();

        assertThat(headerFragment.isVisible()).isTrue();
        assertThat(columnsFragment.isVisible()).isTrue();
        assertThat(footerFragment.isVisible()).isTrue();

    }

}
