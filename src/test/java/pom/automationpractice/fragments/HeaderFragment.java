package pom.automationpractice.fragments;

import org.openqa.selenium.By;
import pom.components.AbstractFragment;

import static com.codeborne.selenide.Condition.visible;

public class HeaderFragment extends AbstractFragment {
    private final By rootElement = By.id("header");
    private final By signInButton = By.className("login");
    private final By signOutButton = By.className("logout");
    private final By searchField = By.id("search_query_top");
    private final By cartButton = By.xpath(".//*[@title='View my shopping cart']");

    public HeaderFragment() {
        setRootElement(rootElement);
    }

    public void clickSignInButton() {
        getRootElement().$(signInButton).click();
    }

    public void clickSignOutButton() {
        getRootElement().$(signOutButton).click();
    }

    public boolean isSignOutButtonVisible() {
        return getRootElement().$(signOutButton).isDisplayed();
    }

    public void waitUntilSignOutButtonVisible() {
        getRootElement().$(signOutButton).shouldBe(visible);
    }

    public void setSearchField(String text) {
        getRootElement().$(searchField).setValue(text);
    }

    public void doSearch(String text) {
        getRootElement().$(searchField).setValue(text).pressEnter();
    }

    public void clickToOpenCart() {
        getRootElement().$(cartButton).click();
    }
}
