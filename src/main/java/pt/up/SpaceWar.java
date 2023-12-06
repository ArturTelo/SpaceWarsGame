package pt.up;

import pt.up.controller.Controller;

import java.io.IOException;

public class SpaceWar {
    public static void main(String[] args) throws IOException {
        System.out.println("In a galaxy really, really far away, where the group 4 get's 20 in the LDTS project.");

        Controller controller = new Controller();
        controller.run();
    }
}