#### SOLID
Принцип единственной ответственности (SRP):   
Этот принцип говорит о том, что каждый класс должен иметь только одну причину для изменения. Он должен быть ответственным только за одну конкретную функциональность или задачу. Например, у нас есть класс User, который отвечает за хранение информации о пользователе. Если мы добавляем в этот класс методы для работы с базой данных, валидацией данных и отправкой уведомлений, то он нарушает принцип единственной ответственности. Вместо этого, мы можем создать отдельные классы, такие как UserRepository, UserValidator и UserNotifier, которые будут отвечать за соответствующие задачи.   
Пример:
```
// Класс, отвечающий за хранение информации о пользователе
public class User {
    private String name;
    private String email;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    // Геттеры и сеттеры для полей name и email
    // ...
}

// Класс, отвечающий за CRUD операции
public class UserRepository {
    // Метод для сохранения пользователя в базе данных
    public void save() {
        // Логика сохранения пользователя в базе данных
    }
    
    // Прочие методы, лтвечающие за CRUD
    // ...
}

// Класс, отвечающий за валидацию данных пользователя
public class UserValidator {
    public boolean validate(User user) {
        // Логика валидации данных пользователя
        return true; // Возвращаем результат валидации
    }
}

// Класс, отвечающий за отправку уведомлений
public class UserNotifier {
    public void sendNotification(User user, String message) {
        // Логика отправки уведомления пользователю
    }
}
```

Принцип открытости/закрытости (OCP):   
Этот принцип говорит о том, что классы должны быть открыты для расширения, но закрыты для модификации. Вместо изменения существующего кода, мы должны добавлять новый код для изменения поведения класса. Например, у нас есть класс Shape, который имеет метод calculateArea(). Если мы хотим добавить новую фигуру, например, треугольник, мы можем создать новый класс Triangle, который наследуется от Shape и переопределяет метод calculateArea().   
Пример:
```
// Суперкласс Shape
public abstract class Shape {
    public abstract double calculateArea();
}

// Подкласс Circle
public class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}

// Подкласс Rectangle
public class Rectangle extends Shape {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double calculateArea() {
        return width * height;
    }
}

// Подкласс Triangle
public class Triangle extends Shape {
    private double base;
    private double height;

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    public double calculateArea() {
        return 0.5 * base * height;
    }
}

public class Example {
    public static void main() {
        Shape circle = new Circle(5);
        double circleArea = circle.calculateArea();
        System.out.println("Circle area: " + circleArea);
        
        Shape rectangle = new Rectangle(4, 6);
        double rectangleArea = rectangle.calculateArea();
        System.out.println("Rectangle area: " + rectangleArea);
        
        Shape triangle = new Triangle(3, 4);
        double triangleArea = triangle.calculateArea();
        System.out.println("Triangle area: " + triangleArea);
    }
}
```

Принцип подстановки Барбары Лисков (LSP):   
Этот принцип говорит о том, что объекты должны быть заменяемыми своими подтипами без изменения корректности программы. Это означает, что подклассы должны соблюдать все контракты и предусловия суперкласса. Например, у нас есть класс Bird, у которого есть метод fly(). Если мы создаем подкласс Penguin, который не умеет летать, то он нарушает принцип LSP. Вместо этого, мы можем создать интерфейс IFlyable, который будет реализовываться только классами, которые могут летать.   
Пример:
```
// Суперкласс Bird
public class Bird {
    public void fly() {
        // Логика полета птицы
    }
}

// Подкласс Penguin
public class Penguin extends Bird {
    // Пингвины не умеют летать, поэтому не переопределяем метод fly()
}

// Подкласс Eagle
public class Eagle extends Bird {
    public void fly() {
        // Логика полета орла
    }
}

public class Example {

    public static void makeBirdFly(Bird bird) {
        bird.fly();
    }
    
    public static void main() {
        Bird bird = new Bird();
        makeBirdFly(bird); // Полетит
    
        Penguin penguin = new Penguin();
        makeBirdFly(penguin); // Не полетит, но не вызовет ошибку
        
        Eagle eagle = new Eagle();
        makeBirdFly(eagle); // Полетит
    }
}
```

Принцип разделения интерфейса (ISP):   
Этот принцип говорит о том, что клиенты не должны зависеть от интерфейсов, которые они не используют. Интерфейсы должны быть маленькими и специфичными для конкретных клиентов. Например, у нас есть интерфейс Vehicle, который имеет методы drive() и refuel(). Если у нас есть класс Car, который реализует интерфейс Vehicle, но не использует метод refuel(), то он нарушает принцип ISP. Вместо этого, мы можем разделить интерфейс на два: Drivable, который будет иметь метод drive(), и Refuelable, который будет иметь метод refuel().   
Пример:
```
// Интерфейс для управления движением
public interface Movable {
    void move();
}

// Интерфейс для управления заправкой
public interface Refuelable {
    void refuel();
}

// Класс автомобиля, реализующий интерфейсы Movable и Refuelable
public class Car implements Movable, Refuelable {
    public void move() {
        // Логика движения автомобиля
    }

    public void refuel() {
        // Логика заправки автомобиля
    }
}

// Класс мотоцикла, реализующий только интерфейс Movable
public class Motorcycle implements Movable {
    public void move() {
        // Логика движения мотоцикла
    }
}
```

Принцип инверсии зависимостей (DIP):   
Этот принцип говорит о том, что модули верхнего уровня не должны зависеть от модулей нижнего уровня. Оба должны зависеть от абстракций. Это означает, что зависимости должны быть инвертированы, чтобы классы зависели от абстракций, а не от конкретных реализаций. Например, у нас есть класс OrderService, который зависит от класса OrderRepository. Вместо того, чтобы создавать экземпляр OrderRepository внутри OrderService, мы можем передать его через конструктор или метод, используя абстракцию, например, интерфейс IOrderRepository.   
Пример:
```
// Абстракция для репозитория заказов
public interface OrderRepository {
    void save(Order order);
}

// Конкретная реализация репозитория заказов
public class DatabaseOrderRepository implements OrderRepository {
    public void save(Order order) {
        // Логика сохранения заказа в базе данных
    }
}

// Сервис для обработки заказов
public class OrderService {
    private OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void processOrder(Order order) {
        // Логика обработки заказа
        orderRepository.save(order); // Используем абстракцию OrderRepository
    }
}
```