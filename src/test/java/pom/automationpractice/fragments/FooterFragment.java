package pom.automationpractice.fragments;

import org.openqa.selenium.By;
import pom.components.AbstractFragment;


public class FooterFragment extends AbstractFragment {
    private By rootElement = By.id("footer");

    public FooterFragment() {
        setRootElement(rootElement);
    }


}
