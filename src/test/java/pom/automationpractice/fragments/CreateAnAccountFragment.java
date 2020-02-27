package pom.automationpractice.fragments;

import org.openqa.selenium.By;
import pom.components.AbstractFragment;

import static com.codeborne.selenide.Condition.visible;

public class CreateAnAccountFragment extends AbstractFragment {
    private By rootElement = By.xpath(".//*[contains(@id,'account_form')]");
    private By emailField = By.id("email_create");
    private By createAnAccountButton = By.id("SubmitCreate");

    public CreateAnAccountFragment() {
        setRootElement(rootElement);
    }

    public void setEmailField(String email) {
        getRootElement().shouldBe(visible);
        getRootElement().$(emailField).setValue(email);
    }

    public void clickCreateAnAccountButton() {
        getRootElement().shouldBe(visible);
        getRootElement().$(createAnAccountButton).click();
    }
}
