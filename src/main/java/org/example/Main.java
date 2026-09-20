package org.example;

import Config.DatabaseInitializer;

public class Main {
    public static void main(String[] args) {
        System.out.println("Testing PostgreSQL connection...");
        DatabaseInitializer.testAndInitialize();
    }
}