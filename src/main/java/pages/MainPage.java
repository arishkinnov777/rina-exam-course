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
        return $(byText("Faded Short Sleeve T-shirts")).as("наименование первого товара");
    };

    public SelenideElement secondNameProduct() {
        return $(byText("Blouse")).as("наименование второго товара для корзины");
    };

    public SelenideElement addToCart1() {
        return $("[data-id-product='1']").as("кнопка добавить у первого товара");
    }

    public SelenideElement addToCart2() {
        return $("[data-id-product='2']").as("кнопка добавить у второго товара");
    }

    public SelenideElement shoppingCart() {
        return $(byText("Cart")).as("корзина");
    }

    public SelenideElement headerCart() {
        return $(byText("Shopping-cart summary")).as("текстовый элемент 'Общая стоимость в корзине'");
    }

    public ElementsCollection cartProductList() {
        return $$(".icon-trash").as("иконка удалить товар из корзины");
    }

    public SelenideElement sizeInput() {
        return $(".selector").as("инпут размера");
    }


}

