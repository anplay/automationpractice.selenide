package pom.automationpractice.fragments;

import org.openqa.selenium.By;
import pom.components.AbstractFragment;

public class BasketFragment extends AbstractFragment {
    private By rootFragment = By.id("center_column");
    private By proceedToCheckoutButton = By.xpath(".//*[@title='Proceed to checkout' and contains(@class,'standard-checkout')]");
    private By proceedOnAddressPartButton = By.name("processAddress");
    private By proceedOnShippingPartButton = By.name("processCarrier");
    private By termsOfServiceCheckbox = By.id("uniform-cgv");
    private By payByCheckButton = By.xpath(".//*[@title='Pay by check.']");
    private By iConfirmMyOrderButton = By.xpath(".//*[text()='I confirm my order']");
    private By successAllert = By.xpath(".//*[text()='Your order on My Store is complete.']");

    public BasketFragment() {
        setRootElement(rootFragment);
    }

    public void clickProceedToCheckoutButton() {
        getRootElement().$(proceedToCheckoutButton).click();
    }

    public void clickProceedToCheckoutOnAddressButton() {
        getRootElement().$(proceedOnAddressPartButton).click();
    }

    public void clickProceedToCheckoutOnShippingButton() {
        getRootElement().$(proceedOnShippingPartButton).click();
    }

    public void tipTermsOfServiceCheckbox() {
        getRootElement().$(termsOfServiceCheckbox).click();
    }

    public void clickPayByCheckButton() {
        getRootElement().$(payByCheckButton).click();
    }

    public void clickIConfirmMyOrderButton() {
        getRootElement().$(iConfirmMyOrderButton).click();
    }

    public boolean isSuccessAllertVisible() {
        return getRootElement().$(successAllert).isDisplayed();
    }
}
