package main;

import main.logic.Mathematician;

public class App {

    public static void main(String[] args) {
        Mathematician mathematician = new Mathematician();
        System.out.println("The magic number is: " + mathematician.findWonderlandNumber());
    }
}
