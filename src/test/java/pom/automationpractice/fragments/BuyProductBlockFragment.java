package pom.automationpractice.fragments;

import org.openqa.selenium.By;
import pom.components.AbstractFragment;

public class BuyProductBlockFragment extends AbstractFragment {
    private final By rootElement = By.id("buy_block");
    private final By addToCartButton = By.id("add_to_cart");

    public BuyProductBlockFragment() {
        setRootElement(rootElement);
    }

    public void clickAddToCartButton() {
        getRootElement().$(addToCartButton).click();
    }
}
