
> Краткий помощник по основным конструкциям, которые понадобятся в ЛР №3.  
> Здесь нет готовых решений заданий — только идеи, синтаксис и небольшие примеры.

---

## 1. Инкапсуляция

Инкапсуляция — это не только `private`, но и контроль корректности состояния объекта.

```text
инкапсуляция
=
скрытие состояния
+
контроль допустимых изменений
```

```java
public class Product {

    private final String article;
    private String name;
    private double price;
}
```

`private` запрещает прямой доступ к полю извне класса.

---

## 2. Геттеры и сеттеры

Геттер позволяет получить значение:

```java
public double getPrice() {
    return price;
}
```

Сеттер позволяет изменить его через метод:

```java
public void setPrice(double price) {
    this.price = price;
}
```

Главная польза сеттера — возможность проверить новое значение:

```java
public void setPrice(double price) {
    if (price < 0) {
        throw new IllegalArgumentException(
                "Цена не может быть отрицательной"
        );
    }

    this.price = price;
}
```

> Геттер и сеттер не обязаны существовать одновременно.

Если поле можно читать, но нельзя менять после создания, сеттер не нужен.

---

## 3. `final`

```java
private final String article;
```

После инициализации значение такого поля нельзя переназначить.

```java
public Product(
        String article,
        String name,
        double price
) {
    this.article = article;
    this.name = name;
    setPrice(price);
}
```

---

## 4. Исключения и `throw`

```java
if (price < 0) {
    throw new IllegalArgumentException(
            "Цена не может быть отрицательной"
    );
}
```

- `throw` — выбросить исключение;
- `IllegalArgumentException` — стандартное исключение для недопустимого аргумента;
- после `throw` обычное выполнение текущего метода прекращается.

```text
RuntimeException
       ↑
IllegalArgumentException
```

---

## 5. Собственное исключение

При необходимости можно создать собственное:

```java
public class NegativePriceException
        extends RuntimeException {

    public NegativePriceException(String message) {
        super(message);
    }
}
```

Использование:

```java
throw new NegativePriceException(
        "Цена не может быть отрицательной"
);
```

Для большинства задач ЛР №3 достаточно стандартных исключений.

---

## 6. Проверка должна работать и в конструкторе

Если проверка уже находится в сеттере, конструктор может использовать её:

```java
public Product(
        String article,
        String name,
        double price
) {
    this.article = article;
    this.name = name;
    setPrice(price);
}
```

Так правило хранится в одном месте.

---

## 7. Наследование — `extends`

Наследование позволяет создать новый класс на основе существующего.

```java
public class CardPayment
        extends PaymentMethod {
}
```

Можно читать так:

```text
CardPayment является PaymentMethod
```

---

## 8. Абстрактный класс

```java
public abstract class PaymentMethod {

    private String name;

    public PaymentMethod(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void pay(double amount);
}
```

Абстрактный класс можно использовать как общий тип и как родителя, но его объект напрямую создать нельзя:

```java
new PaymentMethod(...); // нельзя
```

---

## 9. Абстрактный метод

```java
public abstract void pay(double amount);
```

У такого метода нет реализации в базовом классе.

Конкретный наследник обязан реализовать его:

```java
@Override
public void pay(double amount) {
    System.out.println(
            "Оплата картой: " + amount
    );
}
```

---

## 10. `super(...)`

```java
public CardPayment(String cardNumber) {
    super("Банковская карта");
    this.cardNumber = cardNumber;
}
```

`super(...)` вызывает конструктор родительского класса.

---

## 11. Переопределение — `@Override`

```java
@Override
public void pay(double amount) {
    System.out.println(
            "Оплата картой: " + amount
    );
}
```

Наследник предоставляет свою реализацию метода родителя.

Не путайте:

```text
перегрузка
→ одно имя, разные параметры

переопределение
→ наследник, тот же метод, новая реализация
```

---

## 12. Полиморфизм

Разные объекты можно хранить через общий родительский тип:

```java
PaymentMethod[] payments = {
        new CardPayment("1234"),
        new CashPayment(),
        new BonusPayment(5000)
};
```

И использовать одинаково:

```java
for (PaymentMethod payment : payments) {
    payment.pay(1000);
}
```

При этом выполняется реализация метода реального объекта.

