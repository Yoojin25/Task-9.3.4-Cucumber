package step_definitions;

import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import steps.asserts.Assert;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class AddToBasketSteps {
    public static SelenideElement addToBasketButton = $x("//article[1]//a[@href='/lk/basket']");
    public static SelenideElement cookiesButton = $x("//button[@class='cookies__btn btn-minor-md']");
    public static SelenideElement basketButton = $x("//span[contains(@class, 'navbar-pc__icon--basket')]");
    public static SelenideElement chatButton = $x("//button[contains(@class, 'btn-chat')]");
    public static SelenideElement productNameOnPage = $x("//article[1]//span[@class='product-card__name']");
    public static SelenideElement productPriceOnPage = $x("//article[1]//ins");
    public static SelenideElement productNameInBasket = $x("//span[@class='good-info__good-name']");
    public static SelenideElement productPriceInBasket = $x("//div[contains(@data-link, 'priceSumWith')]");

    private static String productNameOnPageText;
    private static String productPriceOnPageText;
    private static String productNameInBasketText;
    private static String productPriceInBasketText;

    @When("пользователь нажимает на кнопку “В корзину” у первого товара из списка")
    public void addToBasket() {
        cookiesButton.click();

        addToBasketButton.shouldBe(visible).click();

        productNameOnPageText = productNameOnPage.getText();
        productPriceOnPageText = productPriceOnPage.getText();
    }

    @And("пользователь нажимает на корзину")
    public void clickOnBasket() {
        basketButton.click();

        chatButton.shouldBe(visible);
    }

    @Then("текст и цена товара в корзине должны соответствовать названию и цене товара на странице")
    public void matchNameAndPrice() {
        productNameInBasketText = productNameInBasket.getText();
        productPriceInBasketText = productPriceInBasket.getText();

        Assert.textMatch(productNameOnPageText, productNameInBasketText);
        Assert.textMatch(productPriceOnPageText, productPriceInBasketText);
    }
}
