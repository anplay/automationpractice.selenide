package pom.components;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;


public abstract class AbstractFragment {

	private SelenideElement rootElement;
	private By rootBy;

	protected SelenideElement getRootElement() {
		return (rootElement == null) ? $(rootBy): rootElement;
	}

	protected void setRootElement(SelenideElement rootElement) {
		this.rootElement = rootElement;
	}

	protected void setRootElement(By rootElement) {
		this.rootBy = rootElement;
	}

	public boolean isVisible() {
		return getRootElement().isDisplayed();
	}

	public AbstractFragment waitForShown() {
		getRootElement().should(visible);
		return this;
	}

	public WebElement getChildElement(By byLocator) {
		return getRootElement().find(byLocator);
	}

	public ElementsCollection getChildElements(By byLocator) {
		return getRootElement().findAll(byLocator);
	}
}

