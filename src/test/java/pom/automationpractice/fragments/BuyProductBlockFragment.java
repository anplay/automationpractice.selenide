package pom.automationpractice.fragments;

import org.openqa.selenium.By;
import pom.components.AbstractFragment;

public class BuyProductBlockFragment extends AbstractFragment {
    private By rootElement = By.id("buy_block");
    private By addToCartButton = By.id("add_to_cart");

    public BuyProductBlockFragment() {
        setRootElement(rootElement);
    }

    public void clickAddToCartButton() {
        getRootElement().$(addToCartButton).click();
    }
}
