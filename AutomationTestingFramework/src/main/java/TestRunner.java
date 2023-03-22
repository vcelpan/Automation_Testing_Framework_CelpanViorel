import managers.WebDriverManager;

public class TestRunner {

    public static void main(String[] args) {
        // testing CHROME
        WebDriverManager webDriverChrome = new WebDriverManager("CHROME");
        webDriverChrome.getDriver().get("https://google.com/");
        webDriverChrome.getDriver().close();

        // testing FIREFOX
        WebDriverManager webDriverFirefox = new WebDriverManager("FIREFOX");
        webDriverFirefox.getDriver().get("https://protv.md/");
        webDriverFirefox.closeDriver();
    }
}
