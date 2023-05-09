package app.oop_proj.general_logic;

import javax.swing.*;

public interface MenuBarInterface { // default methods for interface.

    default void exitTheProgramInMenu() {
        System.exit(0);
    }
    default void readInformation() {
        JOptionPane.showMessageDialog(null, "The travel tours program \"In.at\" for Austria is a software application designed" +
                " to help travelers plan their trips to Austria.\n The program provides a comprehensive list of tour packages, itineraries, and destinations for tourists\n who want to explore the country's beauty and culture.");
    }
}
