package pom.components;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.executeJavaScript;
import static com.codeborne.selenide.Selenide.open;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import utils.ConfigurationHelper;
import com.codeborne.selenide.SelenideElement;


public abstract class AbstractSitePage {

	private String urlFormat; // can be regExp
	private String pageUrl;
	private String pageTitle;
	private String bodyClass;

	protected String getUrlFormat() {
		if (getClass().isAnnotationPresent(UriFormat.class))
			return getClass().getAnnotation(UriFormat.class).value();
		return urlFormat;
	}

	/**
	 * Use this method to provide flexible way to validate page URL. </br>
	 * For example if URL is generic: /path/gen_id000X, use regex pattern /path/.*+ to validate the page.
	 *
	 * @param urlFormat
	 */
	public void setUrlFormat(String urlFormat) {
		this.urlFormat = urlFormat;
	}

	public final boolean hasUrlFormat() {
		return getUrlFormat() != null;
	}

	protected String getPageUrl() {
		boolean isAnnotated = getClass().isAnnotationPresent(URI.class);
		if (pageUrl == null && !isAnnotated)
			throw new IllegalStateException(
					"Please set page URL using appropriate method ( setPageUrl(String pageUrl) ) or with annotation @URI. Page URL must not be null.");
		if (isAnnotated)
			return getClass().getAnnotation(URI.class).value();
		else
			return pageUrl;
	}

	public void setPageUrl(String pageUrl) {
		this.pageUrl = pageUrl;
	}

	public String getPageTitle() {
		if (getClass().isAnnotationPresent(Title.class))
			return getClass().getAnnotation(Title.class).value();
		else if (StringUtils.isEmpty(pageTitle))
			return StringUtils.EMPTY;
		return pageTitle;
	}

	public void setPageName(String pageTitle) {
		this.pageTitle = pageTitle;
	}

	protected String getBodyClass() {
		if (getClass().isAnnotationPresent(BodyClass.class))
			return getClass().getAnnotation(BodyClass.class).value();
		else if (StringUtils.isEmpty(bodyClass))
			return StringUtils.EMPTY;
		return bodyClass;
	}

	protected void setBodyClass(String bodyClass) {
		this.bodyClass = bodyClass;
	}

	public String getMetaValue(String key) {
		SelenideElement metaElement = $(By.cssSelector(String.format("head meta[name=%s]", key)));
		return metaElement.getAttribute("content");
	}

	public String getCanonicalLink() {
		SelenideElement metaElement = $(By.cssSelector("link[rel='canonical']"));
		return metaElement.getAttribute("href");
	}

	protected SelenideElement getPageBody() {
		return $(By.cssSelector("body"));
	}

	public void visit() {
		final String pageUrl = getEndpoint() + getPageUrl();
		try {
			open(pageUrl);
		} catch (TimeoutException e) {
			if (isInteractive()) {
				return;
			}
			throw e;
		}
	}

	public void visit(String urlPart) {
		final String pageUrl = getEndpoint() + urlPart;
		try {
			open(pageUrl);
		} catch (TimeoutException e) {
			if (isInteractive()) {
				return;
			}
			throw e;
		}
	}

	protected boolean isInteractive() {
		return getDocumentReadyState().equals("interactive");
	}

	private String getDocumentReadyState() {
		return (String) executeJavaScript("return document.readyState");
	}

	protected String getEndpoint() {
		return ConfigurationHelper.getWebEndpoint();
	}
}
