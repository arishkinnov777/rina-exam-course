import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;
import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.params.provider.Arguments.arguments;


@Owner("arishkinnov")
public class ShopTest {

    @Test
    @Story("")
    @DisplayName("Добавление товаров в корзину")
    public void shouldAuthorizeTest() {

        step("Перейти на сайт магазина", () -> {
            open("http://automationpractice.com/index.php");
            TestPage.mainPage.logoWebsite()
                    .shouldBe(visible);
        });

        step("Добавить 2 товара через быструю корзину", () -> {

            TestPage.mainPage.firstNameProduct() // навести курсор на наименование товара
                    .hover();
            TestPage.mainPage.addToCart1() // кликнуть на значок быстрой корзины
                    .click();
            TestPage.mainPage.logoWebsite()// кликнуть вне корзины (чтобы выйти из корзины)
                    .click();

            TestPage.mainPage.secondNameProduct() // навести курсор на наименование товара
                    .hover();
            TestPage.mainPage.addToCart2() // кликнуть на значок быстрой корзины
                    .click();
            TestPage.mainPage.logoWebsite() // кликнуть вне корзины (чтобы выйти из корзины)
                    .click();
        });

        step("Открыть корзину и проверить количество товаров", () -> {
            TestPage.mainPage.shoppingCart() //навести курсов на корзину
                    .hover();
            TestPage.mainPage.shoppingCart() // кликнуть на корзину
                    .click();

            TestPage.mainPage.headerCart() // текстовый элемент 'Shopping-cart summary' в корзине
                    .shouldBe(visible);

            TestPage.mainPage.cartProductList() // проверить размер корзины
                    .shouldHave(size(2));
        });
    }


    @MethodSource("incorrectCredentials")
    @ParameterizedTest(name = "{displayName} {0}")
    @Story("Авторизация негативный кейс")
    @DisplayName("Поиск товара по размеру:")
    public void shouldNotAuthorizeTest(String type,
                                       String url,
                                       String size) {
        step("Перейти по ссылке ", () -> {
            open(url);
        });

        step("Проверить, что ссылка ведет на определенный размер ", () -> {
            TestPage.mainPage.sizeInput()
                    .shouldBe(text(size));
        });

        sleep(5000);


    }

    static Stream<Arguments> incorrectCredentials() {
        return Stream.of(
                arguments(
                        "L",
                        "http://automationpractice.com/index.php?id_product=1&controller=product#/color-orange/size-l",
                        "L"

                ),
                arguments(
                        "M",
                        "http://automationpractice.com/index.php?id_product=1&controller=product#/color-orange/size-m",
                        "M"

                ),
                arguments(
                        "S",
                        "http://automationpractice.com/index.php?id_product=1&controller=product#/size-s",
                        "S"
                )
        );
    }
}

