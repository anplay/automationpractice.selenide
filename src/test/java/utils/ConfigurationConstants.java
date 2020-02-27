package utils;

public class ConfigurationConstants {

	public static final String SELENIDE_USE_GRID = "selenide.use.grid";
	public static final String SELENIDE_GRID_ENDPOINT = "remote";
	public static final String SELENIDE_BROWSER = "selenide.browser";
	public static final String WEBSITE_URL = "website.url";
	public static final String REST_URL = "rest.url";
	public static final String REST_URL_V2 = "rest.url.v2";
	public static final String WEB_ELEMENT_TIMEOUT = "webelement.wait.timeout";
	public static final String PATH_TO_CHROME_DRIVER = "webdriver.chrome.driver";
	public static final String PATH_TO_GECKO_DRIVER = "webdriver.gecko.driver";
	public static final String PATH_TO_IE_FRIVER = "webdriver.ie.driver";

	public enum Browser {

		CHROME("chrome"), FIREFOX("firefox"), IE("ie"), HTMLUNIT("htmlunit"), PHANTOMJS("phantomjs");

		private final String name;

		private Browser(String name) {
			this.name = name;
		}

		public String getName() {
			return name;
		}

	}
}
