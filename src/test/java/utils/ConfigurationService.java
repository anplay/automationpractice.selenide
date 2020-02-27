package utils;

import org.apache.commons.configuration.CompositeConfiguration;
import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.configuration.SystemConfiguration;
import org.apache.commons.lang3.StringUtils;


public class ConfigurationService {
	private static final Object SYN_OBJ = new Object();
	private static Configuration CONFIGURATION = null;

	private ConfigurationService() {

	}

	public static Configuration getConfigInstance() {
		if (CONFIGURATION == null)
			synchronized (SYN_OBJ) {
				if (CONFIGURATION == null)
					try {
						CompositeConfiguration compositeConfiguration = new CompositeConfiguration();
						compositeConfiguration.addConfiguration(new SystemConfiguration());
						compositeConfiguration.addConfiguration(new PropertiesConfiguration("conf/local.properties"));
						CONFIGURATION = compositeConfiguration;
					} catch (ConfigurationException e) {
						throw new IllegalStateException("Unable to load configuration", e);
					}
			}
		return CONFIGURATION;
	}

	public static String getProperty(String property) {
		return getProperty(property, StringUtils.EMPTY);
	}

	public static String getProperty(String property, String defaultValue) {
		return getConfigInstance().getString(property, defaultValue).trim();
	}
}
