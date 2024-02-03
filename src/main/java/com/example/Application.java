package com.example;

import com.example.model.Person;

public class Application {
    public static void main(String[] args) {
        Person builderExample = new Person.Builder("John", "Doe", 32)
                .address("Lenina Sq.")
                .email("example@example.com")
                .phone("+0 (000) 000-00-00").build(); // FLUENT API (Потоковый API) Вызов через точку
    }
}
