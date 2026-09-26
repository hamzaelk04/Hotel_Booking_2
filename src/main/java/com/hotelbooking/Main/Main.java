package com.hotelbooking.Main;

import config.DatabaseInitializer;
import model.User;
import repository.JDBC.JdbcUserRepository;
import repository.UserRepository;
import view.main.MainView;

import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        DatabaseInitializer.initializeSchema();

        MainView.showMenu();
    }
}