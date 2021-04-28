package ru.myproject;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("ru.myproject");
        context.refresh();

        Game game = context.getBean(Game.class);
        game.run();
    }
}
