package utils;

import static utils.ConfigurationConstants.*;
import static utils.ConfigurationHelper.getBrowser;
import static utils.ConfigurationHelper.getGridEndpoint;
import static utils.ConfigurationHelper.getWebElementTimeout;
import static utils.ConfigurationHelper.isRemote;

import com.codeborne.selenide.Configuration;


public class Service {

    private static ThreadLocal<Service> THREAD_LOCAL = ThreadLocal.withInitial(Service::new);

    private Service() {

    }

    public static Service getInstance() {
        return THREAD_LOCAL.get();
    }

    public void initDriver() {
        Configuration.screenshots = true;
        Configuration.timeout = getWebElementTimeout();
        Configuration.startMaximized = true;

        System.setProperty(PATH_TO_CHROME_DRIVER, getPathToChromeDriver());
        System.setProperty(PATH_TO_GECKO_DRIVER, getPathToGeckoDriver());
        System.setProperty(PATH_TO_IE_FRIVER, getPathToIEDriver());

        if (isRemote()) {
            Configuration.remote = getGridEndpoint();
        } else {
            Configuration.browser = getBrowser().getName();
        }

    }

    private String getPathToChromeDriver() {
        String pathToChromeDriver;
        if (isWindows())
            pathToChromeDriver = "drivers/chrome/win32/chromedriver.exe";
        else if (isMac())
            pathToChromeDriver = "drivers/chrome/mac/chromedriver";
        else
            pathToChromeDriver = "drivers/chrome/linux/chromedriver";

        return pathToChromeDriver;
    }

    private String getPathToGeckoDriver() {
        String pathToGeckoDriver;
        if (isWindows())
            pathToGeckoDriver = "drivers/gecko/win32/geckodriver.exe";
        else if (isMac())
            pathToGeckoDriver = "drivers/gecko/mac/geckodriver";
        else
            pathToGeckoDriver = "drivers/gecko/linux/geckodriver";

        return pathToGeckoDriver;
    }

    private String getPathToIEDriver() {
        String pathToIEDriver;
        pathToIEDriver = "drivers/ie/IEDriverServer.exe";
        return pathToIEDriver;
    }

    private static boolean isWindows() {
        return System.getProperty("os.name").toLowerCase().contains("win");
    }

    private static boolean isMac() {
        return System.getProperty("os.name").toLowerCase().contains("mac");
    }

}
