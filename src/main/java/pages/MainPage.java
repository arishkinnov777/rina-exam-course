package pages;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class MainPage {
    public SelenideElement logoWebsite() {
        return $(".logo.img-responsive").as("лого сайта");
    }

    public SelenideElement firstNameProduct() {
        return $(byText("Faded Short Sleeve T-shirts"));
    };

    public SelenideElement secondNameProduct() {
        return $(byText("Blouse"));
    };

    public SelenideElement addToCart1() {
        return $("[data-id-product='1']").as("добавить в корзину одним кликом");
    }

    public SelenideElement addToCart2() {
        return $("[data-id-product='2']").as("добавить в корзину одним кликом");
    }

    public SelenideElement shoppingCart() {
        return $(byText("Cart")).as("корзина");
    }

    public SelenideElement headerCart() {
        return $(byText("Shopping-cart summary")).as("шапка страници с выбором разделов");
    }

    public ElementsCollection cartProductList() {
        return $$(".icon-trash").as("иконка удалить товар из корзины");
    }

    public SelenideElement sizeInput() {
        return $(".selector").as("инпут размера");
    }


}

