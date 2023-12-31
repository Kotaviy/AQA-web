package ru.netology;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CardRequestTest {
    @Test
    void shouldAcceptRequest() {
        open("http://localhost:9999");
        SelenideElement form = $(By.cssSelector(".form_size_m"));
        form.$("[data-test-id=name] input").setValue("Петрова Евгения");
        form.$("[data-test-id=phone] input").setValue("+79990000000");
        form.$("[data-test-id=agreement]").click();
        form.$(By.cssSelector(".button_size_m")).click();
        $("[data-test-id=order-success]").shouldHave(Condition.text("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));
    }
}