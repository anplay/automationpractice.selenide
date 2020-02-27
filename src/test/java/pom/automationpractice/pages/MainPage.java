package pom.automationpractice.pages;

import pom.components.AbstractSitePage;

public class MainPage extends AbstractSitePage {
    private final static String PAGE_NAME = "My Store";
    private final static String PATH = "/index.php";
    private final static String BODY_CLASS = "index";

    public MainPage() {
        setPageUrl(PATH);
        setPageName(PAGE_NAME);
        setBodyClass(BODY_CLASS);
    }
}
