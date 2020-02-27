package pom.automationpractice.fragments;

import org.openqa.selenium.By;
import pom.components.AbstractFragment;

import static com.codeborne.selenide.Condition.visible;

public class ProductFromListFragment extends AbstractFragment {
    private By addToCartButton = By.xpath(".//*[@title='Add to cart']");

    public ProductFromListFragment(String productName) {
        setRootElement(By
                .xpath("//div[@class='product-container' and .//a[contains(@title,'" + productName + "')]]"));

    }

    public void clickAddToCartProduct() {
        getRootElement().hover().$(addToCartButton).shouldBe(visible).click();
    }

}
