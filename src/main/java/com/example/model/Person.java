package com.example.model;

public class Person {
    private String name;
    private String surename;
    private int age;
    private String address;
    private String phone;
    private String email;

    private Person(Builder builder) {
        name = builder.name;
        surename = builder.surename;
        age = builder.age;;
        address = builder.address;
        phone = builder.phone;
        email = builder.email;
    }

    public static class Builder {
        // обязательные поля
        private String name;
        private String surename;
        private int age;

        // необязательные поля
        private String address = "";
        private String phone = "";
        private String email = "";

        public Builder(String name, String surename, int age) {
            this.name = name;
            this.surename = surename;
            this.age = age;
        }

        public Builder address(String address) {
            this.address = address;
            return this;
        }
        public Builder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Person build() {
            return new Person(this);
        }
    }
}
