package pom.automationpractice.fragments;

import org.openqa.selenium.By;
import pom.components.AbstractFragment;

public class BasketFragment extends AbstractFragment {
    private final By rootFragment = By.id("center_column");
    private final By proceedToCheckoutButton = By.xpath(".//*[@title='Proceed to checkout' and contains(@class,'standard-checkout')]");
    private final By proceedOnAddressPartButton = By.name("processAddress");
    private final By proceedOnShippingPartButton = By.name("processCarrier");
    private final By termsOfServiceCheckbox = By.id("uniform-cgv");
    private final By payByCheckButton = By.xpath(".//*[@title='Pay by check.']");
    private final By iConfirmMyOrderButton = By.xpath(".//*[text()='I confirm my order']");
    private final By successAllert = By.xpath(".//*[text()='Your order on My Store is complete.']");

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
