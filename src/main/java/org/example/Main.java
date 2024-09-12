package org.example;

public class Main {
    /**
     *
     * @param args Command-line arguments entering data about frames (one line),
     *             each String contains either one or two rolls and is separated by a space.
     */
    public static void main(String[] args) {
        Line line = new Line(args);
        line.calculatePoints();
        System.out.println("Your score is: " + line.getPoints() + ". Congratulations!");
    }
}