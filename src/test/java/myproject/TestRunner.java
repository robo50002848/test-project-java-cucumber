package myproject;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

import static utils.WebDriverUtils.deleteAllCookies;
import static utils.WebDriverUtils.quitDriver;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/myproject/features/registration.feature"},
        plugin = {
                "pretty",
                "html:target/cucumber",
                "json:target/cucumber.json"
        })

public class TestRunner {

    @AfterClass
    public static void tearDownClass() {
        deleteAllCookies();
        quitDriver();
    }
}
