package pom.automationpractice.fragments;

import org.openqa.selenium.By;
import pom.components.AbstractFragment;

public class ProductListFragment extends AbstractFragment {
    private final By rootElement = By.className("product_list");

    public ProductListFragment() {
        setRootElement(rootElement);
    }

    public ProductFromListFragment getProductFromListFragment(String productName) {
        return new ProductFromListFragment(productName);
    }

}
