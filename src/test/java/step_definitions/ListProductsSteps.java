package step_definitions;

import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import steps.asserts.Assert;

import static com.codeborne.selenide.Condition.interactable;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class ListProductsSteps {
    public static SelenideElement catalogButton = $x("//button[contains(@class, 'j-menu-burger-btn')]");
    public static SelenideElement loadFirstProduct = $x("//div[@class='main-page__content']//article[1]");
    public static SelenideElement electronicsCatalog = $x("//a[contains(@class, '4830')]");
    public static SelenideElement electronicsCatalogTitle = $x("//h1");

    @When("пользователь нажимает на Фильтры")
    public void clickOnCatalog() {
        loadFirstProduct.shouldBe(visible);

        catalogButton.shouldBe(visible, interactable).click();
    }

    @And("пользователь нажимает на категорию Электроника")
    public void clickOnElectronics() {
        electronicsCatalog.shouldBe(visible).hover().shouldBe(interactable).click();
    }

    @Then("пользователь должен перейти на страницу {string}")
    public void goToCategoryPage(String expectedText) {
        Assert.textPresence(electronicsCatalogTitle, expectedText);
    }
}
