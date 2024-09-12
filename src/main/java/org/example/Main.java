package org.example;

public class Main {
    public static void main(String[] args) {

        Line line = new Line(args);
        line.calculatePoints();
        System.out.println("Your score is: " + line.getPoints() + ". Congratulations!");
    }
}