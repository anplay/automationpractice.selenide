package pom.automationpractice.fragments;

import org.openqa.selenium.By;
import pom.components.AbstractFragment;

public class CartPopupFragment extends AbstractFragment {
    private final By rootElement =  By.id("layer_cart");
    private final By proceedToCheckoutButton = By.xpath(".//*[@title='Proceed to checkout']");
    private final By continueShoppingButton = By.xpath(".//*[@title='Continue shopping']");

    public CartPopupFragment() {
        setRootElement(rootElement);
    }

    public void clickProceedToCheckoutButton() {
        getRootElement().$(proceedToCheckoutButton).click();
    }

    public void clickContinueShoppingButton() {
        getRootElement().$(continueShoppingButton).click();
    }
}
