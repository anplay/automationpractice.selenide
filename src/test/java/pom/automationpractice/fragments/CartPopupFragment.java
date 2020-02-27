package pom.automationpractice.fragments;

import org.openqa.selenium.By;
import pom.components.AbstractFragment;

public class CartPopupFragment extends AbstractFragment {
    private By rootElement =  By.id("layer_cart");
    private By proceedToCheckoutButton = By.xpath(".//*[@title='Proceed to checkout']");
    private By continueShoppingButton = By.xpath(".//*[@title='Continue shopping']");

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
