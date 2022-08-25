package org.example;

import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Please enter your username");
        String username = scanner.nextLine();
        System.out.println("Please enter your password");
        String password = scanner.nextLine();
        System.out.println("Please tweet here!");
        String message = scanner.nextLine();


        App app = new App();
        app.singIn();
        app.information(username,password);
        app.tweet(message);

    }
}