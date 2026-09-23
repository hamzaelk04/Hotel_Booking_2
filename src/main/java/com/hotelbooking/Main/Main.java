package com.hotelbooking.Main;

import config.DatabaseInitializer;
import view.main.MainView;

public class Main {
    public static void main(String[] args) {
        DatabaseInitializer.initializeSchema();

        MainView.showMenu();
    }
}