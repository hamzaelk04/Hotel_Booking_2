package com.hotelbooking.Main;

import Config.DatabaseInitializer;
import View.Main.MainView;

public class Main {
    public static void main(String[] args) {
        DatabaseInitializer.initializeSchema();

        MainView.displayMainView();
    }
}