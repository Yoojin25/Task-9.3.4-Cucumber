package step_definitions;

import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import steps.asserts.Assert;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class ProductSearchSteps {
    public static SelenideElement searchField = $x("//input[@id='searchInput']");
    public static SelenideElement searchingResult = $x("//h1");

    @When("пользователь нажимает на поисковую строку")
    public void clickOnSearchField() {
        searchField.shouldBe(visible).click();
    }

    @And("пользователь вводит {string} в поисковую строку и нажимает Enter")
    public void enterRequest(String product) {
        searchField.sendKeys(product, Keys.ENTER);
    }

    @Then("пользователь должен перейти на страницу с текстом {string}")
    public void goToPageOfFoundProduct(String expectedText) {
        Assert.textPresence(searchingResult, expectedText);
    }
}