```java
PaymentMethod payment =
        new CardPayment("1234");
```

```text
тип ссылки      → PaymentMethod
реальный объект → CardPayment
```

При вызове:

```java
payment.pay(1000);
```

будет выполнен `CardPayment.pay()`.

---

## 13. Интерфейс

Интерфейс описывает общий контракт или способность:

```java
public interface Refundable {

    void refund(double amount);
}
```

---

## 14. `implements`

```java
public class CardPayment
        extends PaymentMethod
        implements Refundable {
```

После этого класс реализует методы интерфейса:

```java
@Override
public void refund(double amount) {
    System.out.println(
            "Возврат на карту: " + amount
    );
}
```

Разница:

```text
extends
→ "является"

implements
→ "умеет"
```

Пример:

```text
CardPayment extends PaymentMethod
→ карточная оплата является способом оплаты

CardPayment implements Refundable
→ карточная оплата умеет выполнять возврат
```

---

## 15. Полиморфизм через интерфейс

```java
Refundable[] payments = {
        new CardPayment("1234"),
        new BonusPayment(5000)
};
```

```java
for (Refundable payment : payments) {
    payment.refund(500);
}
```

Здесь важен не конкретный класс, а то, что объект реализует `Refundable`.

---

## 16. `==` и `equals()`

Для объектов:

```java
first == second
```

проверяет, указывают ли ссылки на один объект.

Если нужно определить логическое равенство, переопределяется `equals()`.

Например, товары считаются одинаковыми при одинаковом артикуле:

```java
@Override
public boolean equals(Object obj) {
    if (this == obj) {
        return true;
    }

    if (!(obj instanceof Product)) {
        return false;
    }

    Product other = (Product) obj;

    return article.equals(other.article);
}
```

```text
==
→ один и тот же объект?

equals()
→ считаем ли мы объекты равными
  по правилам класса?
```

Также существует еще один вариант реализации метода equals:

```java
@Override  
public boolean equals(Object obj) {  
    if (obj == null || getClass() != obj.getClass()) return false; 
     
    Product product = (Product) obj;  
    return Objects.equals(article, product.article) && Objects.equals(name, product.name);  
}
```

---

## 17. Пакеты

Пакеты группируют логически связанные классы.

```text
ru.surname.shop.product
    Product
    ProductCatalog

ru.surname.shop.payment
    PaymentMethod
    CardPayment
    CashPayment
    BonusPayment
    Refundable

ru.surname.shop.main
    Main
```

В начале файла:

```java
package ru.surname.shop.product;
```

Импорт:

```java
import ru.surname.shop.product.Product;
```

---

## 18. Модификаторы доступа

### `private`

```java
private double price;
```

Доступ только внутри класса.

### package-private

Если модификатор не указан:

```java
class ProductValidator {
}
```

доступ есть у классов того же пакета.

### `protected`

Удобно для служебного поведения родителя, которое должны использовать наследники:

```java
public abstract class PaymentMethod {

    protected void validateAmount(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException(
                    "Сумма должна быть положительной"
            );
        }
    }

    public abstract void pay(double amount);
}
```

Наследник:

```java
@Override
public void pay(double amount) {
    validateAmount(amount);

    System.out.println(
            "Оплата картой: " + amount
    );
}
```

Кратко:

```text
private
→ только класс

package-private
→ класс + пакет 

protected
→ класс + пакет + наследники

public
→ класс + пакет + наследники + другие классы
```

---

## 19. Собственная структура данных

Структура данных — обычный класс, который хранит набор значений и предоставляет операции над ними.

```java
public class ProductCatalog {

    private Product[] products =
            new Product[0];

    public int size() {
        return products.length;
    }

    public boolean isEmpty() {
        return products.length == 0;
    }

    public Product get(int index) {
        if (index < 0
                || index >= products.length) {

            throw new IndexOutOfBoundsException(
                    "Некорректный индекс"
            );
        }

        return products[index];
    }
}
```

```text
структура данных
=
состояние
+
операции над состоянием
```

---

## 20. Клонирование

Обычное присваивание:

```java
Product second = first;
```

не создаёт новый объект:

```text
first  ──┐
         ├──→ один Product
second ──┘
```

Клонирование должно создавать отдельный объект со скопированным состоянием:

```text
first  ──→ Product A
second ──→ Product B
```

---