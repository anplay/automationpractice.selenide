package utils;

import static utils.ConfigurationConstants.*;
import static utils.ConfigurationService.getProperty;


public class ConfigurationHelper {

	private ConfigurationHelper() {

	}

	public static long getWebElementTimeout() {
		long dafaultValue = 30000;
		return ConfigurationService.getConfigInstance().getLong(WEB_ELEMENT_TIMEOUT, dafaultValue);
	}

	public static String getRestV2Url() {
		return getProperty(REST_URL_V2);
	}

	public static String getRestUrl() {
		return getProperty(REST_URL);
	}

	public static String getWebEndpoint() {
		return getProperty(WEBSITE_URL);
	}

	public static Browser getBrowser() {
		String value = getProperty(SELENIDE_BROWSER);
		for (Browser browser : Browser.values())
			if (value.equalsIgnoreCase(browser.getName()))
				return browser;
		throw new IllegalStateException(String.format("'%s' is not a valid value of Enum 'Browser'", value));
	}

	public static boolean isRemote() {
		return ConfigurationService.getConfigInstance().getBoolean(SELENIDE_USE_GRID, false);
	}

	public static String getGridEndpoint() {
		return getProperty(SELENIDE_GRID_ENDPOINT);
	}

}
